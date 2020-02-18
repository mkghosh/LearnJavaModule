package com.mithun.prac;

import java.io.*;
import java.nio.file.NotDirectoryException;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }

}

class Solution {

    public static Node removeDuplicates(Node head) {
        //Write your code here
        Set<Integer> dataSet = new HashSet<>();
        if (head != null) {
            dataSet.add(head.data);
            Node node = head;
            while (node.next != null) {
                int setSize = dataSet.size();
                dataSet.add(node.next.data);
                Node tmp = node.next;
                if(setSize == dataSet.size()) {
                    if(tmp.next != null) {
                        node.next = tmp.next;
                        node = tmp.next;
                    } else {
                        node.next = null;
                    }
                } else {
                    node = tmp;
                }
            }
        }
        return head;
    }

    public static Node insert(Node head, int data) {
        Node p = new Node(data);
        if (head == null)
            head = p;
        else if (head.next == null)
            head.next = p;
        else {
            Node start = head;
            while (start.next != null)
                start = start.next;
            start.next = p;

        }
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int T = sc.nextInt();
        while (T-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        head = removeDuplicates(head);
        display(head);

    }
}