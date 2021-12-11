package com.company;

import firstPart.*;
import interfaces.TaskMethods;
import secondPart.*;
import secondPart.bookTasks.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<TaskMethods> tasks = new ArrayList<>();
        tasks.add(new FirstTask());
        tasks.add(new SecondTask());
        tasks.add(new ThirdTask());
        tasks.add(new ForthTask());
        tasks.add(new FirstTask());
        tasks.add(new SixthTask());
        tasks.add(new SeventhTask());
        tasks.add(new EighthTask());
        tasks.add(new Book());
        Scanner in = new Scanner(System.in);
        try{
            System.out.println("Введите номер задания(0-9)");
            int task = in.nextInt();
            if(task < tasks.size() && task>=0){
                tasks.get(task).doTask();
            }else{
                throw new Exception("Введено неправильный номер задания");
            }
        }catch (Exception ex){
            System.out.println("Введено неправильное значение");
        }
    }
}
