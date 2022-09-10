/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author s103e28
 */
public class DoublyLinkedList<T extends Number & Comparable> implements Ilist<T> {

    private DoubleNode<T> head;
    private DoubleNode<T> tail;

    public DoublyLinkedList() {
        head = tail = null;
    }

    //agregar datos al inicio
    @Override
    public void add(T d) {

        if (isEmpty()) {
            head = tail = new DoubleNode<>(d);
        } else {
            head = new DoubleNode<>(d, null, head);
            head.getNextNode().setPreviousNode(head);
        }

    }

    @Override
    public void addLast(T d) {
        if (isEmpty()) {
            head = tail = new DoubleNode<>(d);
        } else {
            tail = new DoubleNode<>(d, tail, null);
            tail.getPreviousNode().setNextNode(tail);
        }
    }

    @Override
    public void addOrdered(T d) {

        if (isEmpty() || d.compareTo(head.getData()) == -1) {
            add(d);
            return;
        }
        if (d.compareTo(tail.getData()) == 1) {
            addLast(d);
            return;
        }
        
        DoubleNode<T> current = head.getNextNode();
        DoubleNode<T> newNode;
        
        while (current.getData().compareTo(d)==-1) {            
            current=current.getNextNode();
        }
        
        newNode = new DoubleNode<>(d,current.getPreviousNode(),current);
        current.getPreviousNode().setNextNode(newNode);
        current.setPreviousNode(newNode);
        

    }

    @Override
    /**
     * Borrar el primer nodo
     */
    public void delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista ya esta vacía");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head.getNextNode().setPreviousNode(null);
            head = head.getNextNode();
        }
    }

    @Override
    public void deleteLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista ya esta vacía");
        } else if (head == tail) {
            head = tail = null;
        } else {
            tail.getPreviousNode().setNextNode(null);
            tail = tail.getPreviousNode();
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String showData() {
        String data = "";
        DoubleNode<T> current = this.head;
        while (current != null) {
            data = data + current.getData() + " ";
            current = current.getNextNode();
        }
        return data;
    }

    public String showDataReverse() {
        String data = "";
        DoubleNode<T> current = this.tail;
        while (current != null) {
            data += current.getData() + " ";
            current = current.getPreviousNode();
        }
        return data;
    }

    public boolean searchData(T d) {

        DoubleNode<T> current = this.head;

        while (current != null) {
            //if (current.getData()==d){}
            if (current.getData() == d) {
                //if (current.getData().compareTo(d) == 0) {
                return true;
            }
            current = current.getNextNode();
        }

        return false;

    }

}
