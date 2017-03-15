package com.chapter3;

/*
 *  实现一个 MyQueue 类，该类用两个栈来实现一个队列
 */

import java.util.ArrayList;

public class TaskThree {
	Stack one = new Stack();
	Stack two = new Stack();

	public void enqueue(int data) {
		one.push(data);
	}

	public int dequeue() {
		if (two.isEmpty()) {
			poll();
		}
		return two.pop().data;
	}

	public void poll() {
		while (!one.isEmpty()) {
			two.push(one.pop().data);
		}
	}

	public static void main(String[] args) {
		TaskThree queue = new TaskThree();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}
