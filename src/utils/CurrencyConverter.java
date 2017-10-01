/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mxsxs2
 */
public class CurrencyConverter {
    private String Address;
    private String Result;
    private String LastConverted;
    private float[] ChangeValues;
    public CurrencyConverter(String url){
        this.Address=url;
    }
    public String NXTtoBTC(String NXT){
        if(Float.parseFloat(NXT)>0){
            this.Address=this.Address.split("\\?")[0];
            this.Address+="?nxt="+NXT;
        }
        this.Result=this.openURL();
        this.LastConverted="NXT_BTC";
        return this.Result;
    }
    public String XEMtoBTC(String parameters){
        if(!parameters.equals("")){
            this.Address=this.Address.split("\\?")[0];
            this.Address+="?"+parameters;
        }
        this.Result=this.openURL();
        this.LastConverted="XEM_BTC";
        return this.Result;
    }
    public String getResult(){
        return this.Result;
    }
    private String openURL(){
        try {
            //System.out.println(this.Address);
            URLConnection conn = new URL(this.Address).openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String Line=br.readLine();
            br.close();
            return Line;
        } catch (NumberFormatException | IOException ex) {
            Logger.getLogger(CurrencyConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Error";
    }
    public String getLastConversionType(){
        return this.LastConverted;
    }
    public void setChangeValues(float NXTinBTC,float BTCinXEM, float NXTinXEM){
        this.ChangeValues=new float[]{NXTinBTC,BTCinXEM,NXTinXEM};
    }
    public double convertWithValues(String From, String To, String Value){
        //ChangeValues[0] is NXTinBTC
        //ChangeValues[1] is BTCinXEM
        //ChangeValues[2] is NXTinXEM
        //If the value is 0 or less then return 0
        if(Double.parseDouble(Value)<=0) return 0.0;
        //If there is no conversion needed return back the value
        if(From.equals(To)) return Double.parseDouble(Value);
        //Convert from NXT
        if(From.equals("NXT") && To.equals("BTC")) return Double.parseDouble(Value)/this.ChangeValues[0];
        //System.out.println(Double.parseDouble(Value)+"*"+this.ChangeValues[0]+"/"+this.ChangeValues[1]);
        if(From.equals("NXT") && To.equals("XEM")) return Double.parseDouble(Value)/this.ChangeValues[0]/this.ChangeValues[1];
        //Convert from BTC
        if(From.equals("BTC") && To.equals("NXT")) return this.ChangeValues[0]*Double.parseDouble(Value);
        if(From.equals("BTC") && To.equals("XEM")) return Double.parseDouble(Value)/this.ChangeValues[1];
        //Convert from XEM
        if(From.equals("XEM") && To.equals("BTC")) return this.ChangeValues[1]*Double.parseDouble(Value);
        if(From.equals("XEM") && To.equals("NXT")) return this.ChangeValues[1]*this.ChangeValues[0]*Double.parseDouble(Value);
        //return -1 if there was no matching conversion pairs
        return 1;
    }
}
