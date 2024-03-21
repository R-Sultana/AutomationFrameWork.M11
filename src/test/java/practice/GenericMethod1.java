package practice;

public class GenericMethod1 {

	public static int mul(int a,int b) {
		return a*b;
	}
	
	public static void main(String[] args) {
		
		int product=mul(10,20);
		System.out.println(product);
		mul(30,5);
		mul(40,20);
	}

}
