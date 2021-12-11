package secondPart;
import java.util.LinkedList;
import Enums.Color;

public class Basket {
    private LinkedList<Ball> basket;

    public void setBasket(LinkedList<Ball> basket) {
        this.basket = basket;
    }

    public void addBall(Ball ball){
        basket.add(ball);
    }

    public void removeBall(int index){
        basket.remove(index);
    }

    public int size(){
        return basket.size();
    }

    public int basketWeight(){
        int basketWeight = 0;
        for(Ball b : basket){
            basketWeight+=b.getWeight();
        }
        return basketWeight;
    }
    public int ballCount(Color color){
        int counter = 0;
        for(Ball ball:basket){
            if(color.equals(ball.getColor())){
                counter++;
            }
        }
        return counter;
    }
}
