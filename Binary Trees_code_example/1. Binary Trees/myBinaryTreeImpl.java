
public class myBinaryTreeImpl<T> implements myBinaryTree<T> {

	public static int count = 0;
	
	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private myBinaryNode<T> root;
	
	//-------------------------------------------------------------------
	// Create a non-empty myBinaryTree using a new element and two myBinaryTree: create_empty
	//-------------------------------------------------------------------
	//public myBinaryTree create_from_element_and_trees(myBinaryNode<T> n); --> Java does not support constructors in interfaces

	public myBinaryTreeImpl(myBinaryNode<T> node){
		if (node == null)
			this.root = null;
		else
			this.root = node;	
	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Get root of myBinaryTree: my_root
	//-------------------------------------------------------------------	
	public myBinaryNode<T> my_root() {
		return this.root;
	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Get left tree of myBinaryTree: my_left_tree
	//-------------------------------------------------------------------
	public myBinaryTree<T> my_left_tree() throws myException{		
		if (this.root != null){
			myBinaryTree<T> res = new myBinaryTreeImpl<T>(this.root.getLeft());
			return res;
		}
		else
			throw new myException("The tree is empty, so there is no left subtree");			
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Get right tree of myBinaryTree: my_right_tree
	//-------------------------------------------------------------------
	public myBinaryTree<T> my_right_tree() throws myException{
		if (this.root != null){
			myBinaryTree<T> res = new myBinaryTreeImpl<T>(this.root.getRight());
			return res;
		}
		else
			throw new myException("The tree is empty, so there is no right subtree");			
	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Check if myBinaryTree is empty: my_is_empty
	//-------------------------------------------------------------------
	public boolean my_is_empty(){
		return (this.root == null);
	}	
	
	//-------------------------------------------------------------------
	// Additional Operation --> Check the max number of levels of myBinaryTree: my_length
	//-------------------------------------------------------------------
	public int my_length(){	
		
		int num;
		
		if (this.my_is_empty() == true)
			num = 0;
		else{
			int l1 = this.my_left_tree().my_length();
			int l2 = this.my_right_tree().my_length();
			num = Math.max(l1,l2) + 1;
		}
		
		count++;
		System.out.println(count);
		return num;
	}

	//-------------------------------------------------------------------
	// Additional Operation --> Count the amount of nodes of myBinaryTree: my_node_count
	//-------------------------------------------------------------------
	public int my_node_count(){
		int num;
		
		if (this.my_is_empty() == true)
			num = 0;
		else{
			int c1 = this.my_left_tree().my_node_count();
			int c2 = this.my_right_tree().my_node_count();
			num = c1 + c2 + 1;
		}
		
		return num;	
	}

	//-------------------------------------------------------------------
	// Additional Operation --> Count the amount of leaf nodes of myBinaryTree: my_leaf_count
	//-------------------------------------------------------------------
	public int my_leaf_count(){
		int num;
		
		if (this.my_is_empty() == true)
			num = 0;
		else{
			if ((this.my_left_tree().my_is_empty() == true) && (this.my_right_tree().my_is_empty() == true))
				num = 1;
			else{
				int l1 = this.my_left_tree().my_leaf_count();
				int l2 = this.my_right_tree().my_leaf_count();
				num = l1 + l2;
			}
		}
		
		return num;	
	}

	//-------------------------------------------------------------------
	// Additional Operation --> Mirror the myBinaryTree: my_mirror
	//-------------------------------------------------------------------
	public myBinaryTree<T> my_mirror(){
		myBinaryTree<T> res;
		
		if (this.my_is_empty() == true)
			res = new myBinaryTreeImpl<T>(null);
		else{
			myBinaryTree<T> mirrorLeft = this.my_left_tree().my_mirror();
			myBinaryTree<T> mirrorRight = this.my_right_tree().my_mirror();		
			
			myBinaryNode<T> node = new myBinaryNode<T>(this.my_root().getInfo());
			node.setLeft(mirrorRight.my_root());
			node.setRight(mirrorLeft.my_root());			
			res = new myBinaryTreeImpl<T>(node);
		}
		
		return res;	
	}

	//-------------------------------------------------------------------
	// Traversal Operation --> Traverse myBinaryTree in in-order: my_inorder
	//-------------------------------------------------------------------
	public myList<T> my_inorder(){
		//1. We create the empty list
		myList<T> list = new myListLinkedList<T>();
		
		//2. If the root node is not empty
		if (this.my_is_empty() == false){
			//2.1. We create the list of traversing the left and right sub-trees
			myList<T> list1 = this.my_left_tree().my_inorder();
			myList<T> list2 = this.my_right_tree().my_inorder();	
	
			//2.2. We add the elements of list1 to list
			int k1 = list1.my_get_length();
			for (int i = 0; i < k1; i++)
				list.my_add_element(i, list1.my_get_element(i));
			
			//2.3. We add the root element to list
			list.my_add_element(k1, this.my_root().getInfo());
			
			//2.4. We add the elements of list2 to list
			int k2 = list2.my_get_length();			
			for (int i = 0; i < k2; i++)
				list.my_add_element((k1+1+i), list2.my_get_element(i));						
		}
		
		//3. We return the list
		return list;	
	}
	
	//-------------------------------------------------------------------
	// Traversal Operation --> Traverse myBinaryTree in pre-order: my_preorder
	//-------------------------------------------------------------------
	public myList<T> my_preorder(){
		//1. We create the empty list
		myList<T> list = new myListLinkedList<T>();
		
		//2. If the root node is not empty
		if (this.my_is_empty() == false){
			//2.1. We create the list of traversing the left and right sub-trees
			myList<T> list1 = this.my_left_tree().my_preorder();
			myList<T> list2 = this.my_right_tree().my_preorder();	
	
			//2.2. We add the root element to list
			list.my_add_element(0, this.my_root().getInfo());

			//2.3. We add the elements of list1 to list
			int k1 = list1.my_get_length();
			for (int i = 0; i < k1; i++)
				list.my_add_element(i+1, list1.my_get_element(i));
			
			//2.4. We add the elements of list2 to list
			int k2 = list2.my_get_length();			
			for (int i = 0; i < k2; i++)
				list.my_add_element((k1+1+i), list2.my_get_element(i));						
		}
		
		//3. We return the list
		return list;	
	}

	//-------------------------------------------------------------------
	// Traversal Operation --> Traverse myBinaryTree in post-order: my_postorder
	//-------------------------------------------------------------------
	public myList<T> my_postorder(){
		//1. We create the empty list
		myList<T> list = new myListLinkedList<T>();
		
		//2. If the root node is not empty
		if (this.my_is_empty() == false){
			//2.1. We create the list of traversing the left and right sub-trees
			myList<T> list1 = this.my_left_tree().my_postorder();
			myList<T> list2 = this.my_right_tree().my_postorder();	
	
			//2.2. We add the elements of list1 to list
			int k1 = list1.my_get_length();
			for (int i = 0; i < k1; i++)
				list.my_add_element(i, list1.my_get_element(i));
			
			//2.3. We add the elements of list2 to list
			int k2 = list2.my_get_length();			
			for (int i = 0; i < k2; i++)
				list.my_add_element((k1+i), list2.my_get_element(i));						

			//2.4. We add the root element to list
			list.my_add_element(k1+k2, this.my_root().getInfo());
		}
		
		//3. We return the list
		return list;	
	}
	
}
