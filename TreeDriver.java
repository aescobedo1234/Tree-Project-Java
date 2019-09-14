/**
 * Arnold Escobedo
 * CECS 274
 * Tu/Thur 2:00pm
 * Project 8 Binary Search Trees
 */
import java.io.File;
import java.util.Scanner;
public class TreeDriver {
	private static Scanner scan;
	private static Scanner input = new Scanner(System.in);
	private static int num;
	private static int index = 0;
	private static Pokemon[]myPokemon = new Pokemon[20];
 public static void main(String[] args) {  
	 //20, 25, 15, 10, 18, 19, 16 
  /**
   * Create new tree objects
   */
  BinarySearchTree T = new BinarySearchTree();
  ObjBinarySearchTree T2 = new ObjBinarySearchTree();
  ObjBinarySearchTree T3 = new ObjBinarySearchTree();
  /**
   * inserting different integer elements in binary search tree
   */
  T.insert(20);   
  T.insert(25);   
  T.insert(15);   
  T.insert(10);   
  T.insert(18);   
  T.insert(19);   
  T.insert(16); 
  /**
   * print binary search tree orders
   */
  System.out.println("In Order:");
  T.inOrder(T.root);
  System.out.println("\npre-Order:");
  T.preOrder(T.root);
  System.out.println("\npost-Order:");
  T.postOrder(T.root);
  System.out.println("");
  System.out.println(T.getPredeccessor(T.root.getData()));
  System.out.println(T.getSuccessor(T.root).getData());
 
  /**
   * User can insert Pokemon into a binary search tree
   */
  openFile();
  System.out.println("\nhow many pokemon would you like to insert in a Binary Tree?");
  System.out.println("Please Only enter number between (1 - 20)");
  /**
	 * user input validation, will validate whether the user enters an invalid
	 * character or an invalid integer entry
	 */
	while(!input.hasNextInt())		
	{
		    System.out.println("Error! Please Enter a valid integer" );
		    input.next();
	}
		num = input.nextInt();
		while (num<=0 || num > 20){
			System.out.println("Enter a valid int");
			while(!input.hasNextInt())		
			{
				    System.out.println("Error! Please Enter a valid integer" );
				    input.next();
			}
			num = input.nextInt();
		}
  read(num);
  close();
  /**
   * insert different pokemon objects into two different binary search trees
   */
  for(int i = 0; i < num; i++){
	  T2.insertBasedName(myPokemon[i]);
	  T3.insertBasedNum(myPokemon[i]);
  }
  /**
   * print binary tree of pokemon objects based on their name attribute
   */
	  System.out.println("(Binary Tree Based On Name:)\n_________________________");
	  System.out.println("inOrder:");
	  T2.inOrder(T2.root);
	  System.out.println("\npostOrder:");
	  T2.postOrder(T2.root);
	  System.out.println("\npreOrder:");
	  T2.preOrder(T2.root);
	  System.out.println( T2.getPredeccessorBasedName(T2.root.object));
	  System.out.println(T2.getSuccessor(T2.root).getName());
	  System.out.println("\n--------------------------");
	  /**
	   * print binary tree of pokmeon objects based on their number attribute
	   */
	  System.out.println("(Based On Number:)\n__________________________");
	  System.out.println("inOrder");
	  T3.inOrder(T3.root2);
	  System.out.println("\npostOrder:");
	  T3.postOrder(T3.root2);
	  System.out.println("\npreOrder:");
	  T3.preOrder(T3.root2);
	  System.out.println(T3.getPredeccessorBasedNum(T3.root2.object));
	  System.out.println(T3.getSuccessor(T3.root2).getName());
	  System.out.println("\n--------------------------");
	  
	 /**
	  * Check whether the two binary search trees are isomorphic
	  */
	  if (T2.isomorphic(T2.root, T3.root2) == true)
          System.out.println("The two Pokemon binary trees are: isomorphic");
      else
          System.out.println("The two Pokemon binary trees are: Not isomorphic");
  }
 
 //-------------------------------Method to open file----------------------------------------------//
 /**
	 * @openFile - opens file created in a specific location
	 * returns a error message if file is not found.
	 */
	public static void openFile(){
			try {
				scan = new Scanner(new File("C:/Users/Arnold/Documents/Pokemon.txt"));
			} catch (Exception e) {
				System.out.println("no file");
			}
	}
	/**
	 * @read -instantiates and copies each pokemon in the file into an array of objects
	 */
	public static void read(int n){
		for(int i = 0 ; i < myPokemon.length; i++){
			myPokemon[i] = new Pokemon();
		}
		for(int i = 0; i < n; i++){
			String name = scan.next();
			myPokemon[index].setName(name);
			int number = scan.nextInt();
			myPokemon[index].setNumber(number);
			//System.out.printf("%s %s\n", name, number);
			index++;
		}
		System.out.println("");
	}
	/**
	 * @close - closes file
	 */
	public static void close(){
		scan.close();
	}

}