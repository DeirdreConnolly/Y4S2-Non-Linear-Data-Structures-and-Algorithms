

public class myGeneralNode<T> {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private T info;
	private myList<myGeneralNode<T>> linkedNodes;	
	
	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------
	public myGeneralNode(T n){
		this.info = n;
		this.linkedNodes = new myListLinkedList<myGeneralNode<T>>();
	}
	
	//--------------------------------------------------
	// get_info
	//--------------------------------------------------
	public T getInfo(){
		return this.info;
	}
	
	//--------------------------------------------------
	// set_info
	//--------------------------------------------------
	public void setInfo(T n){
		this.info = n;
	}

	//--------------------------------------------------
	// get_linked
	//--------------------------------------------------
	public myList<myGeneralNode<T>> get_linked_nodes(){
		return this.linkedNodes;
	}
		
}
