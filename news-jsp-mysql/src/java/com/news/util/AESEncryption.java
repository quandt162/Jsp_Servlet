/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.news.util;

import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.*;
/**
 *
 * @author Designer Nguyễn
 */
public class AESEncryption {
        //THO 13/11/2013  
	//http://docs.oracle.com/javase/7/docs/api/javax/crypto/Cipher.html
	//  "algorithm/mode/padding" or  "algorithm"
	//PHP & Test: http://www.coderelic.com/examples/AES_Encryption_Example.php 
	
	private static final String characterEncoding = "UTF-8";
    private static final String cipherTransformation = "AES/CBC/PKCS5Padding";
    private static final String aesEncryptionAlgorithm = "AES";
    //public static String KEY_AES = "OQGEQQQ7Y4CIUFYC";//tin.vn
    //public static String KEY_AES = "PZMDPMH27HK15AAT";//ale.vn
    //key for localhost
    public static String KEY_AES = "JOKS127563AIIY1K";
    //key for nhathuoc.net
    //public static String KEY_AES = "Y23SM5FWCM62WI67";    
    public static final String KEY_AES_BRANDNAME = "YQO9CFITW40O0QBH";
    
    public static  byte[] decrypt(byte[] cipherText, byte[] key, byte [] initialVector) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
    {
        Cipher cipher = Cipher.getInstance(cipherTransformation);
        SecretKeySpec secretKeySpecy = new SecretKeySpec(key, aesEncryptionAlgorithm);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpecy, ivParameterSpec);
        cipherText = cipher.doFinal(cipherText);
        return cipherText;
    }
 
    public static byte[] encrypt(byte[] plainText, byte[] key, byte [] initialVector) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
    {	
        Cipher cipher = Cipher.getInstance(cipherTransformation);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, aesEncryptionAlgorithm);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        plainText = cipher.doFinal(plainText);
        return plainText;
    }
 
    private static byte[] getKeyBytes(String key) throws UnsupportedEncodingException{
        byte[] keyBytes= new byte[16];
        byte[] parameterKeyBytes= key.getBytes(characterEncoding);
        System.arraycopy(parameterKeyBytes, 0, keyBytes, 0, Math.min(parameterKeyBytes.length, keyBytes.length));
        return keyBytes;
    }
 
    /// <summary>
    /// Encrypts plaintext using AES 128bit key and a Chain Block Cipher and returns a base64 encoded string
    /// </summary>
    /// <param name="plainText">Plain text to encrypt</param>
    /// <param name="key">Secret key</param>
    /// <returns>Base64 encoded string</returns>
    public static String encrypt(String plainText, String key) {
    	String sEncrypted=null;
       try {
    	   byte[] plainTextbytes = plainText.getBytes(characterEncoding);
           byte[] keyBytes  = getKeyBytes(key);
           byte[] iniVector = keyBytes;
           sEncrypted= Base64.encodeToString(encrypt(plainTextbytes, keyBytes, iniVector), Base64.DEFAULT);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return sEncrypted;
    }
    
    public static String encryptURL(String plainText, String key) {
    	String sEncrypted=null;
       try {
    	   byte[] plainTextbytes = plainText.getBytes(characterEncoding);
           byte[] keyBytes  = getKeyBytes(key);
           byte[] iniVector = keyBytes;
           sEncrypted= Base64.encodeToString(encrypt(plainTextbytes, keyBytes, iniVector), Base64.DEFAULT);
           sEncrypted = URLEncoder.encode(sEncrypted, "utf-8");           
       } catch (Exception e) {
			// TODO: handle exception
		}
    	return sEncrypted;
    }
 
    /// <summary>
    /// Decrypts a base64 encoded string using the given key (AES 128bit key and a Chain Block Cipher)
    /// </summary>
    /// <param name="encryptedText">Base64 Encoded String</param>
    /// <param name="key">Secret Key</param>
    /// <returns>Decrypted String</returns>
    public static String decrypt(String encryptedText, String key){
    	String sDecrypted=null;
    	 try {
	        byte[] cipheredBytes = Base64.decode(encryptedText, Base64.DEFAULT);
	        byte[] keyBytes = getKeyBytes(key);
	        byte[] iniVector = keyBytes;
	        sDecrypted= new String(decrypt(cipheredBytes, keyBytes, iniVector), characterEncoding);
    	 } catch (Exception e) {
 			// TODO: handle exception    		 
 		}
    	 return sDecrypted;
    }
    
    public static void main(String args[]) {
    	try {
    		//KEY must be either 16, 24, or 32 bytes in length for 128, 192, and 256 bit encryption respectively
    		//String key="57444ITQJK4Q5PVV";
    		
    		//String s = AESEncryption.encrypt("http://inet.edu.vn", AESEncryption.KEY_AES);
    		
    		//System.out.println(s);
//    		System.out.println(AESEncryption.encryptURL("1", InetDMSUtil.KEY_AES));
//    		System.out.println(AESEncryption.encryptURL("docanh.name.vn", InetDMSUtil.KEY_AES));
    		
    		//String s2 = AESEncryption.decrypt("+gtI8Re7Z2VkRuzB27CBEGQhr2y+C9faY1s+fU3ATRxI/qH5/G8urjvtRWY1LCF19pLqLFXo10mT ANjsIXNQDQ==",AESEncryption.KEY_AES);
    		//System.out.println("pass encrypt:"+s2);
//    		System.out.println(AESEncryption.decrypt("qSTA+0eFTk3TkV0CzsmVvslWc++mL1zfTv4kGYC4WcBPYCEiLx+pqgyzSG5XgBRsq8lsQN5l/7PC qDE/Yct/ToqJRLAvtfX3HPv0D61/JxJTS95BjCFXcdcJyO1gQ+rNN48ROPO9P1dxy6uaNwb8d+Js jWvP+w0fD94ks5mhVw1/uJMp3Q5t6mAhWVbc/2YXCL55OTHEwZtF4s+8cZ/IOA==", InetDMSUtil.KEY_AES));
    		String token = AESEncryption.encryptURL("http://diendanseo.vn", "LLI8SA33ENIPFU79");
    		System.out.println(token);
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    }
}
