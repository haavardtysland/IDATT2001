package Oblig3;

import java.util.Arrays;
import java.util.Comparator;

public class TribuneKlient {
    public static void main(String[] args) {
        Stand t1 = new Stand("Storsalen", 300, 150, 295);
        Stand t2 = new Stand("Stavern festivalen", 15000, 2000, 13500);
        Sit t3 = new Sit("Viking stadion", 80, 300, 10 );
        VIP t4 = new VIP("VIP" , 60, 1000, 10);

        Tribune[] tribune = new Tribune[4];
        tribune[0] = t1;
        tribune[1] = t2;
        tribune[2] = t3;
        tribune[3] = t4;

        String[] names = new String[]{"håvard", "jens", "per", "ole"};


       /* for(int i = 0; i < tribune.length; i++) {
            System.out.println("Tribune:");
            System.out.println(tribune[i]);
            System.out.println("Bilett(er):");
            System.out.println(Arrays.toString(tribune[i].buyTicket(8)));
        } */

       /*for(int i = 0; i < tribune.length; i++) {
           System.out.println("Tribune:");
           System.out.println(tribune[i]);
           System.out.println("Bilett(er):");
           System.out.println(Arrays.toString(tribune[i].buyTicket(names)));
        }

        for(int i = 0; i < tribune.length; i++) {
            System.out.println("Tribune:");
            System.out.println(tribune[i]);
            System.out.println("Bilett(er):");
            System.out.println(Arrays.toString(tribune[i].buyTicket(names)));
        }*/




        //System.out.println(t3.findNumberOfSoldTickets());
        //System.out.println(t3.findIncome());

        System.out.println("Før sortering:");
        for(int i = 0; i < tribune.length; i++) {
            System.out.println(tribune[i]);
        }

        Arrays.sort(tribune, new SortByIncome());

        System.out.println("Etter sortering: \r\n");
        for(int i = 0; i < tribune.length; i++) {
            System.out.println(tribune[i]);
        }
    }
}

class SortByIncome implements Comparator<Tribune> {
    public int compare(Tribune a, Tribune b) {
        return b.findIncome() - a.findIncome();
    }
}