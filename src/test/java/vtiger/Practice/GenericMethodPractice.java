package vtiger.Practice;

public class GenericMethodPractice {

	public static void main(String[] args) {
		
		int c = add(1000,20);
		System.out.println(c);

	}
	
	public static int add(int a, int b)		//generic
	{
		int sum = a+b;						//action
		return sum;
	}

}
