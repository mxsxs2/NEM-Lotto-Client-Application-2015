/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package options;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mxsxs2
 * Just create a new instance of the class with the given parameters.
 * URLAddress is the address for nxt
 * Keys are the request parameters
 * Values are the values for each request parameters at SAME order
 * The size of the Keys array has to be the same as the size of Values
 */
public class POSTRequestNXT {
    
    public POSTRequestNXT(String URLAddress, String[] Keys, String[] Values){
        try {
            this.doPOSTRequest(URLAddress, Keys, Values);
        } catch (Exception ex) {
            Logger.getLogger(POSTRequestNXT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private boolean doPOSTRequest(String URLAddress, String[] Keys, String[] Values) throws Exception{
        
        //change from this
        URL url = new URL(URLAddress);                                           //The url for nxt/nis
        Map<String,Object> params = new LinkedHashMap<>();                      //Parameters hasmap
        if(Keys.length!=Values.length) return false;
        for(int i=0; i<Keys.length; i++) params.put(Keys[i], Values[i]);        //Tkae parameters to map
        
        StringBuilder postData = new StringBuilder();                       
        for (Map.Entry<String,Object> param : params.entrySet()) {                          //Add parameters
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");                               //set charset
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");                                                              //set request type
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            //check answer from the server line by line. or parse it to JSON
        }
        org.json.JSONObject json= new org.json.JSONObject(sb.toString());                       //arse to JSON
        if(json.isNull("errorCode")){                                                           //CHECK ERROR CODE
            //DO SOMETHING WITH ERROR
        }
        return true;
    }
}
