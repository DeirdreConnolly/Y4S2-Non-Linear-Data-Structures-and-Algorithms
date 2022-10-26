

public class myGeneralTreeImpl<T> implements myGeneralTree<T> {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private myGeneralNode<T> root;

	//-------------------------------------------------------------------
	// Create a non-empty myGeneralTree from a myGeneralNode: create_from_general_node()
	//-------------------------------------------------------------------
	//public myGeneralTree create_from_general_node(); --> Java does not support constructors in interfaces

	public myGeneralTreeImpl(myGeneralNode<T> node) throws myException{
		if (node != null)
			this.root = node;
		else
			throw new myException("A General Tree cannot be empty");
	}
		
	//-------------------------------------------------------------------
	// Basic Operation --> Get root of myGeneralTree: my_root
	//-------------------------------------------------------------------	
	public myGeneralNode<T> my_root() {
		return this.root;
	}
		
	//-------------------------------------------------------------------
	// Basic Operation --> Get i-est subtree of myGeneralTree: my_i_subtree
	//-------------------------------------------------------------------
	public myGeneralTree<T> my_i_subtree(int index) throws myException{
		try{
			myGeneralTree<T> res = new myGeneralTreeImpl<T>(this.root.get_linked_nodes().my_get_element(index));
			return res;			
		}
		catch(Exception ex){
			throw new myException("Cannot get the " + index + "-est subtree");
		}
	}
				
	//-------------------------------------------------------------------
	// Additional Operation --> Check the max number of levels of myGeneralTree: my_length
	//-------------------------------------------------------------------
	public int my_length(){
		int num = 0;
		
		//1. We get the number of subtrees
		int k = this.my_root().get_linked_nodes().my_get_length();
		
		//2. We explore them to get the biggest length of a subtree
		for (int i = 0; i < k; i++)
			num = Math.max(num, this.my_i_subtree(i).my_length());
		
		//3. We add 1 to that length (from the root node)
		num = num + 1;

		//4. We return this length
		return num;
	}
	
	//-------------------------------------------------------------------
	// Additional Operation --> Count the amount of nodes of myGeneralTree: my_node_count
	//-------------------------------------------------------------------
	public int my_node_count(){
		int num = 0;
		
		//1. We get the number of subtrees
		int k = this.my_root().get_linked_nodes().my_get_length();
		
		//2. We explore them to get the add their nodes to the count
		for (int i = 0; i < k; i++)
			num = num + this.my_i_subtree(i).my_node_count();
		
		//3. We add 1 to that count (from the root node)
		num = num + 1;

		//4. We return this length
		return num;
	}

	//-------------------------------------------------------------------
	// Additional Operation --> Count the amount of leaf nodes of myGeneralTree: my_leaf_count
	//-------------------------------------------------------------------
	public int my_leaf_count(){
		int num = 0;

		//1. We get the number of subtrees
		int k = this.my_root().get_linked_nodes().my_get_length();
		
		//2.1. If there are no subtrees is because this node is a leaf, so the num = 1 
		if (k == 0)
			num = 1;
		//2.2. If there are subtrees, then we traverse them to count their leaf nodes
		else		
			for (int i = 0; i < k; i++)
				num = num + this.my_i_subtree(i).my_leaf_count();

		//3. We return the num
		return num;		
	}

	//-------------------------------------------------------------------
	// Additional Operation --> Mirror the myGeneralTree: my_mirror
	//-------------------------------------------------------------------
	public myGeneralTree<T> my_mirror(){
		myGeneralTree<T> res;		
		
		//1. We get the number of subtrees
		int k = this.my_root().get_linked_nodes().my_get_length();
		
		//2. We get the node for the root
		myGeneralNode<T> node = new myGeneralNode<T>(this.my_root().getInfo());

		//3. We traverse the subtrees one by one, adding them to node in reverse order
		for (int i = 0; i < k; i++){
			myGeneralTree<T> myTree = this.my_i_subtree(k-(i+1)).my_mirror();
			node.get_linked_nodes().my_add_element(i, myTree.my_root());
		}
			
		//4. We create the tree based on the new node
		res = new myGeneralTreeImpl<T>(node);			
		
		//5. We return the mirrored tree
		return res;		
	}
	
	//-------------------------------------------------------------------
	// Traversal Operation --> Traverse myGeneralTree in pre-order: my_preorder
	//-------------------------------------------------------------------
	public myList<T> my_preorder(){
		//1. We create the empty list
		myList<T> list = new myListLinkedList<T>();
		int count = 0;

		//2. We get the number of subtrees
		int k = this.my_root().get_linked_nodes().my_get_length();

		//3. We add to the list the content of the root
		list.my_add_element(count, this.my_root().getInfo());
		count = count + 1;
		
		//4. We traverse them to get the final list
		for (int i = 0; i < k; i++){
			//3.1. We get the result of the subtree
			myList<T> aux_list = this.my_i_subtree(i).my_preorder();
			
			//3.2. We dump the content of aux_list to list
			int k1 = aux_list.my_get_length();
			for (int j = 0; j < k1; j++){
				list.my_add_element(count, aux_list.my_get_element(j));
				count = count + 1;
			}
		}
				
		//5. We return the list
		return list;			
	}
		
	//-------------------------------------------------------------------
	// Traversal Operation --> Traverse myGeneralTree in post-order: my_postorder
	//-------------------------------------------------------------------
	public myList<T> my_postorder(){
		//1. We create the empty list
		myList<T> list = new myListLinkedList<T>();
		int count = 0;

		//2. We get the number of subtrees
		int k = this.my_root().get_linked_nodes().my_get_length();
		
		//3. We traverse them to get the final list
		for (int i = 0; i < k; i++){
			//3.1. We get the result of the subtree
			myList<T> aux_list = this.my_i_subtree(i).my_postorder();
			
			//3.2. We dump the content of aux_list to list
			int k1 = aux_list.my_get_length();
			for (int j = 0; j < k1; j++){
				list.my_add_element(count, aux_list.my_get_element(j));
				count = count + 1;
			}
		}
		
		//4. We add to the list the content of the root
		list.my_add_element(count, this.my_root().getInfo());
		
		//5. We return the list
		return list;	
	
	
	}
	
}
