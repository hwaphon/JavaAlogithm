package com.chapter2;

/*
 *  实现一个算法，删除单向链表中间的某个节点，假定你只能访问该节点
 *  示例： 输入单向链表 a->b->c->d->e 中的节点 c，不返回任何数据，但是链表变成 a->b->d->e
 */

public class TaskThree {
	public static void main(String[] args) {
		Node node = new Node(1);
		node.append(2);
		node.append(3);
		node.append(4);
		node.append(5);

		node.print(node);
		System.out.println();
		Node n;
		if ((n = node.getNode(node, 3)) != null) {
			deleteNode(n);
		}

		node.print(node);
	}

	public static void deleteNode(Node c) {
		
		Node temp = c.next;
		c.next = temp.next;
		c.data = temp.data;
		return;
	}
}
