package in.ineuron.comp;


import java.util.Stack;

class Node {
	int data;
	Node left;
	Node right;

/* Helper function that allocates a new node with the
given data and NULL left and right pointers. */
	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

public class BTToDoublyLL {
	static Node bToDLL(Node root) {
		Stack<Pair<Node, Integer>> s = new Stack<>();
		s.push(new Pair<>(root, 0));
		boolean flag = true;
		Node head = null;
		Node prev = null;
		while (!s.empty()) {
			Pair<Node, Integer> x = s.pop();
			Node t = x.getKey();
			int state = x.getValue();
			if (state == 3 || t == null) {
				continue;
			}
			s.push(new Pair<>(t, state + 1));
			if (state == 0) {
				s.push(new Pair<>(t.left, 0));
			} else if (state == 1) {
				if (prev != null) {
					prev.right = t;
				}
				t.left = prev;
				prev = t;
				if (flag) {
					head = t;
					flag = false;
				}
			} else if (state == 2) {
				s.push(new Pair<>(t.right, 0));
			}
		}
		return head;
	}

/* Function to print nodes in a given doubly linked list */
	static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.right;
		}
	}

	public static void main(String[] args)
	{
		
		// Let us create the tree shown in above diagram
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(20);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		

		// Convert to DLL
		Node head = bToDLL(root);

		// Print the converted list
		printList(head);
	}
}

class Pair<K, V> {
	private K key;
	private V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}


