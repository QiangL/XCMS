package com.didicms.entry;

import java.util.HashMap;
import java.util.Map;


public class Msg {
	//1==ok -1=error
	public int code;
	public String msg;
	public Map<String,String> date;
	public Msg(){
		date=new HashMap<>();
	}
}
