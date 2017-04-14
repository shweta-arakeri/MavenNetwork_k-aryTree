import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Node
{
	public String value;
	public List<Node> children;
	
	public Node()
	{
		children=new ArrayList<Node>();
	}
}

public class SDET {
	
	static private Scanner s;
	public static void populateTree(Node currentNode)
	{
		s = new Scanner(System.in);
		System.out.println("Enter the number of children for " + currentNode.value);
		int n = s.nextInt();
		if ( n == 0)
			currentNode.children = null;
		s.nextLine();
		String data="";
		for (int i = 1; i <= n ; i++)
		{
			Node newChild = new Node();
			System.out.println("Enter the value for " + i + " child of " + currentNode.value);
			data = s.nextLine();
			newChild.value = data;
			currentNode.children.add(newChild);
			populateTree(newChild);
		}
			
		
	}
	
	public static void printTree(Node root)
	{	
		if (root.children == null)
			return;
		for (int i=0; i < root.children.size();i++)
		{
			System.out.println(root.children.get(i).value);
			printTree(root.children.get(i));
		}
	}
	public static boolean isValidPath(Node root, String str)
	{
		if(str == null || root == null || str == "" || str == " ")
				return false;
			String cityList[] = str.split("\\|");
			
			return findPath(root, cityList, 0);
	}
		
		// Recursive DFS on all nodes.
	public static boolean findPath(Node currentNode, String[] cityList , int cityIndex)
	{
			if(cityList.length == cityIndex && currentNode.children == null)
				return true; 
			
			if (currentNode.children == null)
				return false;
			
			for(int i=0;i < currentNode.children.size(); i++)
			{
				// Optimized to trivially reject subtrees
				if(currentNode.children.get(i) != null  && cityIndex < cityList.length && (currentNode.children.get(i).value).equalsIgnoreCase(cityList[cityIndex]))
				{
					return findPath(currentNode.children.get(i), cityList, cityIndex+1);
				}
			}
			
			// You reach this point only if none of the children match the city.
			return false;
	}
	
	
}	







