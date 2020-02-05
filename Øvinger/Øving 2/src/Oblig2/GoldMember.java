package Oblig2;

import java.time.LocalDate;

public class GoldMember extends BonusMember {

    private int points;

    public GoldMember(int memberNo, Personals personals, LocalDate enrolledDate, int points) {
        super(memberNo, personals, enrolledDate);
        this.points = points;
    }

    public  GoldMember(BonusMember b) {
        super(b.getMemberNo(), b.getPersonals(), b.getEnrolledDate());
        this.points = b.getPoints();
    }

    public void registerPoints(int points) {
        this.points += points*GOLD_FACTOR;
    }

    @Override
    public String toString() {
        return "GoldMember{" +
                "memberNo=" + getMemberNo() +
                ", personals=" + getPersonals() +
                ", enrolledDate=" + getEnrolledDate() +
                ", points=" + points +
                '}';
    }
}
