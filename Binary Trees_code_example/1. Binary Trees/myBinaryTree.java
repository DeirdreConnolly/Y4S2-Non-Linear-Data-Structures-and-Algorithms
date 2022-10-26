
public interface myBinaryTree<T> {
	
	//-------------------------------------------------------------------
	// Create a non-empty myBinaryTree from a myBinaryNode: create_from_binary_node()
	//-------------------------------------------------------------------
	//public myBinaryTree create_from_binary_node(myBinaryNode<T> n); --> Java does not support constructors in interfaces	
	
	//-------------------------------------------------------------------
	// Basic Operation --> Get root of myBinaryTree: my_root
	//-------------------------------------------------------------------	
	public myBinaryNode<T> my_root();
	
	//-------------------------------------------------------------------
	// Basic Operation --> Get left tree of myBinaryTree: my_left_tree
	//-------------------------------------------------------------------
	public myBinaryTree<T> my_left_tree() throws myException;
		
	//-------------------------------------------------------------------
	// Basic Operation --> Get left tree of myBinaryTree: my_right_tree
	//-------------------------------------------------------------------
	public myBinaryTree<T> my_right_tree() throws myException;
	
	//-------------------------------------------------------------------
	// Basic Operation --> Check if myBinaryTree is empty: my_is_empty
	//-------------------------------------------------------------------
	public boolean my_is_empty();

	//-------------------------------------------------------------------
	// Additional Operation --> Check the max number of levels of myBinaryTree: my_length
	//-------------------------------------------------------------------
	public int my_length();
	
	//-------------------------------------------------------------------
	// Additional Operation --> Count the amount of nodes of myBinaryTree: my_node_count
	//-------------------------------------------------------------------
	public int my_node_count();
	
	//-------------------------------------------------------------------
	// Additional Operation --> Count the amount of leaf nodes of myBinaryTree: my_leaf_count
	//-------------------------------------------------------------------
	public int my_leaf_count();

	//-------------------------------------------------------------------
	// Additional Operation --> Mirror the myBinaryTree: my_mirror
	//-------------------------------------------------------------------
	public myBinaryTree<T> my_mirror();

	//-------------------------------------------------------------------
	// Traversal Operation --> Traverse myBinaryTree in in-order: my_inorder
	//-------------------------------------------------------------------
	public myList<T> my_inorder();
	
	//-------------------------------------------------------------------
	// Traversal Operation --> Traverse myBinaryTree in pre-order: my_preorder
	//-------------------------------------------------------------------
	public myList<T> my_preorder();

	//-------------------------------------------------------------------
	// Traversal Operation --> Traverse myBinaryTree in post-order: my_postorder
	//-------------------------------------------------------------------
	public myList<T> my_postorder();
	
}