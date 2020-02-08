package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class testB02 {
	
	public String show(Long input) {
		

		String output = "SCR-2";

		
		if (input == 0) 
			output = numberMap.get("0") ;		
		else {

			String inputStr = String.valueOf(input);
			
			if (inputStr.length() <= 13 && input > 0) {
				ArrayList<String[]> groups = makeGroup(StringUtils.leftPad(inputStr, 13, "*").split(""));	        // 轉換只到兆,補滿13位	                                    // 分組:{[0,兆],[1,億],[2,萬],[3,(元)]}	
				
				for (int i = 0; i < 4; i++ ) {
					
					String chkZero = "";
					
					for (String t : groups.get(i)) 
						if (!"*".equals(t))
							chkZero = chkZero + t;
					
					if ( chkZero.length() > 0 && Integer.parseInt(chkZero) > 0 )                                    // 規則:整組都是補位或是0,就不顯示
						output = output + transToZh(i, groups.get(i));					
				}
			}
			else
				return "輸入金額有誤,只計算正數到兆元";
		}
		if (output.length() > 0)	output = output + "元";
	
		return output;
	}

	private  String transToZh(int groupIndex,String[] group) {
		
		String result ="";
		
		for (int i=0; i < group.length; i++) {                                                                     // {[0,仟],[1,佰],[2,拾],[3,(群組單位)]}
			
			if ("*".equals(group[i]))                                                                             // *是補位不是數字不處理
				continue;			
			
			if (!"0".equals(group[i]))					
				if (groupIndex == 0)                                                                                  // 兆群組沒有仟佰拾						
					result = result + numberMap.get(group[i]);
				else						
					result = result + numberMap.get(group[i]) + digitMap.get(i);	
			else
				if ( i < group.length-1 && !"0".equals(group[i+1]))                                                 // 下一位不是0才要顯示零 (避免連續零零的情況)
					result = result + numberMap.get(group[i]);
		}	
		
		if (result.length() > 0)                                                                                      // 加上群組單位
			result = result + groupDigitMap.get(groupIndex);
		
		return result;
	}
	
	Map<String, String> numberMap = new HashMap<String, String>() {
		{
			put("0","零");
			put("1","壹");
			put("2","貳");
			put("3","參");
			put("4","肆");
			put("5","伍");
			put("6","陸");
			put("7","柒");
			put("8","捌");
			put("9","玖");
		}
	};
	
	Map<Integer, String> groupDigitMap = new HashMap<Integer, String>()	{
		{
			put(0, "兆");
			put(1, "億");
			put(2, "萬");
			put(3, "");
		}
	};
	
	Map<Integer, String> digitMap = new HashMap<Integer, String>(){
		{
			put(0, "仟");
			put(1, "佰");
			put(2, "拾");
			put(3, "");
		}
	};	
	
	private ArrayList<String[]> makeGroup(String[] fullStr) {
		ArrayList<String[]> groups = new ArrayList<String[]>();	
		groups.add(Arrays.copyOfRange(fullStr, 0, 1));
		groups.add(Arrays.copyOfRange(fullStr, 1, 5));
		groups.add(Arrays.copyOfRange(fullStr, 5, 9));
		groups.add(Arrays.copyOfRange(fullStr, 9, 13));
		return groups;
	}
}
