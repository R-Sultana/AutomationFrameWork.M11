package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {

	@Test(retryAnalyzer = genericUtilities.RetryAnalyzerImplementation.class)
	public void retryScript() {
		Assert.fail();
		System.out.println("Hello");
	}
	
}
