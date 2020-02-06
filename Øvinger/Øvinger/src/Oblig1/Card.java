package Oblig1;

public class Card {

    private final char suit;
    private final int face;

    // initialises with suit ('S'=spade, 'H'=heart, 'D'=diamonds, 'C'=clubs)
    // and face (1=ace, 2, ... 10, 11=knight, 12=queen and 13=king)
    public Card(char suit, int face) {
        this.suit = suit;
        this.face = face;
    }

    public boolean equals(Object o) {
        if (o  == null) return false;
        if (this == o) return true;
        else if (o instanceof Card){
            Card card = (Card) o;
            if(card.getSuit() == this.getSuit() && card.getFace() == this.getFace()) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s%s", suit, face);
    }

    public char getSuit() {
        return suit;
    }

    public int getFace() {

        return face;
    }
}
