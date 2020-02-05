package Oblig2;

import javax.swing.plaf.basic.BasicViewportUI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class MemberArchive {

    public static final int SILVER_LIMIT = 25000;
    public static final int GOLD_LIMIT = 75000;
    public static final Random RANDOM_NUMBER = new Random();

    ArrayList<BonusMember> list;

    public MemberArchive() {
        this.list = new ArrayList<>();
    }

    public int findPoints(int memberNo, String password) {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getMemberNo() == memberNo) {
                if (this.list.get(i).okPassword(password)) {
                    return this.list.get(i).getPoints();
                }
            }
        }
        return -1;
    }

    private BonusMember findMember(int memberNo) {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getMemberNo() == memberNo) {
                return this.list.get(i);
            }
        }
        return null;
    }

    public boolean registerPoints(int memberNo, int points) {
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).getMemberNo() == memberNo) {
                   list.get(i).registerPoints(points);
                    return true;
                }
            }
            return false;
    }

    private int findAvailableNo() {
        int memberNo = Math.abs(RANDOM_NUMBER.nextInt());
        for(int i = 0; i < list.size(); i++)  {
            if(list.get(i).getMemberNo() == memberNo) {
                i = 0;
                memberNo = RANDOM_NUMBER.nextInt();
            }
        }
        return memberNo;
    }

   public int newMember(Personals personals, LocalDate enrolledDate) {
        int memberNo = findAvailableNo();
        list.add(new BasicMember(memberNo , personals, enrolledDate));
        return memberNo;
   }

   public void newMemberWithNo(int memberNo, Personals personals, LocalDate enrolledDate) {
        list.add(new BasicMember(memberNo, personals, enrolledDate));
   }

   private BonusMember checkSilverLimit(int memberNo, LocalDate date) {
        BonusMember bonusMember = findMember(memberNo);
        if(bonusMember.findQualificationPoints(date) >= SILVER_LIMIT){
            return new SilverMember(bonusMember);
        }
        return bonusMember;
   }

   private BonusMember checkGoldLimit(int memberNo, LocalDate date) {
       BonusMember bonusMember = findMember(memberNo);
       if(bonusMember.findQualificationPoints(date) > GOLD_LIMIT){
           return new GoldMember(bonusMember);
       }
       return bonusMember;
   }

   public void checkMembers(LocalDate date) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) instanceof BasicMember) {
                list.set(i, checkSilverLimit(list.get(i).getMemberNo(), date));
                list.set(i, checkGoldLimit(list.get(i).getMemberNo(), date));
            }
            if(list.get(i) instanceof SilverMember) {
                list.set(i, checkGoldLimit(list.get(i).getMemberNo(), date));
            }
        }
   }

    @Override
    public String toString() {
        return "MemberArchive{" +
                "list=" + list +
                '}';
    }

    public static void main(String[] args) {
        MemberArchive list = new MemberArchive();
        Personals ole = new Personals("Ole", "Olsen", "ole.olsen@dot.com", "ole");
        Personals tove = new Personals("Tove", "Hansen", "tove.hansen@dot.com", "tove");
        Personals mathias = new Personals("Mathias", "Myrold", "mathias.er.kul@gmail.com", "jegerkul");


        list.newMemberWithNo(123, ole, LocalDate.of(20019, 11, 15));
        list.newMemberWithNo(233, tove, LocalDate.of(2019, 12, 5));
        System.out.println(list.newMember(mathias, LocalDate.of(2020, 2, 4)));
        System.out.println(list.findMember(123));
        System.out.println(list);
        System.out.println(list.registerPoints(123,76000));
        System.out.println(list.registerPoints(233, 55000));
        System.out.println(list);
        list.checkMembers(LocalDate.now());
        System.out.println(list);
        System.out.println(list.findPoints(123,"ole"));
        System.out.println(list.findMember(123));


   }
}
