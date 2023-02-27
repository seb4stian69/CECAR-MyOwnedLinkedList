package org.sebastiansantis;

import org.sebastiansantis.linkedlist.MyLinkedList;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOG = Logger.getLogger("Main.class");

    public static void main(String[] args){

        MyLinkedList<String> list = new MyLinkedList<>();

        list.addToStart("FirstElement");
        list.addToEnd("LastElement");
        list.addToStart("ZeroElement");

        list.forEach(LOG::info);

        list.getAllHash().forEach(System.out::println);
        System.out.println("--------------------------------");
        list.deleteNode(list.getAllHash().get(0));

        list.forEach(LOG::info);

    }

}