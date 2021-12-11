package firstPart;

import interfaces.TaskMethods;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.random;

public class EighthTask implements TaskMethods {
    private int N;
    private ArrayList<Integer> mas1;
    private int[] mas2;
    @Override
    public void doTask() {
        generateN();
        generateMas(mas1);
        shellSort(mas1);
        generateMas(mas2);
        shellSort(mas2);
        insertSequence();
    }
    private void generateMas(int[] mas){
        System.out.println("\nМассив: ");
        for(int i = 0;i<N;i++){
            int randNumber = (int)(random()*30);
            mas[i] = randNumber;
            System.out.print(mas[i]+ " ");
        }
    }
    private void generateMas(ArrayList<Integer> mas){
        System.out.println("\nМассив: ");
        for(int i = 0;i<N;i++){
            int randNumber = (int)(random()*30);
            mas.add(randNumber);
            System.out.print(mas.get(i)+ " ");
        }
    }
    private void generateN(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива");
        N = in.nextInt();
        mas1 = new ArrayList<>();
        mas2 = new int[N];
    }
    private void shellSort(int[] mas){
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
    private void shellSort(ArrayList<Integer> mas){
        for(int i = 0; i<mas.size()-1; i++){
            int temp = mas.get(i);
            if(mas.get(i) > mas.get(i+1)){
                mas.set(i, mas.get(i+1));
                mas.set(i+1, temp);
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
    private void insertSequence(){
        for(int i = 0; i<mas2.length; i++){
            for(int j = 0; j<mas1.size(); j++){
                if(mas2[i]<=mas1.get(j)){
                    mas1.add(j,mas2[i]);
                    break;
                }
            }
        }
        System.out.println("\nИтоговая последовательность:\n");
        for(int elem: mas1){
            System.out.print(elem+ " ");
        }
    }
}
