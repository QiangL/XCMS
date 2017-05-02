package com.didicms.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PwdEncoding {
	
	public static void main(String [] args) throws NoSuchAlgorithmException{
		System.out.println(encoding("liqiang asf asd df asd,l,,;,..''\"''[p]]'/;.;.;.;./*/*/[].//. .,,fw*/-+-+34242$%^&*()(*(*%$$$%$^&&"));
	}
	public static String encoding(String pwd){
		MessageDigest msgd=null;
		try {
			msgd = MessageDigest.getInstance("MD5");
			msgd.update(pwd.getBytes());
		} catch (NoSuchAlgorithmException e) {
			// TODO log it
			System.out.println("PWDENcodig choose algorithm error");
			e.printStackTrace();
		}
		return Base64.getUrlEncoder().encodeToString(msgd.digest());
	}

}
