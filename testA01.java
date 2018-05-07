package test;

import org.apache.commons.lang3.StringUtils;

public class testA01 {

	public String getSeq() {
		Long maxSeqInDB   = 5L;                                                                                     // TODO 來源要改從DB取得目前最大編號		
		String[] seqArr   =  String.valueOf(maxSeqInDB + 1L).split("");
		boolean isSetZero = false;                                                                                       
		
		for (int i = 0; i < seqArr.length; i++) {

			if (!isSetZero && "4".equals(seqArr[i])) {
				seqArr[i] = "5" ;
				isSetZero = true;
				continue;				
			}
		
			if (isSetZero)
				seqArr[i] = "0" ;
		}
		
		return 	StringUtils.leftPad(StringUtils.join(seqArr,""), 10 , "0");		
	}	
}
