package com.bigfatinvitations.utils;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//import net.tanesha.recaptcha.ReCaptchaImpl;
//import net.tanesha.recaptcha.ReCaptchaResponse;

import org.apache.struts2.ServletActionContext;
//Utility Class
public class Utilities {

	
	public static Map<String,String> regions =new HashMap<String,String>();
	public static Map<String,String> communes =new HashMap<String,String>();
	public static Map<String,String>  estates=new HashMap<String,String>();
	public static Map<String,String> regionsR =new HashMap<String,String>();
	public static Map<String,String> communesR =new HashMap<String,String>();
	public static Map<String,String>  estatesR=new HashMap<String,String>();
	
	
	static{
		regions.put("K","Karaikal" );
		regions.put("P","Pondicherry");
		regions.put("M","Mahe");			
		regions.put("Y","Yanam" );
		regions.put("N","-select-");
		communes.put( "PAC","Ariyankuppam Commune");
		communes.put( "PBC","Bahour Commune");
		communes.put("PMC","Mannadipet Commune" );
		communes.put("PNC","Nettapakkam Commune" );
		communes.put("POM","Oulgaret Municipality" );
		communes.put("PPM","Pondicherry Municipality" );
		communes.put("PVC","Villianur Commune" );
		communes.put("KKM","Karaikal Municipality" );
		communes.put("KKC","Kottucherry Commune" );
		communes.put("KNG","Nedungadu Commune" );
		communes.put("KNY","Neravy Commune" );
		communes.put("KPC","T.R Pattinam Commune" );
		communes.put("KTC","Tirunallar Commune" );
		communes.put("MMM","Mahe Municipality" );
		communes.put("YYM","Yanam Municipality" );
		communes.put("NA","-select-");
		estates.put("PBCKK","Kattukuppam Industrial Estate");
		estates.put("PBCKP","Kirumampakkam Industrial Estate");
		estates.put("POMMP","Mettupalayam Industrial Estate");
		estates.put("POMTC","Thattanchavady Industrial Estate");
		estates.put("PVCSP","Sedarapet Industrial Estate");	
		estates.put("NA","-select-");
		
		regionsR.put("Karaikal","K" );
		regionsR.put("Pondicherry","P");
		regionsR.put("Mahe","M");			
		regionsR.put("Yanam" ,"Y");
		regionsR.put("-select-","N");
		communesR.put("Ariyankuppam Commune","PAC");
		communesR.put("Bahour Commune","PBC");
		communesR.put("Mannadipet Commune" ,"PMC");
		communesR.put("Nettapakkam Commune" ,"PNC");
		communesR.put("Oulgaret Municipality" ,"POM");
		communesR.put("Pondicherry Municipality" ,"PPM");
		communesR.put("Villianur Commune" ,"PVC");
		communesR.put("Karaikal Municipality" ,"KKM");
		communesR.put("Kottucherry Commune" ,"KKC");
		communesR.put("Nedungadu Commune" ,"KNG");
		communesR.put("Neravy Commune" ,"KNY");
		communesR.put("T.R Pattinam Commune" ,"KPC");
		communesR.put("Tirunallar Commune" ,"KTC");
		communesR.put("Mahe Municipality" ,"MMM");
		communesR.put("Yanam Municipality" ,"YYM");
		communesR.put("-select-","NA");
		estatesR.put("Kattukuppam Industrial Estate","PBCKK");
		estatesR.put("Kirumampakkam Industrial Estate","PBCKP");
		estatesR.put("Mettupalayam Industrial Estate","POMMP");
		estatesR.put("Thattanchavady Industrial Estate","POMTC");
		estatesR.put("Sedarapet Industrial Estate","PVCSP");	
		estatesR.put("-select-","NA");
	}
	/**
	 * utility function for MD5 encryption
	 * @param data to encrypt
	 * @return encrypted value
	 * @throws NoSuchAlgorithmException
	 */
	public static String encrypt(String data) throws NoSuchAlgorithmException
	{
		String input=data;
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.update(input.getBytes(), 0, input.length());
		data=new BigInteger(1, digest.digest()).toString(16);
		return data; 
		
		
	}
	/**
	 * generates five digit random alpha numeric string
	 * @return generated string 
	 */
	public static String getCaptcha() {
	    String chars ="3E5F6G8I9T1B2445MX13N6Q7K1L8S5U7HRJV2WAZP93D4CY2";
	   int string_length = 5;
	    String captchastring = "";
	    for (int i=0; i<string_length; i++) {
	        int rnum = (int) Math.floor(Math.random() * chars.length());
	        captchastring += chars.substring(rnum,rnum+1);
	    }
	    return captchastring;
	}
	/**
	 * to retrive the reCaptcha private key from properties file
	 * @return reCaptcha Public key
	 */
	public static String getCaptchaPublicKey(){
		
		
		InputStream keyPropertiesIS = Utilities.class.getResourceAsStream("keys.properties");
		Properties keyProperties = new Properties();
		try {
			keyProperties.load(keyPropertiesIS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return keyProperties.getProperty("recaptcha.publicKey");
		
	}
	/**
	 * to retrive the reCaptcha private key from properties file
	 * @return reCaptcha private key
	 */
	public static String getCaptchaPrivateKey(){
		
		
		InputStream keyPropertiesIS = Utilities.class.getResourceAsStream("keys.properties");
		Properties keyProperties = new Properties();
		try {
			keyProperties.load(keyPropertiesIS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return keyProperties.getProperty("recaptcha.privateKey");
		
	}
	/**
	 * reCaptcha Verifier for old version 
	 * @param changeFiled 
	 * @param responseFiled
	 * @return result
	 */
	/*public static boolean verifyCaptcha(String changeFiled,String responseFiled){
		
		String remoteAddr = ServletActionContext.getRequest().getRemoteAddr();
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		InputStream keyPropertiesIS = Utilities.class.getResourceAsStream("keys.properties");
		Properties keyProperties = new Properties();
		try {
			keyProperties.load(keyPropertiesIS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		reCaptcha.setPrivateKey(keyProperties.getProperty("recaptcha.privateKey"));
		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr,
				changeFiled, responseFiled);
		return reCaptchaResponse.isValid();	
	}*/
	
	public static boolean isMatchPolicy(String s){
		//return s.matches("(.)*[0-9](.)*")&&s.matches("(.)*[a-z](.)*")&&s.matches("(.)*[A-Z](.)*")&&s.matches("(.)*[^0-9 ^a-z ^A-Z](.)*");
		return true;
	}
	/**
	 * Coverts java Date to dd-mm-yyyy String
	 * @param date to convert
	 * @return coverted String
	 */
	public static String dateToString(Date date){
		if(date == null)
			return "";
		String st="";
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			int day = c.get(Calendar.DAY_OF_MONTH);
			int month = c.get(Calendar.MONTH)+1;
			int year = c.get(Calendar.YEAR);
			return day+"-"+month+"-"+year;
		} catch (Exception e) {
			st = "";
			e.printStackTrace();
		}
		return st;
	}
	
	/**
	 * Converts dd-mm-yyyy String to java Date
	 * @param date as String
	 * @return java Date object
	 */
	public static Date stringToDate(String date){
		Date dt;
		SimpleDateFormat textFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			dt = textFormat.parse(date);
		} catch (ParseException e) {
			dt = null;
			//e.printStackTrace();
		} catch (Exception e) {
			dt = null;
			//e.printStackTrace();
		}
		return dt;
	}
	/**
	 * Retrives the location for temp directory from properties file 
	 * @return temp diresctory location as String
	 */
	public static String getTempDirectoryLocation(){
		InputStream keyPropertiesIS = Utilities.class.getResourceAsStream("keys.properties");
		Properties keyProperties = new Properties();
		try {
			keyProperties.load(keyPropertiesIS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return keyProperties.getProperty("tempFileLocation");
	}
	/**
	 * Retrives SMS gateway User Id directory from properties file 
	 * @return SMS gateway User Id as String
	 */
	public static String getSmsUserId(){
		InputStream keyPropertiesIS = Utilities.class.getResourceAsStream("sms.properties");
		Properties keyProperties = new Properties();
		try {
			keyProperties.load(keyPropertiesIS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return keyProperties.getProperty("userName");
	}
	/**
	 * Retrives SMS gateway Pin directory from properties file 
	 * @return SMS gateway Pin as String
	 */
	public static String getSmsPin(){
		InputStream keyPropertiesIS = Utilities.class.getResourceAsStream("sms.properties");
		Properties keyProperties = new Properties();
		try {
			keyProperties.load(keyPropertiesIS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return keyProperties.getProperty("pin");
	}
	/**
	 * Retrives SMS gateway Sigrature directory from properties file 
	 * @return SMS gateway Sigrature as String
	 */
	public static String getSmsSignature(){
		InputStream keyPropertiesIS = Utilities.class.getResourceAsStream("sms.properties");
		Properties keyProperties = new Properties();
		try {
			keyProperties.load(keyPropertiesIS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return keyProperties.getProperty("signature");
	}
	public static String getAddress(String a1,String a2,String a3,String pin){
		String result = "";
		if(a1!=null&&!a1.equals("")){
			result+=a1;
		}
		if(a2!=null&&!a2.equals("")){
			if(!result.equals("")){
				result+=(",");
			}
			result+=(a2);
		}
		if(a3!=null&&!a3.equals("")){
			if(!result.equals("")){
				result+=(",");
			}
			result+=(a3);
		}
		if(pin!=null&&!pin.equals("")){
			if(!result.equals("")){
				result+=("-");
			}
			result+=(pin);
		}
		return result;
	}

}
