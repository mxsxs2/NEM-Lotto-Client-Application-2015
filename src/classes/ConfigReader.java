/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import frame.Payout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Mxsxs2
 */
public class ConfigReader implements Runnable{
    private String AddressCheck="";
    private String CurrencyExchange="";
    private String NXTURL="";
    private String NISURL="";
    private String BTCURL="";
    private Boolean Status;
    private final String[] Database=new String[]{"","","",""};
    private final File Conf=new File("config.conf");
    private String Error="";
    public ConfigReader(){
        //this.readConfigFile();
    }
    public boolean readDatabaseDetails(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(this.Conf));
            String text;
            while ((text = reader.readLine()) != null) {
                if(text.charAt(0)!='#' && text.indexOf('=')!=-1){
                    String[] line=text.split("=");
                    if(line[1].length()>3){
                        if(line[0].equals("url"))                                     this.Database[0]=line[1];
                        if(line[0].equals("db"))                                      this.Database[1]=line[1];
                        if(line[0].equals("dbuser"))                                  this.Database[2]=line[1];
                        if(line[0].equals("dbpass"))                                  this.Database[3]=line[1];
                    }
                }
             }
        } catch (Exception  e) {
            //e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
        return this.chkDBConnection(this.Database[0], this.Database[1], this.Database[2], this.Database[3]);
    }
    public boolean readConfigFile(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(this.Conf));
            String text;
            while ((text = reader.readLine()) != null) {
                if(text.charAt(0)!='#' && text.indexOf('=')!=-1){
                    String[] line=text.split("=");
                    if(line.length>1 && line[1].length()>0){
                        //System.out.println(line[1]);
                        if(line[0].equals("url"))                                     this.Database[0]=line[1];
                        if(line[0].equals("db"))                                      this.Database[1]=line[1];
                        if(line[0].equals("dbuser"))                                  this.Database[2]=line[1];
                        if(line[0].equals("dbpass"))                                  this.Database[3]=line[1];
                        if(line[0].equals("ac")&& this.checkURLs(new URL(line[1])))   this.AddressCheck=line[1];
                        if(line[0].equals("ce")&& this.checkURLs(new URL(line[1])))   this.CurrencyExchange=line[1];
                        if(line[0].equals("nxt")&& this.checkURLs(new URL(line[1])))  this.NXTURL=line[1];
                        if(line[0].equals("nis")&& this.checkURLs(new URL(line[1]+"heartbeat")))  this.NISURL=line[1];
                        if(line[0].equals("btc")&& this.checkURLs(new URL(line[1])))  this.BTCURL=line[1];
                    }
                }
             }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
        return this.checkError();
    }
    private boolean checkURLs(URL data){
         try {
            // get URL content

            URLConnection conn = data.openConnection();
            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                                new InputStreamReader(conn.getInputStream()));
            br.close();


        } catch (MalformedURLException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
         return true;
    }
    private boolean checkError(){
        if(this.AddressCheck.length()<3){
            this.Error="Can't check addresses.";
        }
        if(this.CurrencyExchange.length()<3){
            this.Error="Can't exchange currencies.";
        }
        if(this.NXTURL.length()<3){
            this.Error="Can't connect to NXT("+this.NXTURL+").";
        }
        if(this.NISURL.length()<3){
            this.Error="Can't connect to NIS("+this.NISURL+").";
        }
        if(this.BTCURL.length()<3){
            this.Error="Can't connect to BTC("+this.BTCURL+").";
        }
        if(!this.chkDBConnection(this.Database[0], this.Database[1], this.Database[2], this.Database[3])){
            this.Error="Can't connect to database.";
        }
        return this.Error.equals("");
        //return !(this.AddressCheck.length()<3 || this.CurrencyExchange.length()<3 || !this.chkDBConnection(this.Database[0], this.Database[1], this.Database[2], this.Database[3]));
    }
    public String checkServer(String Address, String Type){
        try{
            if(Type.equals("nxt")){
                Address+="nxt?requestType=getTime";
            }
            if(Type.equals("nem")){
                Address+="heartbeat";
            }
         URL url = new URL(Address);
            HttpURLConnection connection =(HttpURLConnection)url.openConnection();
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.90 Safari/537.36");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            
            InputStream IS;
            if(connection.getResponseCode()==200){
                IS = connection.getInputStream();
            }else{
                IS = connection.getErrorStream();
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(IS));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                System.out.println(line);
            }
            org.json.JSONObject json= new org.json.JSONObject(sb.toString());                       //parse to JSON
            
            if(Type.equals("nxt") && !json.isNull("time")) return "true";                           //could connect to nxt
            if(Type.equals("nem") && !json.isNull("message")){                                         
                   if(json.getString("message").equals("ok")) return "true";                        //could connect to nem
                   return json.getString("message");
            }
        } catch (JSONException | NumberFormatException | IOException ex) {
                Logger.getLogger(Payout.class.getName()).log(Level.SEVERE, null, ex);
               
        }
        return "false";
    }
    public String[] getValues(){
        return new String[]{this.AddressCheck,
                            this.CurrencyExchange, 
                            this.NXTURL,
                            this.Database[0],       //url 
                            this.Database[1],       //db    
                            this.Database[2],       //username 
                            this.Database[3],       //pass
                            this.NISURL,
                            this.BTCURL
        };      
                            
    }
    public String[] getDBDetails(){
        return new String[]{this.Database[0],       //url 
                            this.Database[1],       //db    
                            this.Database[2],       //username 
                            this.Database[3]};      //pass
    }
    public String getError(){
        return this.Error;
    }
    private boolean chkDBConnection(String URL, String DB,String User,String Pass){
        java.sql.Connection Connect=null;
        Boolean Connected=false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connect = java.sql.DriverManager.getConnection(URL+DB,User,Pass);
            Connected=true;
        } catch (ClassNotFoundException | SQLException ex) {
            //Logger.getLogger(ConfigReader.class.getName()).log(Level.SEVERE, null, ex);
            Connected=false;
        }finally{
            org.apache.commons.dbutils.DbUtils.closeQuietly(Connect);
        }
        return Connected;
    }

    @Override
    public void run() {
        this.readConfigFile();
    }
    public boolean getStatus(){
        return this.Status;
    }
}
