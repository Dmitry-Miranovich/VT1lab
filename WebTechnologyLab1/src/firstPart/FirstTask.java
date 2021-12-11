package firstPart;
import interfaces.TaskMethods;

import static java.lang.Math.*;
public class FirstTask implements TaskMethods {

    public void doTask(){
        //Значения переменных x,y будут изменяться от 0 до 10 каждая;
        int x, y;
        double result;
        for(int i = 0; i<10; i++){
            x=i;
            y=i;
            result = 1+pow(sin((x+y)),2)/(2+abs(x-((2*x)/(1+(x*x*y*y)))));
            System.out.println(result);
        }
    }

}
