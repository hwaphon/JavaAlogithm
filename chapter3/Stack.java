package com.chapter3;

public class Stack {

	private Node top = null;

	class Node {
		int data;
		Node next = null;

		public Node(int data) {
			this.data = data;
		}
	}

	public void push(int d) {
		Node n = new Node(d);

		n.next = top;
		top = n;
	}

	public int peek() {
		return top.data;
	}

	public Node pop() {

		Node item = null;

		if (top != null) {
			item = top;
			top = top.next;
		}

		return item;
	}

	public Node delete(int d) {

		Node temp = null;

		if (top != null) {

			if (top.data == d) {
				top = top.next;
			} else {

				Node current = top;

				while (current.next != null) {
					if (current.next.data == d) {
						temp = current.next;
						current.next = current.next.next;
						break;
					}

					current = current.next;
				}
			}
		}

		return temp;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void print() {
		Node current = top;

		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

}
