package main;

import java.util.Random;

// generates random numbers for distances and other shits
public class Distance {
    public int distanceGenerator(){
        Random rand = new Random();
        int randomNumber = rand.nextInt(100 - 10 + 1) + 10;
        return randomNumber;
    }

    public int location(){
        Random rand = new Random();
        int location = rand.nextInt(7)+1;
        return location; 
    }

    public int damage(){
        Random rand = new Random();
        int damage = rand.nextInt(5)+1;
        return damage;
    }
}

