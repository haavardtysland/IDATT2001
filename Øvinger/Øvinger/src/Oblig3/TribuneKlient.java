package Oblig3;

import java.util.Arrays;

public class TribuneKlient {
    public static void main(String[] args) {
        Stand t1 = new Stand("Storsalen", 300, 150, 295);
        Stand t2 = new Stand("Stavern festivalen", 15000, 2000, 13500);
        Sit t3 = new Sit("Viking stadion", 80, 300, 10 );
        VIP t4 = new VIP("VIP" , 150, 1000, 15);

        Tribune[] tribune = new Tribune[4];
        tribune[0] = t1;
        tribune[1] = t2;
        tribune[2] = t3;
        tribune[3] = t4;
        System.out.println(t3.findNumberOfSoldTickets());

        String[] names = new String[]{"håvard", "jens", "per", "ole"};


        for(int i = 0; i < tribune.length; i++) {
            System.out.println(Arrays.toString(tribune[i].buyTicket(8)));
            System.out.println(tribune[i]);
        }
        for(int i = 0; i < tribune.length; i++) {
            System.out.println(Arrays.toString(tribune[i].buyTicket(names)));
            System.out.println(tribune[i]);
        }
        System.out.println(t3.findNumberOfSoldTickets());
        System.out.println(t3.findIncome());
    }
}
