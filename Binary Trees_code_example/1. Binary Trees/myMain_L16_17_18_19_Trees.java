
public class myMain_L16_17_18_19_Trees {
	
	//-------------------------------------------------------------------
	// displayList 
	//-------------------------------------------------------------------		
	public static void displayList(myList<?> l){
		int k = l.my_get_length();
		for (int i = 0; i < k; i++)
			System.out.println("Element " + (i+1) + ": " + l.my_get_element(i));
		System.out.println();		
	}
	
	//-------------------------------------------------------------------
	// playingWithBinaryTrees 
	//-------------------------------------------------------------------		
	public static void playingWithBinaryTrees(){
		//1. We create out tree
		/*
		  					1
		  				2       8
		 			 3     6       9
		 		    4 5   7
		*/
		
		
		//i. We create a couple of auxiliary node and tree variables
		myBinaryNode<Integer> node;
		myBinaryTree<Integer> myTree1;
		myBinaryTree<Integer> myTree2;		
				
		//ii. We create the subtree consisting just on the 4
		node = new myBinaryNode<Integer>(4);
		myTree1 = new myBinaryTreeImpl<Integer>(node);
		
		//iii. We create the subtree consisting just on the 5		
		node = new myBinaryNode<Integer>(5);
		myTree2 = new myBinaryTreeImpl<Integer>(node);
		
		//iv. We create the subtree consisting on the   3
		//										   4 5
		node = new myBinaryNode<Integer>(3);
		node.setLeft(myTree1.my_root());
		node.setRight(myTree2.my_root());		
		myTree1 = new myBinaryTreeImpl<Integer>(node);
		
		//v. We create the subtree consisting just on the 7
		node = new myBinaryNode<Integer>(7);
		myTree2 = new myBinaryTreeImpl<Integer>(node);
		
		//vi. We create the subtree consisting on the   6
		//										      7
		node = new myBinaryNode<Integer>(6);
		node.setLeft(myTree2.my_root());
		myTree2 = new myBinaryTreeImpl<Integer>(node);
		
		//vii. We create the subtree consisting on the    2
		//										      3     6
		//											 4 5   7
		node = new myBinaryNode<Integer>(2);
		node.setLeft(myTree1.my_root());
		node.setRight(myTree2.my_root());		
		myTree1 = new myBinaryTreeImpl<Integer>(node);
		
		//viii. We create the subtree consisting just on 9		
		node = new myBinaryNode<Integer>(9);
		myTree2 = new myBinaryTreeImpl<Integer>(node);

		//ix. We create the subtree consisting on 8
		//											  9
		node = new myBinaryNode<Integer>(8);
		node.setRight(myTree2.my_root());
		myTree2 = new myBinaryTreeImpl<Integer>(node);		
		
		//x. We create the final tree consisting on the			1
		//													2				8
		//										         3     6			   9
		//											    4 5   7
		
		node = new myBinaryNode<Integer>(1);
		node.setLeft(myTree1.my_root());
		node.setRight(myTree2.my_root());		
		myTree1 = new myBinaryTreeImpl<Integer>(node);
		
		//2. We print the length of the tree
		System.out.println("Length = " + myTree1.my_length());
		
		//3. We print the number of nodes of the tree		
		System.out.println("Nodes = " + myTree1.my_node_count());
		
		//4. We print the number of leaf nodes of the tree		
		System.out.println("Leaf = " + myTree1.my_leaf_count());
		
		//5. We get the mirror image of the tree
		myBinaryTree<Integer> m = myTree1.my_mirror();

		
		//6. We get the inorder traversal of the tree
		myList<Integer> l1 = myTree1.my_inorder();
		displayList(l1);
		
		//7. We get the preorder traversal of the tree
		myList<Integer> l2 = myTree1.my_preorder();
		displayList(l2);
		
		//8. We get the postorder traversal of the tree
		myList<Integer> l3 = myTree1.my_postorder();
		displayList(l3);	
		
		//9. We display the preorder of the mirror tree
		myList<Integer> l4 = m.my_preorder();
		displayList(l4);		
	}

	//-------------------------------------------------------------------
	// playingWithGeneralTrees 
	//-------------------------------------------------------------------	
	public static void playingWithGeneralTrees(){
		//1. We create out tree
		/*
		  					1
		  			2       3       4
					5    6 7 8 9
		*/
		
		//i. We create the myTree1 variable to host the tree and as many auxiliary variables as needed
		myGeneralNode<Integer> node;
		myGeneralTree<Integer> myTree1;
		myGeneralTree<Integer> myTree2;
		myGeneralTree<Integer> myTree3;		
		myGeneralTree<Integer> myTree4;
		myGeneralTree<Integer> myTree5;
				
		//ii. We create the subtree consisting just on the 5
		node = new myGeneralNode<Integer>(5);
		myTree1 = new myGeneralTreeImpl<Integer>(node);
		
		//iii. We create the subtree consisting on 2
		//										   5
		node = new myGeneralNode<Integer>(2);
		node.get_linked_nodes().my_add_element(0, myTree1.my_root());
		myTree1 = new myGeneralTreeImpl<Integer>(node);		
		
		//iv. We create the subtree consisting just on the 6
		node = new myGeneralNode<Integer>(6);
		myTree2 = new myGeneralTreeImpl<Integer>(node);

		//v. We create the subtree consisting just on the 7
		node = new myGeneralNode<Integer>(7);
		myTree3 = new myGeneralTreeImpl<Integer>(node);		

		//vi. We create the subtree consisting just on the 8
		node = new myGeneralNode<Integer>(8);
		myTree4 = new myGeneralTreeImpl<Integer>(node);		

		//vii. We create the subtree consisting just on the 9
		node = new myGeneralNode<Integer>(9);
		myTree5 = new myGeneralTreeImpl<Integer>(node);				

		//viii. We create the subtree consisting on     3
		//										     6 7 8 9		
		node = new myGeneralNode<Integer>(3);
		node.get_linked_nodes().my_add_element(0, myTree2.my_root());
		node.get_linked_nodes().my_add_element(1, myTree3.my_root());
		node.get_linked_nodes().my_add_element(2, myTree4.my_root());
		node.get_linked_nodes().my_add_element(3, myTree5.my_root());		
		myTree2 = new myGeneralTreeImpl<Integer>(node);		

		//ix. We create the subtree consisting just on the 4		
		node = new myGeneralNode<Integer>(4);
		myTree3 = new myGeneralTreeImpl<Integer>(node);

		//x. We create the final tree consisting on			
		//					1
		//			2       3       4
		//			5    6 7 8 9
		node = new myGeneralNode<Integer>(1);
		node.get_linked_nodes().my_add_element(0, myTree1.my_root());
		node.get_linked_nodes().my_add_element(1, myTree2.my_root());
		node.get_linked_nodes().my_add_element(2, myTree3.my_root());
		myTree1 = new myGeneralTreeImpl<Integer>(node);			

		//2. We print the length of the tree
		System.out.println("Length = " + myTree1.my_length());
		
		//3. We print the number of nodes of the tree		
		System.out.println("Nodes = " + myTree1.my_node_count());
		
		//4. We print the number of leaf nodes of the tree		
		System.out.println("Leaf = " + myTree1.my_leaf_count());
		
		//5. We get the mirror image of the tree
		myGeneralTree<Integer> m = myTree1.my_mirror();
	
		//6. We get the preorder traversal of the tree
		myList<Integer> l1 = myTree1.my_preorder();
		displayList(l1);
		
		//7. We get the postorder traversal of the tree
		myList<Integer> l2 = myTree1.my_postorder();
		displayList(l2);	
		
		//8. We display the preorder of the mirror tree
		myList<Integer> l3 = m.my_preorder();
		displayList(l3);				
	}

	//-------------------------------------------------------------------
	// playingWithBinaryTrees 
	//-------------------------------------------------------------------		
	public static void playingWithBinarySearchTrees(){
		//1. We create out tree
		/*
		  					7-G
		  				4-D        8-H
		 			2-B      6-F        9-I
		 		 1-A   3-C  5-E
		*/
		
		
		//i. We create a couple of auxiliary node and tree variables
		myBinarySearchTree<Integer, String> myTree1 = new myBinarySearchTreeImpl<Integer, String>(null);
		myTree1.my_insert(7, "G");
		myTree1.my_insert(4, "D");
		myTree1.my_insert(8, "H");		
		myTree1.my_insert(2, "B");
		myTree1.my_insert(6, "F");
		myTree1.my_insert(9, "I");
		myTree1.my_insert(1, "A");
		myTree1.my_insert(3, "C");
		myTree1.my_insert(5, "E");		
			
		//2. We print the length of the tree
		System.out.println("Length = " + myTree1.my_length());
		
		//3. We print the number of nodes of the tree		
		System.out.println("Nodes = " + myTree1.my_node_count());
		
		//4. We print the number of leaf nodes of the tree		
		System.out.println("Leaf = " + myTree1.my_leaf_count());
		
		//5. We get the mirror image of the tree
		//myBinarySearchTree<Integer> m = myTree1.my_mirror();

		
		//6. We get the inorder traversal of the tree
		myList<String> l1 = myTree1.my_inorder();
		displayList(l1);
		
		//7. We get the preorder traversal of the tree
		myList<String> l2 = myTree1.my_preorder();
		displayList(l2);
		
		//8. We get the postorder traversal of the tree
		myList<String> l3 = myTree1.my_postorder();
		displayList(l3);	
		
		//9. We display the preorder of the mirror tree
		//myList<Integer> l4 = m.my_preorder();
		//displayList(l4);	
		
		//10. Find an element
		System.out.println(myTree1.my_find(7).getInfo());
		System.out.println(myTree1.my_find(4).getInfo());
		System.out.println(myTree1.my_find(6).getInfo());		
		System.out.println(myTree1.my_find(9).getInfo());
		System.out.println(myTree1.my_find(3).getInfo());
		
		System.out.println(myTree1.my_find(11));
		
		System.out.println("Minimum :" + myTree1.my_minimum().getKey() + ", " + myTree1.my_minimum().getInfo());
		System.out.println("Maximum :" + myTree1.my_maximum().getKey() + ", " + myTree1.my_maximum().getInfo());	

		myTree1.my_remove(1);		
		myList<String> l4 = myTree1.my_preorder();
		displayList(l4);		
		
	}
	
	//-------------------------------------------------------------------
	// MAIN METHOD 
	//-------------------------------------------------------------------		
	public static void main(String[] args) {
		//1. We practise with Binary Trees
		//playingWithBinaryTrees();	

		//2. We practise with General Trees		
		//playingWithGeneralTrees();
		
		//3. We practise with Binary Search Trees
		playingWithBinarySearchTrees();		
	}

}
