/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import adt.*;
import entity.Student;

/**
 *
 * @author Jack
 */
public class DisplayStudentList {

    public static void main(String[] args) {
        SortedListInterface<Student> sList = new SortedList<>();
        sList.add(new Student("Dong Wei Jie", 2309419, "dongwj-wm21@student.tarc.edu.my", "Full Time", "Male"));
        sList.add(new Student("Dong Jie Jie", 2302278, "dongjj-wm21@student.tarc.edu.my", "Full Time", "Male"));
        sList.add(new Student("Dong Wei Wei ", 2309420, "dongww-wm21@student.tarc.edu.my", "Part Time", "Female"));
        sList.add(new Student("Dong Kee Ming", 2309209, "dongkm-wm21@student.tarc.edu.my", "Part Time", "Male"));
        sList.add(new Student("Dong Jo Wyn", 2309789, "dongjw-wm21@student.tarc.edu.my", "Full Time", "Female"));
    }
}
