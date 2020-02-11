package com.mithun.lnkd.lst;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.prepend(1);
        list.prepend(2);
        list.prepend(3);
        list.prepend(4);
        list.append(7);
        list.append(8);
        list.append(9);
        System.out.println(list);
        list.removeLast();
        System.out.println(list.toString());
    }
}
