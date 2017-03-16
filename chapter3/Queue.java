package com.chapter3;

public class Queue<E> {

	private Node<E> head = null;
	private Node<E> tail = null;

	private class Node<E> {
		E item;
		Node<E> next = null;

		public Node(E item) {
			this.item = item;
		}
	}

	public void enqueue(E item) {
		Node<E> node = new Node<E>(item);

		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
		}
	}

	public E dequeue() throws Exception {
		if (head == null) {
			throw new Exception("Trying to dequeue an empty queue!");
		} else {
			Node<E> temp = head;
			head = head.next;

			if (temp == tail) {
				tail = null;
			}

			return temp.item;
		}
	}

	public static void main(String[] args) {

		Queue<String> queue = new Queue<String>();
		
		queue.enqueue("Hello World");
		queue.enqueue("Hello Java");
		
		try {
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
