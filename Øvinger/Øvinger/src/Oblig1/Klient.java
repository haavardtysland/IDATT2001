package Oblig1;

import java.util.ArrayList;

public class Klient {

    public static void main(String[] args) {
        Deck blue = new Deck();
        //System.out.println(blue);
        ArrayList<Card> cards = blue.assign(10);
        System.out.println(cards);
        blue.alleTing(cards);

    }

}
