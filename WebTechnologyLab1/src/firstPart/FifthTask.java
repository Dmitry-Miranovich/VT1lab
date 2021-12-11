package firstPart;

import interfaces.TaskMethods;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.random;

/*
    Последовательность нужных операций
    1) Выбираем элемент из массива - $curr
    2) Ищем следующий минимальный элемент после $curr - $min
        2.1) Минимальный полученный элемент должен быть наиближайшим к $curr
    3) Добавляем два элемента в подпоследовательность
    4) Повторяем пункты 2, 3
    5) Итерационно повторяем пункты 1-4 до конца массива
    6) Выбираем наибольшее последовательность
 */
public class FifthTask implements TaskMethods {
    private int[] primaryMas;
    private final ArrayList<ArrayList<Integer>> sequences = new ArrayList<>();
    private final ArrayList<Integer> tempMas = new ArrayList<>();
    private int counter = 0;
    @Override
    public void doTask() {
        generateMas();
        sample();
        int iter = 0;
        int temp = sum(sequences.get(0));
        for(int i = 0; i<sequences.size(); i++){
            int secondTemp = sum(sequences.get(i));
            if(temp < secondTemp){
                iter = i;
                temp = secondTemp;
            }
        }
        System.out.println("\nМаксимальная подпоследовательность возрастающий чисел: \n" +
                ToString(sequences.get(iter)));
    }
    private void sample(){
        for(int i = 0; i< primaryMas.length; i++){
            int temp = primaryMas[i];
            tempMas.add(temp);
            sample2(temp, i);
            tempMas.clear();
        }
    }
    private void sample2(int temp, int pos) {
        for (int i = pos + 1; i < primaryMas.length; i++) {
            if (temp <= primaryMas[i]) {
                tempMas.add(primaryMas[i]);
                counter++;
                sample2(primaryMas[i], i);
            }
        }
        ArrayList<Integer> mas = new ArrayList<>(tempMas);
        sequences.add(mas);
        while(counter!=0){
            tempMas.remove(tempMas.size()-1);
            counter--;
        }
        counter = 0;
    }
    private int sum(ArrayList<Integer> mas){
        int res = 0;
        for(Integer in : mas){
            res+=in;
        }
        return res;
    }
    private String ToString(ArrayList<Integer> mas){
        String res = "";
        for(Integer in : mas){
            res = res.concat(in + " ");
        }
        return res;
    }
    private void generateMas(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int N = in.nextInt();
        primaryMas = new int[N];
        System.out.println("Массив: ");
        for(int i = 0;i<N;i++){
            int randNumber = (int)(random()*50);
            primaryMas[i] = randNumber;
            System.out.print(primaryMas[i]+ " ");
        }
    }
}
