/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Mxsxs2
 */
public class DBdump {
    private final frame.MysqlAccess SQL= new frame.MysqlAccess();
    private String Table;
    private String[] CollumnNames;
    private String[][] TableRows;
    public void dumpTable(String Table){
        this.Table=Table;                                                       //Set table name
        try{
            if(this.selectCollumnNames()){                                      //Get collumns
                if(this.selectRows()){                                          //Get rows
                    this.addCollumnNames();                                     //Create an union of them
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public boolean createCSV(){                                                 
        this.createCSVFormat();                                                 //Create a csv Format from the array
        return this.createFile();                                               //Write the file
    }
    public void resetClass(){
        this.Table=null;
        this.CollumnNames=null;
        this.TableRows=null;
    }
    private Boolean selectCollumnNames() throws SQLException{
        PreparedStatement statement = this.SQL.Connect.prepareStatement("  SELECT COLUMN_NAME" +
                                                                        "  FROM INFORMATION_SCHEMA.COLUMNS" +
                                                                        "  WHERE table_name = ?");
        statement.setString(1, this.Table);                           //Add table name to select
        ResultSet RS=statement.executeQuery();                        //Run select              
        if(RS.first()){                                               //If there is any line              
            RS.last();
            CollumnNames=new String[RS.getRow()];                     //Set the collumn Names Array's size
            RS.beforeFirst();                                         //Set the cursor back to 0
            int Index=0;                                              
            while(RS.next()){                      
                this.CollumnNames[Index]=RS.getString(1);             //Add the collumn name into the array
                Index++;
            }
            return true;                                              //True if there was any result
        }
        for(String cn:this.CollumnNames){
            //System.out.println(cn);
            break;
        }
        return false;                                                 //False if there wasnt result.
    }
    private boolean selectRows() throws SQLException{                 //Select the rows from the table
        String state="SELECT ";
        int Last=this.CollumnNames.length;                            //Get the Last collumns index
        int Index=0;
        for(String Collumn:this.CollumnNames){                        //Add the collumn names to the select
            state+="`"+Collumn+"`";
            if(Index<Last-1) state+=", ";                               //Add , after the collumn names unless its the last.
            Index++;
        }
        state+=" FROM "+this.Table;    
        PreparedStatement Statement = this.SQL.Connect.prepareStatement(state); //Create statement
        ResultSet RS=Statement.executeQuery();                                  //Run select
        if(RS.first()){                                                         //If there wasn any reuslt
            RS.last();
            this.TableRows=new String[RS.getRow()+1][Last];                     //Create the Rows array [number of rows][number of collumns]
            RS.beforeFirst();                                                   //Back to 0
            int RowIndex=1;
            while(RS.next()){
                for(int CollumnIndex=1; CollumnIndex<=Last; CollumnIndex++){            //it will run exactly as long it gtes the last collumn
                    this.TableRows[RowIndex][CollumnIndex-1]=RS.getString(CollumnIndex);//Insert into the [rownumber][collumn]
                }
                RowIndex++;
            }
            return true;
        }
        return false;
    }
    private void addCollumnNames(){
        this.TableRows[0]=this.CollumnNames;
    }
    public void createSpreadFormat(){
        try {
            WritableWorkbook wworkbook;
            wworkbook = Workbook.createWorkbook(new File("output.xls"));
            WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
            jxl.write.Label label = new jxl.write.Label(0, 2, "A label record");
            wsheet.addCell(label);
            jxl.write.Number number = new jxl.write.Number(3, 4, 3.1459);
            wsheet.addCell(number);
            wworkbook.write();
            wworkbook.close();
        } catch (IOException | WriteException ex) {
            Logger.getLogger(DBdump.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void createCSVFormat(){
        int CollumnsSize=this.TableRows[0].length-1;                                          //Get the size of the collumns
        int RowIndex=0;                           
        for(String[] Row:this.TableRows){                                                   //Go trought every single Row
            int CollumnIndex=0;
            for(String Value:Row){                                                          //Go trough every collumn in the row
                if(CollumnIndex<=CollumnsSize-1) this.TableRows[RowIndex][CollumnIndex]+=","; //Add "," unless its not the end
                CollumnIndex++;
            }
            RowIndex++;
        }
    }
    private boolean createFile(){
        File Dir = new File("archive/"+this.Table);                             //Get folder
        boolean result;
        if (!Dir.exists()) {                                                    //Check if it exists
            try{
                Dir.mkdir();                                                    //If not then create it
                result = true;
            } catch(SecurityException se){
                return false;
            }
        }else{
            result=true;
        }
            if(result) {                                                        //If the folder exists
                try {
                    java.text.SimpleDateFormat dt = new java.text.SimpleDateFormat("yyyyy-mm-dd_hh-mm-ss"); 
                    String Filename = dt.format(new java.util.Date());                                      //Create the file name what is the date
                    FileOutputStream out = new FileOutputStream(Dir.getAbsolutePath()+"/"+Filename+".csv"); //Create the file
                    for(String[] Row:this.TableRows){                           //Go trough the rows                   
                        String Line="";
                        for(String Collumn:Row){
                            Line+=Collumn;                                      //Concat the collumns into a line
                        }
                        out.write(Line.getBytes());                             //Write the line into the file
                        out.write('\n');                                        //Write the line brake
                    }
                        out.flush();
                        out.close();                                            //Close the file
                } catch (Exception ex) {
                    return false;
                }
                
            }   
        
        return true;
    }
    
}
