package structure.trees.bst;

public class BST {
	Node root;

	class Node {
		int value;
		Node left, right;

		Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	BST() {
		this.root = null;
	}

	public void add(int value) {
		root = add(root, value);
	}

	private Node add(Node root, int value) {
		if (root == null) {
			root = new Node(value);
			return root;
		} else if (root.value > value) {
			root.left = add(root.left, value);
		} else if (root.value < value) {
			root.right = add(root.right, value);
		}
		return root;
	}

	public void delete(int value) {
		delete(root, value);
	}

	private Node delete(Node root, int value) {
		if (root == null)
			return root;
		else if (root.value > value) {
			root.left = delete(root.left, value);
		} else if (root.value < value) {
			root.right = delete(root.right, value);
		} else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)

				return root.left;
			root.value = minValue(root.right);

			// Delete the inorder successor
			root.right = delete(root.right, root.value);
		}
		return root;
	}

	int minValue(Node root) {
		int minValue = root.value;
		while (root.left != null) {
			minValue(root.left);
		}
		return minValue;
	}

	public void print() {
		print_Inorder(root);
	}

	private void print_Inorder(Node root) {
		if (root == null)
			return;
		print_Inorder(root.left);
		System.out.println(root.value);
		print_Inorder(root.right);
	}

	public static void main(String[] args) {
		BST bst = new BST();
		bst.add(1);
		bst.add(-3);
		bst.add(2);
		bst.add(6);
		bst.add(-2);
		bst.delete(1);
		bst.print();
	}
}