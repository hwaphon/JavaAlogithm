package com.chapter3;

/*
 *  描述如何用一个数组来实现三个栈.
 *  
 *  算法思想：固定分割法，比如指定一个数组为 300 大小，那么 [0,99]，[100,199],[200, 299] 分别存放三个栈的数据，
 *  在插入的时候根据传入参数进行操作即可。
 */

public class TaskOne {

	private int size = 100;
	private int[] buffer = new int[size * 3];
	private int[] stackPointer = { -1, -1, -1 };

	public void push(int stackNumber, int data) throws Exception {

		if (stackPointer[stackNumber] + 1 >= size) {
			throw new Exception("The stack is full!");
		}

		stackPointer[stackNumber] += 1;
		buffer[getTopOfStack(stackNumber)] = data;
	}

	public int pop(int stackNumber) throws Exception {
		if (stackPointer[stackNumber] == -1) {
			throw new Exception("Trying to pop an empty stack");
		}

		int index = getTopOfStack(stackNumber);
		int temp = buffer[index];
		stackPointer[stackNumber] -= 1;
		return temp;
	}

	public int peek(int stackNumber) {
		int index = getTopOfStack(stackNumber);
		return buffer[index];
	}

	public boolean isEmpty(int stackNumber) {
		return stackPointer[stackNumber] == -1;
	}

	public int size(int stackNumber) {
		return stackPointer[stackNumber] == -1 ? 0 : stackPointer[stackNumber] + 1;
	}

	public int getTopOfStack(int stackNumber) {
		return size * stackNumber + stackPointer[stackNumber];
	}

	public static void main(String[] args) {
		TaskOne stack = new TaskOne();

		try {
			stack.push(0, 1);
			stack.push(0, 2);
			stack.push(0, 3);
			
			stack.push(1, 10);
			stack.push(2, 100);

			System.out.println(stack.pop(1));
			System.out.println(stack.pop(2));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
