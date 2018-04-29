package test;

import java.util.HashMap;
import java.util.Map;

public class testB01 {
	
	public static void main(String[] args) {
		Long input = 5000000000L;
		
		// 轉成文字陣列
		String inputStr = String.valueOf(input);
		
		if (inputStr.length()<13) {

			
			String prefix = "";
			
			for (int i = 0; i< 13- inputStr.length() ; i++) {prefix = prefix + "*";}
			
			inputStr = prefix + inputStr;
			
			
			String[] fullStr = inputStr.split("");
			
			for (int i=0 ; i<13 ; i++) {
				if (!fullStr[i].equals("*"))
					System.out.print(transToZhNum(fullStr[i])+getDigit(i));
			}
	

		}
			

	}

	private static String transToZhNum(String key) 
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
	
	private static String getDigit(Integer key) 
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
