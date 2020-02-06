package Oblig2;

import java.time.LocalDate;
import java.time.Period;

public class BonusMember {

    public final int memberNo;
    private final Personals personals;
    private final LocalDate enrolledDate;
    private int points = 0;
    public static final double SILVER_FACTOR = 1.2;
    public static final double GOLD_FACTOR = 1.5;


    public BonusMember(int memberNo, Personals personals, LocalDate enrolledDate) {
        this.memberNo = memberNo;
        this.personals = personals;
        this.enrolledDate = enrolledDate;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public Personals getPersonals() {
        return personals;
    }

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public int getPoints() {
        return points;
    }

    public boolean okPassword(String password) {
        return personals.okPassword(password);
    }

    public int findQualificationPoints(LocalDate currentDate) {
        int yearsBetween = Period.between(enrolledDate, currentDate).getYears();

        if ( yearsBetween < 1) {
            return this.getPoints();
        }
        return 0;
    }

    public void registerPoints(int points) {
        this.points += points;
    }

    @Override
    public String toString() {
        return "BonusMember{" +
                "memberNo=" + memberNo +
                ", personals=" + personals +
                ", enrolledDate=" + enrolledDate +
                ", points=" + points +
                '}';
    }
}
