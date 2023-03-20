package org.sebastiansantis;

import org.sebastiansantis.examples.Student;
import org.sebastiansantis.linkedlist.MyLinkedList;
import org.sebastiansantis.views.MenuStudentView;

import java.util.Arrays;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOG = Logger.getLogger("Main.class");
    public static MyLinkedList<Student> studentsList = new MyLinkedList<>();
    private static final MenuStudentView menuView = new MenuStudentView();

    public static void main(String[] args) {

        var studentOne = Student.from(0, "Sebastian", "Santos", Arrays.asList(0d, 0d, 0d));
        var studentTwo = Student.from(1, "Juan", "Perez", Arrays.asList(1d, 1d, 1d));
        var studentThree = Student.from(2, "Ita-chi", "China", Arrays.asList(2d, 2d, 2d));

        studentsList.addToStart(studentOne);
        studentsList.addToEnd(studentTwo);
        studentsList.addToEnd(studentThree);

        Integer option;

        /*do {

            option = MenuStudentView.showMenu();

            switch (option) {
                case 1:
                    menuView.addMenu(studentsList);
                    break;
                case 2:
                    menuView.deleteMenu(studentsList);
                    break;
                case 3:
                    menuView.listMenu(studentsList);
                    break;
                case 4:
                    menuView.notesAvgMenu(studentsList);
                    break;
                case 0:
                    break;
                default:
                    LOG.info("Se salio del rango de respuestas");
            }

        } while (option <= 4 && option>0);*/

        studentsList.forEach(student-> System.out.println(student.getName()));

    }

}