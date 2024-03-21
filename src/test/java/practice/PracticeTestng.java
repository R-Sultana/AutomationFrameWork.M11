package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeTestng {

	@Test
	public void create() {
		Assert.fail();
		System.out.println("create");
	}
	
	@Test(dependsOnMethods = "create")
	public void modify() {
		System.out.println("modify");
	}
	
	@Test
	public void Delete() {
		System.out.println("delete");
	}
	//default order of execution is ASCII values
}
