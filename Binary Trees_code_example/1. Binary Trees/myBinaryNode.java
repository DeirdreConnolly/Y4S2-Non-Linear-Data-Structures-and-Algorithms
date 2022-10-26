
public class myBinaryNode<T> {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private T info;
	private myBinaryNode<T> left;	
	private myBinaryNode<T> right;
	
	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------
	public myBinaryNode(T n){
		this.info = n;
		this.left = null;
		this.right = null;
	}
	
	//--------------------------------------------------
	// Get methods
	//--------------------------------------------------
	public T getInfo(){
		return this.info;
	}

	public myBinaryNode<T> getLeft(){
		return this.left;
	}	

	public myBinaryNode<T> getRight(){
		return this.right;
	}
	
	//--------------------------------------------------
	// Set methods
	//--------------------------------------------------
	public void setInfo(T n){
		this.info = n;
	}
	
	public void setLeft(myBinaryNode<T> n){
		this.left = n;
	}
	
	public void setRight(myBinaryNode<T> n){
		this.right = n;
	}
	
}
