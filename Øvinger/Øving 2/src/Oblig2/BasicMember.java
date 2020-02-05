package Oblig2;

import java.time.LocalDate;

public class BasicMember extends BonusMember {

    public BasicMember(int memberNo, Personals personals, LocalDate enrolledDate) {
        super(memberNo, personals, enrolledDate);
    }

    @Override
    public String toString() {
        return "BasicMember{" +
                "memberNo=" + getMemberNo() +
                ", personals=" + getPersonals() +
                ", enrolledDate=" + getEnrolledDate() +
                ", points=" + getPoints() +
                '}';
    }
}
