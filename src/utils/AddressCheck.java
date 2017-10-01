/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Mxsxs2
 */
public class AddressCheck {
    public Boolean openURL(String urladdress, String Address, String currency){
        try {
            URL u=new URL(urladdress+"?a="+Address+"&t="+currency);
            System.out.println(u);
            URLConnection conn = u.openConnection();
            BufferedReader br = new BufferedReader(
                                new InputStreamReader(conn.getInputStream()));
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                if(inputLine.equals("1")){
                    br.close();
                    return true;
                }else{
                    br.close();
                    return false;
                }    
                
            }
        } catch (MalformedURLException e) {
            
            return false;
        } catch (IOException e) {
            return false;
        }
         return false;
    }
}
