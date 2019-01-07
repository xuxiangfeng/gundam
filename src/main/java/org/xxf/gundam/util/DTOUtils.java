package org.xxf.gundam.util;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;


public class DTOUtils {
	
	@SuppressWarnings("unchecked")
	public static int getInt(Object[] item,int index,int defaultValue){
		if(item == null || index >= item.length ){
			return defaultValue;
		}
		if(item[index] == null){
			return defaultValue;
		}
		if(item[index] instanceof BigInteger){
			return ((BigInteger)item[index]).intValue();
		}
		if(item[index] instanceof BigDecimal){
			return ((BigDecimal)item[index]).intValue();
		}
		try{
			return (int)item[index];
		}catch(ClassCastException e){
			return defaultValue;
		}
	}

	public static int getInt(Object data,int defaultValue){
		if(data == null){
			return defaultValue;
		}
		if(data instanceof BigInteger){
			return ((BigInteger)data).intValue();
		}
		if(data instanceof BigDecimal){
			return ((BigDecimal)data).intValue();
		}
		try{
			return (int)data;
		}catch(ClassCastException e){
			return defaultValue;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static long getLong(Object[] item,int index,long defaultValue){
		if(item == null || index >= item.length ){
			return defaultValue;
		}
		if(item[index] == null){
			return defaultValue;
		}
		if(item[index] instanceof BigInteger){
			return ((BigInteger)item[index]).longValue();
		}
		if(item[index] instanceof BigDecimal){
			return ((BigDecimal)item[index]).intValue();
		}
		try{
			return (long)item[index];
		}catch(ClassCastException e){
			return defaultValue;
		}
	}

	public static long getLong(Object data,long defaultValue){
		if(data == null){
			return defaultValue;
		}
		if(data instanceof BigInteger){
			return ((BigInteger)data).longValue();
		}
		if(data instanceof BigDecimal){
			return ((BigDecimal)data).intValue();
		}
		try{
			return (long)data;
		}catch(ClassCastException e){
			return defaultValue;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static String getString(Object[] item,int index,String defaultValue){
		if(item == null || index >= item.length ){
			return defaultValue;
		}
		if(item[index] == null){
			return defaultValue;
		}
		if(item[index] instanceof String){
			return (String)item[index];
		}
		
		return defaultValue;
	}

	public static String getString(Object data,String defaultValue){
		if(data == null){
			return defaultValue;
		}
		if(data instanceof String){
			return (String)data;
		}

		return defaultValue;
	}
	
	@SuppressWarnings("unchecked")
	public static float getFloat(Object[] item,int index,float defaultValue){
		if(item == null || index >= item.length ){
			return defaultValue;
		}
		if(item[index] == null){
			return defaultValue;
		}
		if(item[index] instanceof BigDecimal){
			return ((BigDecimal)item[index]).floatValue();
		}
		try{
			return (float)item[index];
		}catch(ClassCastException e){
			return defaultValue;
		}
	}

	public static float getFloat(Object data,float defaultValue){
		if(data == null){
			return defaultValue;
		}
		if(data instanceof BigDecimal){
			return ((BigDecimal)data).floatValue();
		}
		try{
			return (float)data;
		}catch(ClassCastException e){
			return defaultValue;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static double getDouble(Object[] item,int index,double defaultValue){
		if(item == null || index >= item.length ){
			return defaultValue;
		}
		if(item[index] == null){
			return defaultValue;
		}
		if(item[index] instanceof BigDecimal){
			return ((BigDecimal)item[index]).doubleValue();
		}
		try{
			return (double)item[index];
		}catch(ClassCastException e){
			return defaultValue;
		}
	}

	public static double getDouble(Object data,double defaultValue){
		if(data == null){
			return defaultValue;
		}
		if(data instanceof BigDecimal){
			return ((BigDecimal)data).doubleValue();
		}
		try{
			return (double)data;
		}catch(ClassCastException e){
			return defaultValue;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static Date getDate(Object[] item,int index,Date defaultDate){
		if(item == null || index >= item.length ){
			return defaultDate;
		}
		if(item[index] == null){
			return defaultDate;
		}
		if(item[index] instanceof Timestamp){
			return new Date(((Timestamp)item[index]).getTime());
		}
		if(item[index] instanceof java.sql.Date){
			return (Date)item[index];
		}
		try{
			return ((Date)item[index]);
		}catch(ClassCastException e){
			return defaultDate;
		}
	}

	public static Date getDate(Object data,Date defaultDate){
		if(data == null){
			return defaultDate;
		}
		if(data instanceof Timestamp){
			return new Date(((Timestamp)data).getTime());
		}
		if(data instanceof java.sql.Date){
			return (Date)data;
		}
		try{
			return ((Date)data);
		}catch(ClassCastException e){
			return defaultDate;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static long getTimestamp(Object[] item,int index,long defaultTime){
		if(item != null & item[index] != null && item[index] instanceof Timestamp){
			return ((Timestamp)item[index]).getTime();
		}
		Date date = getDate(item, index, null);
		if(date != null){
			return date.getTime();
		}
		return defaultTime;
	}

	public static boolean isStringEmpty(String value){
		return StringUtils.isEmpty(value) || "null".equals(value);
	}

}
