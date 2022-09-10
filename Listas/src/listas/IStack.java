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
public interface IStack<E> {

    public boolean empty();

    public E peek();

    public E pop();

    public E push(E item);

    public int search(E o);

}
