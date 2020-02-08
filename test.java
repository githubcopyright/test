package test;;

public class test {

	public static void main(String[] args) {
		
		testB01 t1 = new testB01();
		testB02 t2 = new testB02();
		
		Long[] arr = {1000350004101L,700350004101L,5702040L,50280L,50020L,50000L,0L,1L,9000000000000L,9000000000001L,105000000L,101010101L,1005L,-1222L};
		
		for (Long input : arr)
			System.out.println("[testB01]" + input + "=" + t1.show(input));
		
		for (Long input : arr)
			System.out.println("[testB02]" + input + "=" + t2.show(input));
	}
}
