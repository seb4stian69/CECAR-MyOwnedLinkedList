package org.sebastiansantis.views;

import org.sebastiansantis.examples.Student;
import org.sebastiansantis.linkedlist.MyLinkedList;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MenuStudentView{

    public MenuStudentView(){/*Utility Class*/}

    public static Integer showMenu(){

        var option = JOptionPane.showInputDialog(null,
                "+--------------- | Menu | ---------------+" +
                "\n1- Añadir"+
                "\n2- Eliminar"+
                "\n3- Listar" +
                "\n4- Promedio" +
                "\n0- Salir" +
                "\n"
        );

        return Integer.parseInt(option);

    }

    public void addMenu(MyLinkedList<Student> list){

        var id = JOptionPane.showInputDialog(null,"Identificador");
        var name = JOptionPane.showInputDialog(null,"Primer nombre");
        var lastname = JOptionPane.showInputDialog(null,"Primer apellido");

        List<Double> notes = new ArrayList<>();

        Integer option=1;
        Integer itr=1;

        do{

            String opt = JOptionPane.showInputDialog(null,
                    "+--------------- | Menu | ---------------+" +
                            "\n1- Añadir nota"+
                            "\n0- Salir"+
                            "\n"
            );

            option = Integer.parseInt(opt);

            if(option==1){
                notes.add(
                    Double.parseDouble(
                        JOptionPane.showInputDialog(null,"Ingresar la nota " + itr)
                    )
                );
            }

            itr+=1;

        }while(option==1);

        var addStudent = Student.from(Integer.parseInt(id),name,lastname,notes);

        list.addToStart(addStudent);

    }

    public void deleteMenu(MyLinkedList<Student> list){

        var option = JOptionPane.showInputDialog(null,"Eliminar");




    }

    public void listMenu(MyLinkedList<Student> list){
        JOptionPane.showMessageDialog(null,"Listar");
    }

    public void notesAvgMenu(MyLinkedList<Student> list){
        JOptionPane.showMessageDialog(null,"Promedio");
    }

}
