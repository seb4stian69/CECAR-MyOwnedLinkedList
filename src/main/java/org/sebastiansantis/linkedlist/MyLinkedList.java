package org.sebastiansantis.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.sebastiansantis.node.MyNode;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Consumer;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor@AllArgsConstructor@Data
public class MyLinkedList<E> extends AbstractList<E> {

    /* | ---------------------------------- + Attributes + ---------------------------------- | */

    private MyNode<E> head;
    private Integer size = 0;
    private ArrayList<String> allHash = new ArrayList<>();


    /* | ---------------------------------- +  All Methods  + ---------------------------------- | */

    public void addToStart(E element) {

        MyNode<E> newNode = new MyNode<>(element);
        newNode.setNumberInList(size);
        allHash.add(0,newNode.getCode());

        newNode.setNext(head);
        this.head = newNode;

        this.size+=1;

    }

    public void addToEnd(E element) {

        MyNode<E> newNode = new MyNode<>(element);
        newNode.setNumberInList(size);
        allHash.add(newNode.getCode());

        if (this.head == null) {
            this.head = newNode;
        } else {
            MyNode<E> aux = this.head;
            while (aux.getNext() != null) {aux = aux.getNext();}
            aux.setNext(newNode);
        }

        this.size+=1;

    }

    public void deleteNode(String hash) {

        if (Boolean.FALSE.equals(validateNotNullableHead())) return;

        if (Boolean.TRUE.equals(isEqualsHash(this.head.getCode(), hash))) {
            this.head = this.head.getNext();
            this.size-=1;
            return;
        }

        MyNode<E> aux = this.head;

        while (!Objects.equals(aux.getNext(), null) && !Objects.equals(aux.getNext().getCode(), hash)) {
            aux = aux.getNext();
        }

        if (!Objects.equals(aux.getNext(), null)) {
            aux.setNext(aux.getNext().getNext());
            this.size-=1;
        }

    }

    /* | ---------------------------------- +  Transversal  + ---------------------------------- | */

    @Override
    public void forEach(Consumer<? super E> action) {

        MyNode<E> current = this.head;

        while (current != null) {
            System.out.println(current.getItem());
            current = current.getNext();
        }

        System.out.println("--------------------------------");

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    /* | ---------------------------------- +  UtilMethods  + ---------------------------------- | */

    private Boolean validateNotNullableHead(){return this.head != null;}
    private Boolean isEqualsHash(String firstHash, String secondHash){return firstHash.equals(secondHash);}


}
