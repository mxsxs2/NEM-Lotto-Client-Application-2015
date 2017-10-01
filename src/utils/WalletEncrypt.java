/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author Mxsxs2
 */
public class WalletEncrypt {
    public String pswd(String Creator, String Time){          //generate the password from the details given
        try{
            PBEKeySpec spec = new PBEKeySpec(Creator.toUpperCase().toCharArray(), Time.getBytes(), 100, 512);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            //System.out.println("pswd="+this.toHex(skf.generateSecret(spec).getEncoded()));
            return this.toHex(skf.generateSecret(spec).getEncoded());
        }catch(InvalidKeySpecException | NoSuchAlgorithmException e){
            //e.printStackTrace();
        }
        return null;
    }
    private String toHex(byte[] array) throws NoSuchAlgorithmException
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
        {
            return String.format("%0"  +paddingLength + "d", 0) + hex;
        }else{
            return hex;
        }
    }
}
