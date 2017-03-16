package com.chapter3;

/*
 *	编写程序，按升序对栈进行排序（即最大元素位于栈顶）。最多只能使用额外的栈存放临时数据，
 *  但不得将元素复制在别的数据结构中（如数组）。该栈支持如下操作：push.pop.peek.isEmpty 
 *  
 *  解题思想： 我们将两个栈分为有序栈和无序栈，也就是说有序栈中的数都是按照升序排列的，这样的话当我们插入一个新的元素时，可分为
 *  三种情况：一，插入的元素是有序栈中的第一个元素，这时候直接将元素插入。二，插入的元素大于有序栈栈顶的元素，这时候也是直接将元素
 *  插入。三，插入的元素小于有序栈栈顶的元素，这个时候我们依次将有序栈中的元素弹出到无序栈中，直到有序栈的栈顶元素小于插入元素，将元素
 *  插入后，再依次将无序栈中的元素弹出到有序栈中即可。
 */

public class TaskFour {

	private Stack sortedStack = new Stack();
	private Stack shuffleStack = new Stack();

	public void push(int data) {
		if (isEmpty()) {
			sortedStack.push(data);
		} else {
			if (data < peek()) {

				while (!isEmpty() && data < peek()) {
					shuffleStack.push(pop());
				}

				sortedStack.push(data);

				while (!shuffleStack.isEmpty()) {
					sortedStack.push(shuffleStack.pop().data);
				}
			} else {
				sortedStack.push(data);
			}
		}
	}

	public boolean isEmpty() {
		return sortedStack.isEmpty();
	}

	public int peek() {
		return sortedStack.peek();
	}

	public int pop() {
		return sortedStack.pop().data;
	}

	public static void main(String[] args) {
		TaskFour stack = new TaskFour();

		for (int i = 10; i >= 1; i--) {
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
