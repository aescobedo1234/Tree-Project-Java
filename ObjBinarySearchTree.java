public class ObjBinarySearchTree {
	public Node root, root2; 
	/**
	 * @ObjBinarySearchTree - default constructor
	 */
	public ObjBinarySearchTree(){   
		root = null;
		root2 = null;
		}
	/**
	 * @findBasedNum- searches for a pokemon object in the binary tree based on the number attribute
	 * @param n
	 * @return
	 */
 public boolean findBasedNum(Pokemon n){
	 Node current = root2;   
	 while(current!=null){    
		 if(current.data == n.getNumber()){
			 System.out.println("\n\nPokemon " + n.getName() + " found\n" );
			 return true;    
		 }
		 else if(current.data> n.getNumber()){     
			 current = current.left;    
		 }
		 else
		 {     
			 current = current.right;    
		 }   
	} 
	 System.out.println("Pokemon not found");
	 return false;  
 }  
/**
 * @findBasedName- searches for a pokemon object in the binary tree based on the name 
 * @param n
 * @return
 */
public boolean findBasedName(Pokemon n){
	 Node current = root;   
	 while(current!=null){    
		 if(current.name.equals(n.getName())){
			 System.out.println("\n\nPokemon " + n.getName() + " found" );
			 return true;    
		 }
		 else if(current.name.compareTo(n.getName())>0){     
			 current = current.left;    
		 }
		 else
		 {     
			 current = current.right;    
		 }   
	} 
	 System.out.println("Pokemon not found");
	 return false;  
 }
/**
 * @insertBasedName- inserts a pokemon object into a new binary tree based on the name
 * @param n
 */
 public void insertBasedName(Pokemon n){  
	 Node newNode = new Node(n);  
	 if(root==null)  {   //empty tree   
		 root = newNode;  
	 }  
	 else{   
		 Node current = root;   
		 Node parent = null; 
  boolean flag =true;   
  while(flag)   {    
	  parent = current;
	  int compare = n.getName().compareTo(current.name);
	  if(compare < 0)   //compare names 
	  {         
		  current = current.left;     
		  if(current==null)     
		  {      
			  parent.left = newNode;      
			  flag = false; 
		  }         
	  }//if( n < current.data)    
	  else    {     
		  current = current.right;     
		  if(current==null){      
			  parent.right = newNode;      
			  flag = false;     }//current == null    
	  		}//else   
  		}//while(flag)  
	 }//root != null } 
 }
 /**
  * @insertBasedNum- inserts a pokemon object in a new binary tree based on the number
  * @param n
  */
 public void insertBasedNum(Pokemon n){  
	 Node newNode = new Node(n);  
	 if(root2==null)  {   //empty tree   
		 root2 = newNode;  
	 }  
	 else{   
		 Node current = root2;   
		 Node parent = null; 
  boolean flag =true;   
  while(flag)   {    
	  parent = current;
	  if(n.getNumber() < current.data)   //compare names 
	  {         
		  current = current.left;     
		  if(current==null)     
		  {      
			  parent.left = newNode;      
			  flag = false; 
		  }         
	  }//if( n < current.data)    
	  else    {     
		  current = current.right;     
		  if(current==null){      
			  parent.right = newNode;      
			  flag = false;     }//current == null    
	  		}//else   
  		}//while(flag)  
	 }//root != null } 
 }
 
/**
 * @deleteBaseNum- deletes a pokemon obect in the binary tree that was based on the number attribute 
 * @param n
 * @return
 */
public boolean deleteBasedNum(Pokemon n){   
	 Node parent = root2;   
	 Node current = root2;      
	 boolean isLeftChild = false;   
	 while(current.data!=n.getNumber()){        
		 parent = current;    
		 if(current.data>n.getNumber()){     
			 isLeftChild = true;     
			 current = current.left;     
		 }    
		 else{      
			 isLeftChild = false;      
			 current = current.right;     
		 }    
		 if(current ==null){      
			 return false;     
		 }    
	}    //if i am here that means we have found the node    
	 	//Case 1: if node to be deleted has no children    
	 if(current.left==null && current.right==null){     
		 if(current==root2){      
			 root2 = null;     
		 }     
		 if(isLeftChild ==true){      
			 parent.left = null; 
		 }
		 else{      
			 parent.right = null;     
		 }    
	}    //Case 2 : if node to be deleted has only one child    
	 else if(current.right==null){     
		 if(current==root2){      
			 root2 = current.left;     
		 }
		 else if(isLeftChild){      
			 parent.left = current.left;     
		 }
		 else{      
			 parent.right = current.left;     
		 }    
	}    
	 else if(current.left==null){     
		 if(current==root2){      
			 root2 = current.right;     
		 }
		 else if(isLeftChild){      
			 parent.left = current.right;     
		 }
		 else{      
			 parent.right = current.right;     
		 }         
	}
	 else if(current.left!=null && current.right!=null){          
		 //now we have found the minimum element in the right sub tree     
		 Node successor  = getSuccessor(current);     
		 if(current==root2){      
			 root2 = successor;     
		 }
		 else if(isLeftChild){      
			 parent.left = successor;     
		 }
		 else{      
			 parent.right = successor;     
		 }        
		 successor.left = current.left;    
	}      
	 return true;     
 }      
 /**
  * @deleteBasedName- deletes a pokemon object from the binary tree that was based on the name attribute
  * @param n
  * @return
  */
public boolean deleteBasedName(Pokemon n){   
	 Node parent = root;   
	 Node current = root;      
	 boolean isLeftChild = false;   
	 while(current.name!=n.getName()){        
		 parent = current;    
		 if(current.name.compareToIgnoreCase(n.getName())>0){     
			 isLeftChild = true;     
			 current = current.left;     
		 }    
		 else{      
			 isLeftChild = false;      
			 current = current.right;     
		 }    
		 if(current ==null){      
			 return false;     
		 }    
	}    //if i am here that means we have found the node    
	 	//Case 1: if node to be deleted has no children    
	 if(current.left==null && current.right==null){     
		 if(current==root){      
			 root = null;     
		 }     
		 if(isLeftChild ==true){      
			 parent.left = null; 
		 }
		 else{      
			 parent.right = null;     
		 }    
	}    //Case 2 : if node to be deleted has only one child    
	 else if(current.right==null){     
		 if(current==root){      
			 root = current.left;     
		 }
		 else if(isLeftChild){      
			 parent.left = current.left;     
		 }
		 else{      
			 parent.right = current.left;     
		 }    
	}    
	 else if(current.left==null){     
		 if(current==root){      
			 root = current.right;     
		 }
		 else if(isLeftChild){      
			 parent.left = current.right;     
		 }
		 else{      
			 parent.right = current.right;     
		 }         
	}
	 else if(current.left!=null && current.right!=null){          
		 //now we have found the minimum element in the right sub tree     
		 Node successor  = getSuccessor(current);     
		 if(current==root){      
			 root = successor;     
		 }
		 else if(isLeftChild){      
			 parent.left = successor;     
		 }
		 else{      
			 parent.right = successor;     
		 }        
		 successor.left = current.left;    
	}      
	 return true;     
 }
/**
 * @getSuccessor- finds the successor of a specific pokemon object 
 * @param deleNode
 * @return
 */
public Node getSuccessor(Node deleNode){    
	 Node successors =null;    
	 Node successorsParent =null;    
	 Node current = deleNode.right;    
	 while(current!=null){     
		 successorsParent = successors;     
		 successors = current;     
		 current = current.left;    
		 }    //check if successor has the right child, it cannot have left child for sure    
	 		 // if it does have the right child, add it to the left of successorParent. 
	 		//  successsorParent    
	 if(successors!=deleNode.right){ 
    successorsParent.left = successors.right;     
    successors.right = deleNode.right;    
    }   
	 while(successors != null){
			System.out.println("Successor: ");
		 return successors;   
		 }
		 	System.out.println("No successor for: ");
			 return deleNode;
 }
/**
 * @getPredecessorBasedNum - finds the predecessor of a pokemon object
 *  in the binary tree based on the number attribute
 * @param a
 * @return
 */
 public String getPredeccessorBasedNum(Pokemon a){
	 Node current = root2;
	 Node predecessor = null;
	 Node predecessorParent = null;
	  if (findBasedNum(a) == true){
		  while(current!=null){    
				 if(current.data == a.getNumber()){
					 if(current.left != null){
					 current = current.left;
					while(current != null){
						predecessorParent = predecessor;
						predecessor = current;
						current = current.right;
						}
					System.out.println("Predecessor:");
					return predecessor.name;
					
					 }
					 else{
						 if(a.getNumber() < root2.data){
							current = root2;
							current = current.left;
						 }
							else if(a.getNumber()>root2.data){
								current = root2;
							}
							while(current != null){
							if(current.data < a.getNumber()){
							predecessorParent = current;
							current = current.right;
								if(current.data >= a.getNumber()){
									System.out.println("Predecessor:");
									return predecessorParent.name;
								}
								else
									System.out.println("Predecessor:");
									return current.name;
							}
							else
								current = current.left;
						 }
					}//end of else
				 }
				 
				 else if(current.data> a.getNumber()){  
					 predecessorParent = current;
					 current = current.left; 
				 }
				 else
				 {   predecessorParent = current;
					 current = current.right; 
				 }   
			}
	  	}
	  else{
		System.out.println("No element in Tree");
	  }
	  System.out.println("This element does not have a predecessor");
	return a.getName();
 }
/**
 * @getPredecessorBasedName - fins the predecessro for a pokemon object in the binary tree
 * base on the name attribute 
 * @param a
 * @return
 */
public String getPredeccessorBasedName(Pokemon a){
	 Node current = root;
	 Node predecessor = null;
	 Node predecessorParent = null;
	  if (findBasedName(a) == true){
		  while(current!=null){    
				 if(current.name == a.getName()){
					 if(current.left != null){
					 current = current.left;
					while(current != null){
						predecessorParent = predecessor;
						predecessor = current;
						current = current.right;
						}
					System.out.println("\nPredecessor:");
					return predecessor.name;
					
					 }
					 else{
						 if(a.getName().compareToIgnoreCase(root.name)<0){
							current = root;
							current = current.left;
						 }
							else if(a.getName().compareToIgnoreCase(root.name)>0){
								current = root;
							}
							while(current != null){
							if(current.name.compareToIgnoreCase(a.getName())<0){
							predecessorParent = current;
							current = current.right;
								if(current.name.compareToIgnoreCase(a.getName())>=0){
									System.out.println("Predecessor:");
									return predecessorParent.name;
								}
								else
									System.out.println("Predecessor:");
									return current.name;
							}
							else
								current = current.left;
						 }
					}//end of else
				 }
				 
				 else if(current.name.compareToIgnoreCase(a.getName())>0){  
					 predecessorParent = current;
					 current = current.left; 
				 }
				 else
				 {   predecessorParent = current;
					 current = current.right; 
				 }   
			}
	  	}
	  else{
		System.out.println("No element in Tree");
	  }
	  System.out.println("This element does not have a predecessor");
	return a.getName();
 }
/**
 * @isomorphic - checks if two binary search are isomorphic or not
 * @param root
 * @param root2
 * @return
 */
 public boolean isomorphic(Node root, Node root2){
	 if(root==null && root2==null)
		 {return true;}
	 else if(root !=null && root2==null || root==null && root2!=null){
		 return false;
	 }
	 return(isomorphic(root.left,root2.left) && isomorphic(root.right,root2.right));
		 
	 
	 
 }
 /**
  * @inOrder - prints the pokemon binary search trees in-order
  * @param root
  */
 public void inOrder(Node root){    
	 if(root!=null){     
		 inOrder (root.left);     
		 System.out.print(" " + root.name +"/"+ root.data);     
		 inOrder (root.right);    
		 }   
	 }
 /**
  * @preOrder - prints the pokemon binary search trees in pre-order
  * @param root
  */
 public void preOrder(Node root){
	 if(root!=null){  
		 System.out.print(" " + root.name +"/"+ root.data);
		 preOrder(root.left);
		 preOrder (root.right);      
		 } 
 }
 /**
  * @postOrder - prints the binary search trees in post-order
  * @param root
  */
 public void postOrder(Node root){
	 if(root!=null){   
		 postOrder(root.left);
		 postOrder (root.right);
		 System.out.print(" " + root.name +"/"+ root.data);      
		 } 
 }

}