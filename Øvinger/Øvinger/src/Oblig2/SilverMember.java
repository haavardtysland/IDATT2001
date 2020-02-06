package Oblig2;

import java.time.LocalDate;

public class SilverMember extends BonusMember {

    private int points;

    public SilverMember(int memberNo, Personals personals, LocalDate enrolledDate, int points) {
        super(memberNo, personals, enrolledDate);
        this.points = points;
    }

    public  SilverMember(BonusMember b) {
        super(b.getMemberNo(), b.getPersonals(), b.getEnrolledDate());
        this.points = b.getPoints();
    }

    public void registerPoints(int points) {
        this.points += points*SILVER_FACTOR;
    }

    @Override
    public String toString() {
        return "SilverMember{" +
                "memberNo=" + getMemberNo() +
                ", personals=" + getPersonals() +
                ", enrolledDate=" + getEnrolledDate() +
                ", points=" + points +
                '}';
    }
}
