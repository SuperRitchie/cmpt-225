package binarytree;

public class BTNode<T> {
	private T data;
	private BTNode<T> leftChild;
	private BTNode<T> rightChild;
	private BTNode<T> parent;

	public BTNode(T data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
		this.parent = null;
	}

	public BTNode(T data, BTNode<T> left, BTNode<T> right, BTNode<T> parent) {
		this.data = data;
		if (left!=null)
			setLeftChild(left);
		if (right!=null)
			setRightChild(right);
		this.parent = parent;
	}

	public T getData() {
		return data;
	}

	public BTNode<T> getLeftChild() {
		return leftChild;
	}

	public BTNode<T> getRightChild() {
		return rightChild;
	}

	public BTNode<T> getParent() {
		return parent;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setLeftChild(BTNode<T> leftChild) {
		this.leftChild = leftChild;
		if (leftChild != null)
			leftChild.parent = this;
	}

	public void setRightChild(BTNode<T> rightChild) {
		this.rightChild = rightChild;
		if (rightChild != null)
			rightChild.parent = this;
	}

	public void setParent(BTNode<T> parent) {
		this.parent = parent;
	}


}
