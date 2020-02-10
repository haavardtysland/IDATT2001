package Oblig3;

public class TribuneKlient {
    public static void main(String[] args) {
        Stand t1 = new Stand("Storsalen", 300, 150, 295);
        Stand t2 = new Stand("Stavern festivalen", 15000, 2000, 13500);
        // Sit t3 = new Sit("Viking stadion", 45000, 300, );
        //VIP t4 = new VIP("VIP" , 150, 1000, );

        System.out.println(t1.toString());
    }
}
