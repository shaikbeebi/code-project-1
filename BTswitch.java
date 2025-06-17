import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int value) {
		data = value;
		left = right = null;
	}
}

public class BTswitch {
	Node root;

	public BTswitch() {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
	}

	public void printPreorder(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	}

	public void printInorder(Node node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	public void printPostorder(Node node) {
		if (node == null)
			return;
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.data + " ");
	}

	public int findCount(Node node) {
		if (node == null)
			return 0;
		return 1 + findCount(node.left) + findCount(node.right);
	}

	public int noOfLeafnodes(Node node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		return noOfLeafnodes(node.left) + noOfLeafnodes(node.right);
	}

	public int sumOfNodes(Node node) {
		if (node == null)
			return 0;
		return node.data + sumOfNodes(node.left) + sumOfNodes(node.right);
	}

	public int maxOfElements(Node node) {
		if (node == null)
			return Integer.MIN_VALUE;
		int leftMax = maxOfElements(node.left);
		int rightMax = maxOfElements(node.right);
		return Math.max(node.data, Math.max(leftMax, rightMax));
	}

	public int findHeight(Node node) {
		if (node == null)
			return -1;
		int lh = findHeight(node.left);
		int rh = findHeight(node.right);
		return Math.max(lh, rh) + 1;
	}

	public static void main(String[] args) {
		BTswitch tree = new BTswitch();
		Scanner sc = new Scanner(System.in);

		int ch;
		do {
			System.out.println("\n1 Preorder Traversal");
			System.out.println("2 Inorder Traversal");
			System.out.println("3 Postorder Traversal");
			System.out.println("4 Count of Nodes");
			System.out.println("5 Number of Leaf Nodes");
			System.out.println("6 Sum of Nodes");
			System.out.println("7 Maximum Element");
			System.out.println("8 Height of Tree");
			System.out.println("0 Exit");
			System.out.print("Enter your choice: ");
			ch = sc.nextInt();

			switch (ch) {
				case 1:
					System.out.println("Preorder:");
					tree.printPreorder(tree.root);
					System.out.println();
					break;
				case 2:
					System.out.println("Inorder:");
					tree.printInorder(tree.root);
					System.out.println();
					break;
				case 3:
					System.out.println("Postorder:");
					tree.printPostorder(tree.root);
					System.out.println();
					break;
				case 4:
					System.out.println("Count: " + tree.findCount(tree.root));
					break;
				case 5:
					System.out.println("No Of Leaf Nodes: " + tree.noOfLeafnodes(tree.root));
					break;
				case 6:
					System.out.println("Sum of Nodes: " + tree.sumOfNodes(tree.root));
					break;
				case 7:
					System.out.println("Max Element: " + tree.maxOfElements(tree.root));
					break;
				case 8:
					System.out.println("Height: " + tree.findHeight(tree.root));
					break;
				case 0:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid choice, try again.");
			}
		} while (ch != 0);

		sc.close();
	}
}
