public class Node {  
	Pokemon object;
	String name;
	int data;  
	Node left;  
	Node right;
	/**
	 *@Node(int data)- Overloaded node constructor
	 * @param data
	 */
	public Node(int data){   
		this.data = data;   
		left = null;   
		right = null;     
	}
	/**
	 * @getData - returns data
	 * @return
	 */
	public int getData(){
		return data;
		
	}
	/**
	 *@Node(Pokemon Object)- Overloaded node contructor accepts pokemon objects and sets object attributes
	 * @param object
	 */
	public Node(Pokemon object){
		this.object = object;
		name = object.getName();
		data = object.getNumber();
		left = null;
		right = null;
	}
	/**
	 * @getName - will return pokemon's name
	 * @return
	 */
	public String getName(){
		return name;
	}
 }