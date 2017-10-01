/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileOutputStream;

/**
 *
 * @author Mxsxs2
 */
public final class ArrayToCSV {
    private final String[][] TableRows;
    private final String FileName;
    public ArrayToCSV(String[][] Data, String FileName){
        this.TableRows=Data;
        this.FileName=FileName;
        this.createCSVFormat();
        this.createFile();
    }
    private void createCSVFormat(){
        int CollumnsSize=this.TableRows[0].length;                                          //Get the size of the collumns
        int RowIndex=0;                           
        for(String[] Row:this.TableRows){                                                   //Go trought every single Row
            int CollumnIndex=0;
            //System.out.println(Row[CollumnIndex]);
            for(String Value:Row){                                                          //Go trough every collumn in the row
                if(CollumnIndex<=CollumnsSize-1) Row[CollumnIndex]+=","; //Add "," unless its not the end
                CollumnIndex++;
            }
            RowIndex++;
        }
    }
    private boolean createFile(){
        File Dir = new File("csv/");                             //Get folder
        boolean result;
        if (!Dir.exists()) {                                                    //Check if it exists
            try{
                Dir.mkdir();                                                    //If not then create it
                result = true;
            } catch(SecurityException se){
                se.printStackTrace();
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
                    ex.printStackTrace();
                    return false;
                }
                
            }   
        
        return true;
    }
}
