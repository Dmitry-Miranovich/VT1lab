package firstPart;

import interfaces.TaskMethods;

import java.util.Scanner;
import static java.lang.Math.*;
public class ForthTask implements TaskMethods {
    private int[] mas;
    @Override
    public void doTask() {
        findSimpleNumbers();
    }
    private void generateMas(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int N = in.nextInt();
        mas = new int[N];
        System.out.println("Массив: ");
        for(int i = 0;i<N;i++){
            int randNumber = (int)(random()+30);
            mas[i] = randNumber;
            System.out.print(mas[i]+ " ");
        }
    }
    private void findSimpleNumbers(){
        generateMas();
        //Малый тест Ферма на простоту
        System.out.println("Список простых чисел: \n");
        for (int numb : mas) {
            if (!fermaTest(numb)) {
                System.out.print(numb + " ");
            }
        }
    }
    private int quickPow(int x, int pow, int key) {
        int temp = 1;
        do {
            if (pow % 2 == 0) {
                x %= key;
                x = (x * x) % key;
                pow /= 2;
            } else {
                pow--;
                temp = (temp * x) % key;
            }
        } while (pow != 1);
        return (temp * x) % key;
    }
    private boolean fermaTest(int numb){
        for(int i = 1; i<numb-1; i++){
            if(quickPow(i, numb-1, numb)!=1){
                return false;
            }
        }
        return true;
    }
}
