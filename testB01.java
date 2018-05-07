package test;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class testB01 {
	
	public String show(Long input) {
		
		String output   = "";
		String inputStr = String.valueOf(input);
		
		if (inputStr.length() <= 13 && input >= 0) {
			String[] fullStr = StringUtils.leftPad(inputStr, 13, "*").split("");                                    // 轉換只到兆,補滿13位
			
			for (int i = 0; i < 13; i++)
				if (!fullStr[i].equals("*"))
					output = output + numberMap.get(fullStr[i]) + digitMap.get(i);
		}
		else
			return "輸入金額有誤,只計算正數到兆元";
		return 	output;
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

	Map<Integer, String> digitMap = new HashMap<Integer, String>() {
		{
			put(0, "兆");
			put(1, "仟");
			put(2, "佰");
			put(3, "拾");
			put(4, "億");
			put(5, "仟");
			put(6, "佰");
			put(7, "拾");
			put(8, "萬");
			put(9, "仟");
			put(10, "佰");
			put(11, "拾");
			put(12, "元");
		}
	};

}
