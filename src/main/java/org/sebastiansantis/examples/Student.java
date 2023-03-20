package org.sebastiansantis.examples;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor@Data
public class Student {

    private Integer studentID;
    private String name;
    private String lastName;
    private List<Double> notes;

    public static Student from(Integer studentID,String name,String lastName,List<Double> notes) {
        return new Student(studentID,name,lastName,notes);
    }

}
