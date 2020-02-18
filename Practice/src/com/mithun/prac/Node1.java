package com.mithun.prac;

import java.util.*;

class Node1 {
    Node1 left, right;
    int data;

    Node1(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution1 {

    static void levelOrder(Node1 root) {
        //Write your code here
        Queue<Node1> node1Queue = new LinkedList<>();
        if(root != null) {
            node1Queue.add(root);
        }
        while (!node1Queue.isEmpty()) {
            Node1 tmp = node1Queue.poll();
            System.out.print(tmp.data + " ");
            if (tmp.left != null)
                node1Queue.add(tmp.left);
            if (tmp.right != null)
                node1Queue.add(tmp.right);
        }
    }

    public static Node1 insert(Node1 root, int data) {
        if (root == null) {
            return new Node1(data);
        } else {
            Node1 cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node1 root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        levelOrder(root);
    }
}