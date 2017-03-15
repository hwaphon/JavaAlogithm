package com.chapter3;

import java.lang.Thread.State;

/*
 *  请设计一个栈，除 pop 和 push 方法，还支持 min 方法，可返回栈元素中的最小值，push，pop和 min 三个
 *  方法的时间复杂度必须为 O(1)
 *  
 *  算法思想：为了将插入和弹出的时间复杂度控制在 O(1)，采用前插法处理元素，为了将 min() 时间复杂度复杂度控制在 O(1)，
 *  定义一个保存 min 值的栈，每次插入元素时进行如下操作： 如果要插入元素的值小于栈顶元素，那么将这个元素入栈。 到最后这个保存
 *  min 值的栈实际上保存的是在每个时刻栈中的最小元素。
 */

public class TaskTwo {

	private Stack mins = new Stack();

	Node top;

	private class Node {
		int data;
		Node next = null;

		public Node(int data) {
			this.data = data;
		}
	}

	public void push(int data) {
		Node node = new Node(data);
		if (top == null) {
			top = node;
			mins.push(data);
		} else {
			node.next = top;
			top = node;

			if (min(data)) {
				mins.push(data);
			}
		}
	}

	private boolean min(int data) {
		return data < mins.peek();
	}

	public int pop() throws Exception {
		if (top == null) {
			throw new Exception("Trying to pop an empty stack!");
		}

		int value = top.data;
		top = top.next;
		if (value == mins.peek()) {
			mins.pop();
		}

		return value;
	}

	public int min() {
		return mins.peek();
	}

	public static void main(String[] args) {
		TaskTwo stack = new TaskTwo();
		stack.push(10);
		stack.push(5);
		stack.push(11);
		stack.push(1);
		
		System.out.println(stack.min());
		try {
			stack.pop();
			System.out.println(stack.min());
			
			stack.pop();
			System.out.println(stack.min());
			
			stack.pop();
			System.out.println(stack.min());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
