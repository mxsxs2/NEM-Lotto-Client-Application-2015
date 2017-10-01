/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Mxsxs2
 */
public class GetNXT extends Entries{
    public GetNXT(String URL){
        this.URL=URL;
    }
    public Boolean openURL(String Address, String Option){
        this.Option=Option;
        String string = "2013/11/24 12:00";
        java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm", java.util.Locale.ENGLISH);
        try {
            java.util.Date FirstBlock = format.parse(string);
            InputStream is = new URL(this.URL+"requestType=getAccountTransactions&account="+Address).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, java.nio.charset.Charset.forName("UTF-8")));
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = rd.read(chars)) != -1) buffer.append(chars, 0, read); 
            JSONObject json = new JSONObject(buffer.toString());
            if(!json.isNull("errorCode")) return false;               //If there is no transactions return false;
            JSONArray nameArray = json.names();
            JSONArray TotalArray = json.toJSONArray(nameArray);
            JSONArray Transactions = TotalArray.getJSONArray(1);
            for(int i = 0; i < Transactions.length(); i++){
                    java.util.Date Date=new java.sql.Timestamp(Transactions.getJSONObject(i).getLong("timestamp"));
                    Date=new java.util.Date(Date.getTime()+FirstBlock.getTime());
                    String parsedDate=format.format(Date);                      //parese the tsring into date
                    //System.out.println("in");
                    String[] Details= new String[]{
                        Transactions.getJSONObject(i).getString("transaction"),           //0 Transaction id
                        Transactions.getJSONObject(i).getString("senderRS"),              //1 Sender
                        Float.toString(Transactions.getJSONObject(i).getLong("amountNQT")/100000000)+" (NXT)", //2 The amount and convert it to NXT from NQT
                        Option,                                                           //3 Choosen option
                        "nxt",                                                            //4 Currency
                        parsedDate,                                                       //5 Date
                        this.matchDB(Transactions.getJSONObject(i).getString("senderRS")) //6 NEM address or false
                    };
                    if(!this.list.contains(Details)){
                        this.list.add(Details);
                        this.setAmountsAndEntries(Integer.parseInt(Option), Transactions.getJSONObject(i).getDouble("amountNQT"), Details[6]); //add the amount and rise the entries
                    }
            }
            rd.close();
            is.close();
        } catch (ParseException | IOException | JSONException e) {
            //e.printStackTrace();
        }
        return false;
    }
    private String matchDB(String Sender){
        String state="SELECT `entry`.`sender`,"
                          + "`entry`.`nem`"
                          + "FROM `entry` "
                          + "WHERE `entry`.`sender`=?"
                          + "AND   `entry`.`type`='nxt'"
                          + "AND   `entry`.`option`=?"
                          + "LIMIT 1";
        PreparedStatement statement=null;
        ResultSet RS=null;
        String nem="false";
        try{
            statement=SQL.Connect.prepareStatement(state);
            statement.setString(1, Sender);
            statement.setString(2, this.Option);
            RS=statement.executeQuery();
            if(RS.first()){
                    nem=RS.getString("nem");
            }
        }catch(SQLException ex){
        }finally{
            org.apache.commons.dbutils.DbUtils.closeQuietly(statement);
            org.apache.commons.dbutils.DbUtils.closeQuietly(RS);
        }
        return nem;
    }
    public String[][] getArray(){
        String[][] arr=new String[this.list.size()][6];
        for(int i=0; i<this.list.size(); i++){
            for (String get : this.list.get(i)) {
                arr[i]=this.list.get(i);
            }
        }
        return arr;
    }
}
