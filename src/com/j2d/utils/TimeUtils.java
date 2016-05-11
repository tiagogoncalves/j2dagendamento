package com.j2d.utils;

public class TimeUtils {

	public static boolean validaHora(Integer hora){
		if(hora<0||hora>23)
			return false;
		
		return true;
	}
	
	public static boolean validaMinuto(Integer minuto){
		if(minuto<0||minuto>59)
			return false;
		
		
		return true;
	}
	
}
