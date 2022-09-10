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
public class CircularDoublyLinkedList<T extends Integer> implements Ilist<T> {

    DoubleNode<T> head;

    public CircularDoublyLinkedList() {
        head = null;
    }

    @Override
    public void add(T d) {
        DoubleNode<T> newNode = new DoubleNode<>(d);
        if (isEmpty()) {
            head = newNode;
            newNode.setNextNode(newNode);
            newNode.setPreviousNode(newNode);
        } else {
            newNode.setPreviousNode(head.getPreviousNode());
            newNode.setNextNode(head);
            head.setPreviousNode(newNode);
            head = newNode;
            head.getPreviousNode().setNextNode(head);

        }
    }

    @Override
    public void addLast(T d) {
        DoubleNode<T> newNode = new DoubleNode<>(d);
        if (isEmpty()) {
            head = newNode;
            newNode.setNextNode(newNode);
            newNode.setPreviousNode(newNode);
        } else {
            newNode.setPreviousNode(head.getPreviousNode());
            newNode.setNextNode(head);
            head.getPreviousNode().setNextNode(newNode);
            head.setPreviousNode(newNode);
            //head=newNode;
            //¿Se puede refactorizar?

        }
    }

    @Override
    public void addOrdered(T d) {
        DoubleNode<T> newNode = new DoubleNode<>(d);
        if (isEmpty() || d.compareTo(head.getData()) == -1) {
            add(d);
            return;
        }
        if (isEmpty() || d.compareTo(head.getData()) == 1) {
            addLast(d);
            return;
        }
        DoubleNode<T> current = head.getNextNode();

        while (current.getData().compareTo(d) == -1) {
            current = current.getNextNode();
        }
        newNode = new DoubleNode<>(d,current.getPreviousNode(),current);
        current.getPreviousNode().setNextNode(newNode);
        current.setPreviousNode(newNode);

    }

    @Override
    public void delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("No existen datos por borrar...");
        } else if (head == head.getPreviousNode()) {
            head = null;
        } else {
            head.getNextNode().setPreviousNode(head.getPreviousNode());
            head.getPreviousNode().setNextNode(head.getNextNode());
            head = head.getNextNode();
        }
    }

    @Override
    public void deleteLast() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String showData() {
        String data = "";
        DoubleNode<T> current = this.head;
        do {
            data = data + current.getData() + " ";
            current = current.getNextNode();
        } while (current != head);
        return data;
    }

}
