package com.mithun.lnkd.lst;

import java.util.function.Supplier;

public class LinkedList {
    private Node header;
    private Node lastNode;
    private int size = 0;
    private Supplier<Boolean> isEmpty = () -> size == 0;

    public LinkedList() {
        header = new Node(null);
        setLastNode(header);
    }

    public LinkedList(Node header, Node lastNode) {
        setHeader(header);
        setLastNode(lastNode);
    }

    public void prepend(int data) {
        Node node = new Node(data);
        if (isEmpty.get()) {
            header.setNext(node);
            setLastNode(node);
        } else {
            Node tmpNode = header.getNext();
            header.setNext(node);
            node.setNext(tmpNode);
        }
        size++;
    }

    public void append(int data) {
        Node node = new Node(data);
        if (isEmpty.get()) {
            header.setNext(node);
        } else {
            Node tmpNode = header.getNext();
            do {
                tmpNode = tmpNode.getNext();
            } while (tmpNode.hasNext());
            tmpNode.setNext(node);
        }
        setLastNode(node);
        size++;
    }

    public void insertAt(int pos, int data) {
        if((pos <= 0 || pos > size))
            return;
        else if(pos == 1)
            prepend(data);
        else if(pos == size)
            append(data);
        else {
            Node node = new Node(data);
            Node tmp = header.getNext();
            int count = 1;
            while (count != pos -1) {
                tmp = tmp.getNext();
                count++;
            }
            Node nextNode = tmp.getNext();
            tmp.setNext(node);
            node.setNext(nextNode);
            size++;
        }

    }

    public void removeFirst() {
        if(!isEmpty.get()) {
            header.setNext(header.getNext().getNext());
            size--;
        }
    }

    public void removeLast() {
        switch (getSize()) {
            case 0:
                break;
            case 1:
                header.setNext(null);
                size--;
                setLastNode(header);
                break;
            default:
                Node node = header.getNext();
                while (node.getNext().hasNext()) {
                    node = node.getNext();
                }
                setLastNode(node);
                lastNode.setNext(null);
                size--;
                break;
        }
    }

    public void removeAt(int pos) {
        if(pos > 0 && pos <= size) {
            if(pos == 1)
                removeFirst();
            else if(pos == size)
                removeLast();
            else {
                Node tmp = header.getNext();
                int counter = 1;
                while (counter < pos -1) {
                    tmp = tmp.getNext();
                    counter++;
                }
                tmp.setNext(tmp.getNext().getNext());
            }
        }
    }

    public Node getHeader() {
        return header;
    }

    public void setHeader(Node header) {
        this.header = header;
    }

    public Node getLastNode() {
        return lastNode;
    }

    public void setLastNode(Node lastNode) {
        this.lastNode = lastNode;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = header.getNext();
        while (node != null) {
            sb.append(node.getData());
            if (node.hasNext())
                sb.append(", ");
            node = node.getNext();
        }
        return sb.toString();
    }
}
