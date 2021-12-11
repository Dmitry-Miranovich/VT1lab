package firstPart;

import interfaces.TaskMethods;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.random;

public class SeventhTask implements TaskMethods {
    private int[] mas;
    @Override
    public void doTask() {
        generateMas();
        shellSort();
    }
    private void generateMas(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int N = in.nextInt();
        mas = new int[N];
        System.out.println("Массив: ");
        for(int i = 0;i<N;i++){
            int randNumber = (int)(random()*30);
            mas[i] = randNumber;
            System.out.print(mas[i]+ " ");
        }
    }
    private void shellSort(){
        for(int i = 0; i<mas.length-1; i++){
            int temp = mas[i];
            if(mas[i] > mas[i+1]){
                mas[i] = mas[i+1];
                mas[i+1] = temp;
                if(i != 0){
                    i-=2;
                }else{
                    i--;
                }
            }
        }
        System.out.println("\nОтсортированный массив: ");
        for(int elem:mas){
            System.out.print(elem +" ");
        }
    }
}
