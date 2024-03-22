package practice;

import static org.testng.Assert.assertNotEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {

	@Test
	public void assertionHard() {
		String s = "hello";
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		//Assert.assertTrue(s.contains("hi"));
		//Assert.assertEquals("a", "A");
		Assert.assertNotEquals("a", "A");
		System.out.println("step4");
		System.out.println("step5");
		System.out.println("step5");
	}

	@Test
	public void assertionSoft() {
		SoftAssert sa =  new SoftAssert();
	
		String s = "hello";
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		
		//sa.assertEquals("a", "A");
		sa.assertEquals("hi", "hello");
		System.out.println("step4");
		System.out.println("step5");
		
		sa.assertAll();
		
	}
}