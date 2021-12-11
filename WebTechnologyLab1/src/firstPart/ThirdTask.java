package firstPart;
import interfaces.TaskMethods;

import static java.lang.Math.*;
import java.lang.System;
import java.util.Scanner;

public class ThirdTask implements TaskMethods {

    public void doTask() {
        Scanner in = new Scanner(System.in);
        System.out.println("Задайте границы и шаг");
        double a,b,h,res;
        try{
            System.out.println("a: ");
            a = in.nextInt();
            System.out.println("b: ");
            b = in.nextInt();
            System.out.println("h: ");
            h = in.nextInt();
            if(a>b)
                System.out.println("Граница [a;b] недопустима");
            else if((a<0 && b<0) || h<0){
                System.out.println("Недопустимые значения");
            }
            else{
                System.out.println("Результаты");
                while(a<=b){
                    res = tan(a);
                    System.out.printf("%d : %f", (int)a, res);
                    a+=h;
                }
            }
        }catch (Exception ex){
           System.out.println("Вызвана ошибка: "+ ex.getMessage());
        }
    }
}
