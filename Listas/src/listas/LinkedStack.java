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
public class LinkedStack<E> implements IStack<E> {

    private Node<E> top;
    private int sizeStack;

    public LinkedStack() {
        top = null;
        sizeStack = 0;
    }

    @Override
    public boolean empty() {
        return top == null;
    }

    @Override
    public E peek() {

        return (empty())?null:top.getData();
        
//        if(empty()){
//            return null;
//        }else{
//            return top.getData();
//        }
            
        
    }

    @Override
    public E pop() {
        if (empty()) {
            return null;
        } else {
            E dataTemp = top.getData();
            top = (top.getNextNode() == null) ? null : top.getNextNode();
//            if (top.getNextNode()==null){
//                top=null;
//            }else{
//                top = top.getNextNode();
//            }

            sizeStack--;
            return dataTemp;
        }
    }

    @Override
    public E push(E item) {
        sizeStack++;
        top = new Node<E>(item, top);
        return item;
    }

    @Override
    public int search(E o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
