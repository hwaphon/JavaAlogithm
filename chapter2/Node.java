package com.chapter2;

public class Node {
	int data;
	Node next = null;

	public Node(int d) {
		this.data = d;
	}

	public void append(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}

		n.next = end;
	}

	public Node delete(Node head, int d) {
		Node n = head;

		if (n.data == d) {
			return n.next;
		}

		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head;
			}

			n = n.next;
		}

		return head;
	}

	public Node getNode(Node n, int d) {
		Node head = n;
		while (head != null) {
			if (head.data == d) {
				return head;
			}
			head = head.next;
		}
		return null;
	}

	public void print(Node n) {
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
}
