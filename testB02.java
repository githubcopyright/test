package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class testB02 {
	
	public void show(Long input) {
		
		// 轉成文字陣列
		String inputStr = String.valueOf(input);
		
		if (inputStr.length()<=13) {
			
			String prefix = "";
			
			for (int i = 0; i< 13- inputStr.length() ; i++) {prefix = prefix + "*";}
			
			inputStr = prefix + inputStr;
			
			
			String[] fullStr = inputStr.split("");
			
			String result = "";
			
			for (int i=0 ; i<13 ; i++) {
				if (!fullStr[i].equals("*")) {					
					if (i%4==0) {
						if (fullStr[i].equals("0"))
							result = result + getDigit(i);
						else {

								result = result + transToZhNum(fullStr[i]) + getDigit(i);
						}
					}
					else {
						if (!fullStr[i].equals("0"))
							result = result + transToZhNum(fullStr[i]) + getDigit(i);
						else if (isBetweenNum(i,fullStr))
							result = result + transToZhNum(fullStr[i]);
						else if (i%4==2 && fullStr[i].equals("0") 
								        && (fullStr[i+1].equals("0") || fullStr[i-1].equals("0") )
								        && (i+2<13 && !fullStr[i+2].equals("0")))
								result = result + transToZhNum(fullStr[i]);
						else if (i%4==2 && (i+2<13 && fullStr[i+2].equals("0") 
										&& (i+1<13 && !fullStr[i+1].equals("0"))))
								result = result + transToZhNum(fullStr[i]);
			
					}
				}
			}
			
			if(chechResult(result))
				System.out.println("true");
			else
				System.out.println(input + " != " + result);
			
		}

	}
	
//	public static void main(String[] args) {
//		Long input = 1000350004101L;
////		Long input = 700350004101L;
////		Long input = 5702040L;
//		
//		// 轉成文字陣列
//		String inputStr = String.valueOf(input);
//		
//		
//		
//		if (inputStr.length()<=13) {
//
//			
//			String prefix = "";
//			
//			for (int i = 0; i< 13- inputStr.length() ; i++) {prefix = prefix + "*";}
//			
//			inputStr = prefix + inputStr;
//			
//			
//			String[] fullStr = inputStr.split("");
//			
//			for (int i=0 ; i<13 ; i++) {
//				if (!fullStr[i].equals("*")) {
//					
//					if (i%4==0) {
//						if (fullStr[i].equals("0"))
//							System.out.print(getDigit(i));
//						else {
////							if (isTripleZeroLeft(i,fullStr))
//							if (i>1 && fullStr[i-1].equals("0"))
//								System.out.print(transToZhNum("0")+transToZhNum(fullStr[i])+getDigit(i));							
//							else
//								System.out.print(transToZhNum(fullStr[i])+getDigit(i));
//						}
//					}
//					else {
//						if (!fullStr[i].equals("0"))
//							System.out.print(transToZhNum(fullStr[i])+getDigit(i));						
////						else if (fullStr[i].equals("0") && (isBetweenNum(i,fullStr) ))
////							System.out.print(transToZhNum(fullStr[i]));						
//					}
//					
//					
//					
//					
//					
////					if (fullStr[i].equals("0")) {
////						
////						if (i%4==0 && !isTripleZeroLeft(i,fullStr))
////							System.out.print(getDigit(i));
////						else if (!isBetweenZero(i,fullStr))
////							System.out.print(transToZhNum(fullStr[i]));
////
////					}
////					else {
////
////							System.out.print(transToZhNum(fullStr[i])+getDigit(i));
////					}
//				}
//					
//			}
//	
//
//		}
//			
//
//	}

	private static boolean isBetweenNum(int i, String[] fullStr) {
		if ((i+1<13 && i-1>0) && (!fullStr[i-1].equals("0") && !fullStr[i+1].equals("0") ))
			return true;
		return false;
	}

//	private static boolean isBetweenZero(int i, String[] fullStr) {
//		if ((i+1<13 && i-1>0) && (fullStr[i-1].equals("0") && fullStr[i+1].equals("0") ))
//			return true;
//		return false;
//	}

//	private static boolean isTripleZeroLeft(int i, String[] fullStr) {
//		
//		if (i==0 || (i>3 &&
//				(  !fullStr[i-1].equals("0") 
//				|| !fullStr[i-2].equals("0")
//				|| !fullStr[i-3].equals("0"))))
//			return false;
//		
//		return true;
//	}

//	private static boolean isNextZero(int i, String[] fullStr) {
//		
//		if (i+1<13 && fullStr[i+1].equals("0"))
//			return true;
//		
//		return false;
//	}

	private boolean chechResult(String result) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("伍萬零貳佰捌拾元");
		arr.add("伍佰柒拾萬貳仟零肆拾元");
		arr.add("柒仟零參億伍仟萬肆仟壹佰零壹元");
		arr.add("壹兆零參億伍仟萬肆仟壹佰零壹元");
		arr.add("伍萬零貳拾元");
		arr.add("伍萬元");
		arr.add("零元");
		arr.add("壹元");
		arr.add("玖兆元");
		arr.add("玖兆零壹元");
		
		
		if (arr.contains(result))
			return true;
		
		
		return false;
	}

	private String transToZhNum(String key) 
	{
		Map<String, String> numberMap = new HashMap<>();
		numberMap.put("0","零");
		numberMap.put("1","壹");
		numberMap.put("2","貳");
		numberMap.put("3","參");
		numberMap.put("4","肆");
		numberMap.put("5","伍");
		numberMap.put("6","陸");
		numberMap.put("7","柒");
		numberMap.put("8","捌");
		numberMap.put("9","玖");	
		
		return numberMap.get(key);
	}
	
	private String getDigit(Integer key) 
	{
		Map<Integer, String> digitMap = new HashMap<>();
		digitMap.put(0, "兆");
		digitMap.put(1, "仟");
		digitMap.put(2, "佰");
		digitMap.put(3, "拾");
		digitMap.put(4, "億");
		digitMap.put(5, "仟");
		digitMap.put(6, "佰");
		digitMap.put(7, "拾");
		digitMap.put(8, "萬");
		digitMap.put(9, "仟");
		digitMap.put(10, "佰");
		digitMap.put(11, "拾");
		digitMap.put(12, "元");
		
		return digitMap.get(key);
	}	
	
	
}
