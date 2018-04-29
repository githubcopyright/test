package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class test {

	public static void main(String[] args) {
//		
//		for (int i=0;i<13;i++)
//			System.out.print(i + "|" );
//			
//		System.out.println();
//		
//		Long input = 5702040L;
////		Long base  = 100000000000L;
//		
////		System.out.println("[/]" + input/base );
////		System.out.println("[%]" + input%base );
//
//		String inputStr = String.valueOf(input);
//		
//		if (inputStr.length()<13) {
//
//			String prefix = "";
//			
//			for (int i = 0; i< 13- inputStr.length() ; i++) {
//
//				prefix = prefix + "0";
//			}
//			
//			inputStr = prefix + inputStr;
//		}
//		
//
//		
//		
//		
//		String[] str = String.valueOf(inputStr).split("");
////		System.out.println("str.len=" + str.length);
////		
//		System.out.print( "str[]=");
//		for (String a : str)
//			System.out.print( a+"|");
//		
//		System.out.println();
//		
//		Map<String, String> numberMap = new HashMap<>();
//		numberMap.put("0","零");
//		numberMap.put("1","壹");
//		numberMap.put("2","貳");
//		numberMap.put("3","參");
//		numberMap.put("4","肆");
//		numberMap.put("5","伍");
//		numberMap.put("6","陸");
//		numberMap.put("7","柒");
//		numberMap.put("8","捌");
//		numberMap.put("9","玖");
//		
//		Map<Integer, String> baseDigitMap = new HashMap<>();
//		baseDigitMap.put(1, "仟");
//		baseDigitMap.put(2, "佰");
//		baseDigitMap.put(3, "拾");
//		
//		
//		Map<Integer, String> digitMap = new HashMap<>();
//		digitMap.put(0, "兆");
//		digitMap.put(1, "億");
//		digitMap.put(2, "萬");
//		
//		
//		for (String print : str) {
//			System.out.print(numberMap.get(print)+"|");
//		}
//		
//		
//		ArrayList<String> tmp = new ArrayList<String>();		
//		
//		
//		tmp.add(numberMap.get(str[0])); // 0
//		tmp.add(digitMap.get(0));
//		
//		tmp.add(numberMap.get(str[1])); // 0
//		tmp.add(baseDigitMap.get(1));
//		tmp.add(numberMap.get(str[2])); // 1
//		tmp.add(baseDigitMap.get(2));
//		tmp.add(numberMap.get(str[3])); // 2
//		tmp.add(baseDigitMap.get(3));
//		
//		tmp.add(numberMap.get(str[4])); // 0
//		tmp.add(digitMap.get(1));
//		tmp.add(numberMap.get(str[5])); //1
//		tmp.add(baseDigitMap.get(1));
//		tmp.add(numberMap.get(str[6])); //2
//		tmp.add(baseDigitMap.get(2));
//		tmp.add(numberMap.get(str[7])); //3
//		tmp.add(baseDigitMap.get(3));
//		
//		tmp.add(numberMap.get(str[8])); //0
//		tmp.add(digitMap.get(2));
//		tmp.add(numberMap.get(str[9])); //1
//		tmp.add(baseDigitMap.get(1));
//		tmp.add(numberMap.get(str[10])); //2
//		tmp.add(baseDigitMap.get(2));
//		tmp.add(numberMap.get(str[11])); //3
//		tmp.add(baseDigitMap.get(3));
//		
//		tmp.add(numberMap.get(str[12])); //0
//		
//		System.out.println();
//		for (String print :tmp)
//			System.out.print(print);
//		System.out.print("元");
//		
//		
//		System.out.println();
//		ArrayList<String> result = new ArrayList<String>();
//		
//		for (int i = 0 ; i<13 ; i++) {
//			System.out.println("i=" + i +" [%4]=" + i%4 + "   [/4]=" + i/4 );
//	
//			if (i%4 == 0 && !str[i].equals("0") ) {
//				result.add(numberMap.get(str[i]));
//				
//				if (i != 12)
//					result.add(digitMap.get((i%4) + (i/4)));
//			}
//			else if ((i%4 == 1 || i%4 == 2 || i%4 == 3) && !str[i].equals("0") ) {
//				result.add(numberMap.get(str[i]));
//				result.add(baseDigitMap.get(i%4));
//			}
//
//				
//			
//		}
//		
//		System.out.println();
//		for (String print :result)
//			System.out.print(print);
//			
//		System.out.print("元");	
//		
		testB02 t = new testB02();
		
		Long[] arr = {1000350004101L,700350004101L,5702040L,50280L,50020L,50000L,0L,1L,9000000000000L,9000000000001L};
		
		for (Long input : arr)
			t.show(input);		
		
	}
	
	
	

}
