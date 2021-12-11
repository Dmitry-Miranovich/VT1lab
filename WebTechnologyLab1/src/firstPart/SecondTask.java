package firstPart;

import interfaces.TaskMethods;

import java.util.Scanner;

public class SecondTask implements TaskMethods {

    @Override
    public void doTask() {
        Scanner in = new Scanner(System.in);
        try{
            int x = in.nextInt();
            int y = in.nextInt();
            System.out.println(checkPoint(x,y));
        }catch (Exception ex){
            System.out.println("Ошибка: "+ ex.getMessage());
        }

    }
    private boolean checkPoint(int x, int y){
        if(x>=-6 && x<=6){
            if(x>=-4 && x<=4){
                return y >= -3 && y <= 5;
            }else{
                return y >= -3;
            }
        }return false;
    }
}
