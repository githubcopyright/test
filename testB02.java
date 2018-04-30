package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class testB02 {
	
	public String show(Long input) {
		
		String output = "";
		
		if (input == 0) 
			output = getZhNum("0") ;		
		else {

			String inputStr = String.valueOf(input);
			
			if (inputStr.length() <= 13) {
				
				String prefix = "";
				
				for (int i = 0; i < 13-inputStr.length(); i++) {	prefix = prefix + "*";	}                       // 轉換只到兆,補滿13位
					
				inputStr = prefix + inputStr;				
				
				ArrayList<String[]> groups = getGroup(inputStr.split(""));		                                    // 分組:{[0,兆],[1,億],[2,萬],[3,(元)]}	
				
				for (int i = 0; i < 4; i++ ) {
					
					String chkZero = "";
					
					for (String t : groups.get(i)) 
						if (!"*".equals(t))
							chkZero = chkZero + t;
					
					if (chkZero.length()>0 && Integer.parseInt(chkZero)>0)                                          // 規則:整組都是補位或是0,就不顯示
						output = output + transToZh(i, groups.get(i));					
				}
			}
		}
		if (output.length()>0)	output = output + "元";
	
		return output;
	}

	private  String transToZh(int groupIndex,String[] group) {
		
		String result ="";
		
		for (int i=0 ; i<group.length ; i++ ) {                                                                     // {[0,仟],[1,佰],[2,拾],[3,(群組單位)]}
			
			if ( !"*".equals(group[i]) ) {
				if (!"0".equals(group[i]))					
					if (groupIndex==0)                                                                              // 兆群組沒有仟佰拾						
						result = result + getZhNum(group[i]);
					else						
						result = result + getZhNum(group[i]) + getDigit(i);	
				else
					if ( i < group.length-1 && !"0".equals(group[i+1]))                                             // 下一位不是0才要顯示零 (避免連續零零的情況)
						result = result + getZhNum(group[i]);				
			}
		}	
		
		if (result.length()>0)                                                                                      // 加上群組單位
			result = result + getGroupDigit(groupIndex);
		
		return result;
	}
	
	private ArrayList<String[]> getGroup(String[] fullStr) {		
		ArrayList<String[]> groups = new ArrayList<String[]>();	
		groups.add(Arrays.copyOfRange(fullStr, 0, 1));
		groups.add(Arrays.copyOfRange(fullStr, 1, 5));
		groups.add(Arrays.copyOfRange(fullStr, 5, 9));
		groups.add(Arrays.copyOfRange(fullStr, 9, 13));
		return groups;
	}

	private  String getZhNum(String key) {
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
	
	private  String getGroupDigit(Integer key) {
		Map<Integer, String> groupDigitMap = new HashMap<>();		
		groupDigitMap.put(0, "兆");
		groupDigitMap.put(1, "億");
		groupDigitMap.put(2, "萬");
		groupDigitMap.put(3, "");
		
		return groupDigitMap.get(key);
	}
	
	private  String getDigit(Integer key) {
		Map<Integer, String> digitMap = new HashMap<>();		
		digitMap.put(0, "仟");
		digitMap.put(1, "佰");
		digitMap.put(2, "拾");
		digitMap.put(3, "");
		
		return digitMap.get(key);
	}
}
