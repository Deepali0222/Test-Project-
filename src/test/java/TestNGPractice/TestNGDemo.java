package TestNGPractice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGDemo {

	/*
	 * @Test public void a_test1() { System.out.println("welcome-test1"); }
	 * 
	 * @Test public void b_test2() { System.out.println("welcome-test2"); }
	 */
	
	/*
	 * @Test public void c_test3() { System.out.println("welcome-test2"); //add(); }
	 */
	@Test
	@Parameters({"val1","val2"})
	public static void add(int v1,int v2)
	{
		int sum=v1+v2;
		System.out.println("Addition of these 2 Numbers are : "+sum);
	}

}
