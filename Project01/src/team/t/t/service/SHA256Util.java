package team.t.t.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SHA256Util {

	public static String getEncrypt(String str) {
		String hax = "";

		try {

			MessageDigest md = MessageDigest.getInstance("SHA-256");

			md.update(str.getBytes());
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			hax = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			hax = null;
		}
		return hax;
	}
}

//
//StringBuffer hexString = new StringBuffer();
//for (int i = 0; i < byteData.length; i++) {
//	String hex = Integer.toHexString(0xff & byteData[i]);			
//	if (hex.length() == 1) {
//		hexString.append('0');				
//	}
//	hexString.append(hex);
//	System.out.println(hexString.toString());				
//}
//return hexString.toString();
