/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import frame.Payout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

/**
 *
 * @author Mxsxs2
 */
public class GetNisNodeTime {
    private String[] CR;
    private long Time=0;
    public GetNisNodeTime(String[] CR){
        this.CR=CR;
    }
    private void LoadTime(){
        try{
         URL url = new URL(this.CR[7]+"time-sync/network-time");
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
            org.json.JSONObject json= new org.json.JSONObject(sb.toString());                       //arse to JSON
            
            if(json.isNull("message") && !json.isNull("sendTimeStamp")){                                         //CHECK ERROR CODE
                this.Time=json.getLong("sendTimeStamp")/1000;
            }else{
                this.Time=0;
            }
        } catch (JSONException | NumberFormatException | IOException ex) {
                Logger.getLogger(Payout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public long getTime(){
        this.LoadTime();
        return this.Time;
    }
}
