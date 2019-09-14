public class BinarySearchTree { 
	public Node root;
	/**
	 * @BinarySearchTree - default constructor
	 */
	public BinarySearchTree(){   
		root = null;  
		} 
	/**
	 * @find - locates an element within the binary search tree and return true if found
	 * @param n
	 * @return
	 */
 public boolean find(int n){   
	 Node current = root;   
	 while(current!=null){    
		 if(current.data == n){     
			 return true;    
		 }
		 else if(current.data> n){     
			 current = current.left;    
		 }
		 else
		 {     
			 current = current.right;    
		 }   
	}   
	 return false;  
 }      
 /**
  * @insert - inserts an element into the binary search tree
  * @param n
  */
 public void insert(int n){  
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
	  if( n < current.data)    
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
  * @delete - deletes an element from the binary search tree if found
  * @param n
  * @return
  */
 public boolean delete(int n){   
	 Node parent = root;   
	 Node current = root;      
	 boolean isLeftChild = false;   
	 while(current.data!=n){        
		 parent = current;    
		 if(current.data>n){     
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
  * @getSuccessor- returns the successor of a specific element within the binary search tree
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
  * @getPredeccessor- returns the predecessor of a specific element within the binary search tree
  * @param a
  * @return
  */
 public int getPredeccessor(int a){
	 Node current = root;
	 Node predecessor = null;
	 Node predecessorParent = null;
	  if (find(a) == true){
		  while(current!=null){    
				 if(current.data == a){
					 if(current.left != null){
					 current = current.left;
					while(current != null){
						predecessorParent = predecessor;
						predecessor = current;
						current = current.right;
						}
					System.out.println("\nThe predecessor of " + a + " is");
					return predecessor.data;
					
					 }
					 else{
						 if(a < root.data){
							current = root;
							current = current.left;
						 }
							else if(a>root.data){
								current = root;
							}
							while(current != null){
							if(current.data < a){
							predecessorParent = current;
							current = current.right;
								if(current.data >= a){
									System.out.println("\nThe predecessor of " + a + " is");
									return predecessorParent.data;
								}
								else
									System.out.println("\nThe predecessor of " + a + " is");
									return current.data;
							}
							else
								current = current.left;
						 }
					}//end of else
				 }
				 
				 else if(current.data> a){  
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
	return a;
 }
 /**
  * @inOrder- prints the in-order format of the binary tree
  * @param root
  */
 public void inOrder(Node root){    
	 if(root!=null){     
		 inOrder (root.left);     
		 System.out.print(" " + root.data);     
		 inOrder (root.right);    
		 }   
	 }
 /**
  * @preOrder - prints the pre-order format of the binary tree
  * @param root
  */
 public void preOrder(Node root){
	 if(root!=null){  
		 System.out.print(" " + root.data);
		 preOrder(root.left);
		 preOrder (root.right);      
		 } 
 }
 /**
  * @postOrder- prints the post order format of the binary tree
  * @param root
  */
 public void postOrder(Node root){
	 if(root!=null){     
		 postOrder(root.left);
		 postOrder (root.right);
		 System.out.print(" " + root.data);      
		 } 
 }
}