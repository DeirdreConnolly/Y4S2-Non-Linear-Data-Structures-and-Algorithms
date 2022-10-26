
public interface myBinarySearchTree<T1 extends Comparable<? super T1>, T2> {

	//-------------------------------------------------------------------
	// Create a non-empty myBinarySearchTree from a myBinarySearchNode: create_from_binary_search_node()
	//-------------------------------------------------------------------
	//public myBinarySearchTree create_from_binary_search_node(myBinarySearchNode<T> n); --> Java does not support constructors in interfaces
	
	//-------------------------------------------------------------------
	// Basic Operation --> Get root of myBinarySearchTree: my_root
	//-------------------------------------------------------------------	
	public myBinarySearchNode<T1, T2> my_root();
	
	//-------------------------------------------------------------------
	// Basic Operation --> Get left tree of myBinarySearchTree: my_left_tree
	//-------------------------------------------------------------------
	public myBinarySearchTree<T1, T2> my_left_tree() throws myException;
		
	//-------------------------------------------------------------------
	// Basic Operation --> Get left tree of myBinarySearchTree: my_right_tree
	//-------------------------------------------------------------------
	public myBinarySearchTree<T1, T2> my_right_tree() throws myException;
	
	//-------------------------------------------------------------------
	// Basic Operation --> Check if myBinarySearchTree is empty: my_is_empty
	//-------------------------------------------------------------------
	public boolean my_is_empty();

	//-------------------------------------------------------------------
	// Additional Operation --> Check the max number of levels of myBinarySearchTree: my_length
	//-------------------------------------------------------------------
	public int my_length();
	
	//-------------------------------------------------------------------
	// Additional Operation --> Count the amount of nodes of myBinarySearchTree: my_node_count
	//-------------------------------------------------------------------
	public int my_node_count();
	
	//-------------------------------------------------------------------
	// Additional Operation --> Count the amount of leaf nodes of myBinarySearchTree: my_leaf_count
	//-------------------------------------------------------------------
	public int my_leaf_count();

	//-------------------------------------------------------------------
	// Additional Operation --> Mirror the myBinarySearchTree: my_mirror
	//-------------------------------------------------------------------
	//public myBinarySearchTree<T> my_mirror();

	//-------------------------------------------------------------------
	// Traversal Operation --> Traverse myBinarySearchTree in in-order: my_inorder
	//-------------------------------------------------------------------
	public myList<T2> my_inorder();
	
	//-------------------------------------------------------------------
	// Traversal Operation --> Traverse myBinarySearchTree in pre-order: my_preorder
	//-------------------------------------------------------------------
	public myList<T2> my_preorder();

	//-------------------------------------------------------------------
	// Traversal Operation --> Traverse myBinarySearchTree in post-order: my_postorder
	//-------------------------------------------------------------------
	public myList<T2> my_postorder();
		
	//-------------------------------------------------------------------
	// Basic Operation --> Find element at myBinarySearchTree: my_find
	//-------------------------------------------------------------------	
	public myBinarySearchNode<T1,T2> my_find(T1 key);
		
	//-------------------------------------------------------------------
	// Basic Operation --> Insert element at myBinarySearchTree: my_insert
	//-------------------------------------------------------------------	
	public myBinarySearchTree<T1, T2> my_insert(T1 key, T2 info);	

	//-------------------------------------------------------------------
	// Basic Operation --> Remove element at myBinarySearchTree: my_remove
	//-------------------------------------------------------------------	
	public myBinarySearchTree<T1, T2> my_remove(T1 key);	
	
	//-------------------------------------------------------------------
	// Basic Operation --> Get maximum element at myBinarySearchTree: my_maximum
	//-------------------------------------------------------------------	
	public myBinarySearchNode<T1, T2> my_maximum() throws myException;	

	//-------------------------------------------------------------------
	// Basic Operation --> Get minimum element at myBinarySearchTree: my_minimum
	//-------------------------------------------------------------------	
	public myBinarySearchNode<T1, T2> my_minimum() throws myException;	
	
}
