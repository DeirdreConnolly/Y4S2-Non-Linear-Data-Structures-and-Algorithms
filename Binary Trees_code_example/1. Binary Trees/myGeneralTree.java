
public interface myGeneralTree<T> {
	
	//-------------------------------------------------------------------
	// Create a non-empty myGeneralTree from a myGeneralNode: create_from_general_node()
	//-------------------------------------------------------------------
	//public myGeneralTree create_from_general_node(); --> Java does not support constructors in interfaces
	
	//-------------------------------------------------------------------
	// Basic Operation --> Get root of myGeneralTree: my_root
	//-------------------------------------------------------------------	
	public myGeneralNode<T> my_root();
	
	//-------------------------------------------------------------------
	// Basic Operation --> Get i-est subtree of myGeneralTree: my_i_subtree
	//-------------------------------------------------------------------
	public myGeneralTree<T> my_i_subtree(int index) throws myException;
	
	//-------------------------------------------------------------------
	// Additional Operation --> Check the max number of levels of myGeneralTree: my_length
	//-------------------------------------------------------------------
	public int my_length();
	
	//-------------------------------------------------------------------
	// Additional Operation --> Count the amount of nodes of myGeneralTree: my_node_count
	//-------------------------------------------------------------------
	public int my_node_count();
	
	//-------------------------------------------------------------------
	// Additional Operation --> Count the amount of leaf nodes of myGeneralTree: my_leaf_count
	//-------------------------------------------------------------------
	public int my_leaf_count();

	//-------------------------------------------------------------------
	// Additional Operation --> Mirror the myGeneralTree: my_mirror
	//-------------------------------------------------------------------
	public myGeneralTree<T> my_mirror();	
	
	//-------------------------------------------------------------------
	// Traversal Operation --> Traverse myGeneralTree in pre-order: my_preorder
	//-------------------------------------------------------------------
	public myList<T> my_preorder();

	//-------------------------------------------------------------------
	// Traversal Operation --> Traverse myGeneralTree in post-order: my_postorder
	//-------------------------------------------------------------------
	public myList<T> my_postorder();
	
}