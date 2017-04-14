import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SDETTest {

	private Node root;
	@BeforeTest
	public void populateTreeTest()
	{
		System.out.println("Testing Begin..!");
		root = new Node();
		root.value = "root";
		SDET.populateTree(root);
	  //SDET.printTree(root);
	}

	@Test
	public void isValidPathTrueCases() 
	{
		//These test cases are for the example shared in the mail by Aarti
		Assert.assertTrue(SDET.isValidPath(root,"bc|er"));
		Assert.assertTrue(SDET.isValidPath(root,"a"));
		Assert.assertTrue(SDET.isValidPath(root,"e|f"));
		Assert.assertTrue(SDET.isValidPath(root,"bc|r"));
		
	}
	
	@Test
	public void isValidPathFalseCases()
	{
		//These test cases are for the example shared in the mail by Aarti
		Assert.assertFalse(SDET.isValidPath(root, "a|bc|er"));
		Assert.assertFalse(SDET.isValidPath(root, "a|bc"));
		Assert.assertFalse(SDET.isValidPath(root, "bc|f"));
		Assert.assertFalse(SDET.isValidPath(root, ""));
		Assert.assertFalse(SDET.isValidPath(root, " "));
		Assert.assertFalse(SDET.isValidPath(root, null));
		Assert.assertFalse(SDET.isValidPath(root, "a%b$cer"));
	}
	
	@AfterTest
	public void cleanup()
	{
		System.out.println("Testing is complete..!");
	}
}
