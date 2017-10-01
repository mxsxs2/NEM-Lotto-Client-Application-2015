/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import classes.DBdump;
import java.io.File;
import java.io.IOException;
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
public class CreateSpreadSheet {
    private String DIR;
    private String FileName;
    private String[][] Data;
    private String SheetName;
    private WritableWorkbook WBook;
    private WritableSheet WSheet;
    private void createFile() throws IOException{
            this.WBook = Workbook.createWorkbook(new File(this.DIR+this.FileName+".xls"));
            this.WSheet = this.WBook.createSheet(this.SheetName, 0);
    }
    public void createSpreadFormat(){
        try {
           
            jxl.write.Label label = new jxl.write.Label(0, 2, "A label record");
            this.WSheet.addCell(label);
            jxl.write.Number number = new jxl.write.Number(3, 4, 3.1459);
            this.WSheet.addCell(number);
            this.WBook.write();
            this.WBook.close();
        } catch (IOException | WriteException ex) {
            Logger.getLogger(DBdump.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
