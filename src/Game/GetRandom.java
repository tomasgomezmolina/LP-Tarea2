package Game;

import lp.motor.Application;
import lp.motor.Context;
import lp.motor.Element;
import lp.motor.MouseHandler;

import java.awt.*;
import java.util.Random;
import java.util.Vector;
import java.util.ArrayList;


public class GetRandom {
    String powerup1;
    String powerup2;

    public String randomValue() {

        ArrayList<String> randomList = new ArrayList<String>();
        randomList.add("uno");
        randomList.add("dos");
        randomList.add("tres");
        randomList.add("cuatro");
        randomList.add("cinco");

        Random random = new Random();

        return (randomList.get(random.nextInt(randomList.size())));
    }
}