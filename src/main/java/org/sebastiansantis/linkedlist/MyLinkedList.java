package org.sebastiansantis.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sebastiansantis.node.MyNode;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Consumer;

@NoArgsConstructor@AllArgsConstructor@Data
public class MyLinkedList<E> {

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

            MyNode<E> current = this.head;

            while (current.getNext() != null) {current = current.getNext();}
            current.setNext(newNode);

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

        MyNode<E> current = this.head;

        while (!Objects.equals(current.getNext(), null) && !Objects.equals(current.getNext().getCode(), hash)) {
            current = current.getNext();
        }

        if (!Objects.equals(current.getNext(), null)) {
            current.setNext(current.getNext().getNext());
            this.size-=1;
        }

    }

    public MyNode<E> getLastNode(){

        MyNode<E> current = this.head;

        while(current != null){

            if(current.getNext() == null){
                break;
            }else{
                current = current.getNext();
            }

        }

        return current;

    }

    public void resetLinkedList(){
        assert this.head != null;
        this.head = null;
    }

    /* | ---------------------------------- +  Transversal  + ---------------------------------- | */

    public void forEach(Consumer<? super E> action) {

        MyNode<E> current = this.head;

        while (current != null) {
            action.accept(current.getItem());
            current = current.getNext();
        }

    }

    public E get(String hash) {

        MyNode<E> current = this.head;

        while(current != null){

            if(Objects.equals(current.getCode(), hash)){
                break;
            }else{
                current = current.getNext();
            }

        }

        assert current != null;
        return current.getItem();

    }

    public int size() {
        return this.size;
    }

    /* | ---------------------------------- +  UtilMethods  + ---------------------------------- | */

    private Boolean validateNotNullableHead(){return this.head != null;}
    private Boolean isEqualsHash(String firstHash, String secondHash){return firstHash.equals(secondHash);}


}
