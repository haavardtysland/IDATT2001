package Oblig1;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Deck {
    private final char[] suits = {'S','H','D','C'};
    private ArrayList<Card> cards;


    public Deck() {
        this.cards = new ArrayList();

         for (int suit = 0; suit <= 3; suit++ ) {
             for (int face = 1; face <=13 ; face++) {
                cards.add(new Card(suits[suit], face));
            }
        }
    }

    public ArrayList<Card> assign(int n){
        ArrayList<Card> randomCards = new ArrayList();
        // lager grenser
        int max = 51;
        int min = 0;
        int range = max - min + 1;

        // genererer tall fra 1 til 10 n ganger
         for (int i = 0; i < n; i++) {
            int rand = (int) (Math.random() * range) + min;
                randomCards.add(cards.get(rand));
                cards.remove(cards.get(rand));
                range--;
            }
        return randomCards;
    }

    public void alleTing(ArrayList<Card> randomCards){

        //c skriver ut alle spar kort
        randomCards.stream().filter(p -> p.getSuit() =='S').forEach(s -> System.out.println(s));

        //d samler alle hjertekort
        System.out.println(randomCards.stream().filter(p -> p.getSuit() == 'H').collect(Collectors.toList()));

        //e liste med kortenes farge
        ArrayList<String> colors = ((ArrayList<String>) randomCards.stream().map(p -> {if(p.getSuit() == 'C' || p.getSuit() == 'S') return "Black"; else return "Red";}).collect(Collectors.toList()));
        System.out.println(colors);

        //h sjekker om det er flush
        boolean isFlush = (randomCards.stream().filter(p -> p.getSuit() == 'C').count() > 4) || (randomCards.stream().filter(p -> p.getSuit() == 'S').count() > 4) || (randomCards.stream().filter(p -> p.getSuit() == 'H').count() > 4) || (randomCards.stream().filter(p -> p.getSuit() == 'D').count() > 4);
        System.out.println(isFlush);

        //f sum av kortenes face verdi
        int sumCards = randomCards.stream().map(Card::getFace).reduce((a,b) -> a+b).get();
        System.out.println(sumCards);

        //g sjekker om det er en spar dronning i kortene
        System.out.println(randomCards.stream().anyMatch(p -> p.getFace() == 12 && p.getSuit() == 'S'));

    }


    public String toString() {
        String utskrift = "";
        for (int i = 0; i < this.cards.size(); i++) {
            utskrift += this.cards.get(i) + "\n";
        }
        return utskrift;
    }


}
