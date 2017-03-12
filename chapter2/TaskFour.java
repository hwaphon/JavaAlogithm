package com.chapter2;

/*
 * 编写代码。以给定值 x 为基准将链表分割成两部分，所有小于 x 的借点排在大于等于 x 的节点之前。
 * 
 * 解题思想： 由于给定的条件是链表，链表的移动和删除开销是很小的，所以我们只需要在定义两个链表，将原链表中的值与 x 进行对比，小于 x
 * 的放在前一个列表中，大于等于 x 的放在后一个列表中，在程序中定义了四个变量，分别是 beforeStart, beforeEnd, afterStart, afterEnd
 * ,其中 beforeStart, afterStart 主要用于鉴别，方便使用。分割完之后，需要将两个链表整合后在返回，注意整合的时候需要判断前一个链表
 * 是否为空！
 */
public class TaskFour {
	public static void main(String[] args) {

		Node baseNode = new Node(1);

		for (int i = 16; i >= 2; i--) {
			baseNode.append(i);
		}

		baseNode.print(baseNode);
		System.out.println();

		baseNode = partition(baseNode, 10);
		baseNode.print(baseNode);

	}

	public static Node partition(Node base, int x) {
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;

		while (base != null) {
			Node temp = base.next;
			base.next = null;

			if (base.data < x) {
				if (beforeStart == null) {
					beforeStart = base;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = base;
					beforeEnd = beforeEnd.next;
				}
			} else {
				if (afterStart == null) {
					afterStart = base;
					afterEnd = afterStart;
				} else {
					afterEnd.next = base;
					afterEnd = afterEnd.next;
				}
			}

			base = temp;
		}

		if (beforeStart == null) {
			return afterEnd;
		}

		beforeEnd.next = afterStart;

		return beforeStart;
	}

}
