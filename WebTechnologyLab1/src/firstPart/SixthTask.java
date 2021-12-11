package firstPart;

import interfaces.TaskMethods;

import java.util.Scanner;

public class SixthTask implements TaskMethods {
    @Override
    public void doTask() {
        int n = generateN();
        int[] mas = generateMassive(n);
        int[][] matrix = new int[n][n];
        for(int i = 0; i<n; i++){
            matrix[i] = mas.clone();
            shift(mas);
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    private int[] generateMassive(int n){
        int[] mas = null;
        try{
            mas = new int[n];
            for(int i = 0; i<n; i++){
                mas[i] = (int)((Math.random()*20)+1);
            }
        }catch (Exception ex){
            System.out.println("Ошибка: "+ ex.getMessage());
        }
        return mas;
    }
    private int generateN(){
        Scanner in = new Scanner(System.in);
        int n = 0;
        try{
            n = in.nextInt();
        }catch (Exception ex){
            System.out.println("Ошибка: "+ ex.getMessage());
        }
        return n;
    }
    private void shift(int[] mas){
        int temp = mas[0];
        for(int i = 0; i<mas.length-1; i++){
            mas[i] = mas[i+1];
            mas[i+1] = temp;
        }
    }
}
