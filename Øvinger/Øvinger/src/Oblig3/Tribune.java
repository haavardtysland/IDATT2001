package Oblig3;

public abstract class Tribune {

    private final String tribuneName;
    private final int capacity;
    private final int price;

    public Tribune(String tribuneName, int capacity, int price) {
        this.tribuneName = tribuneName.trim();
        this.capacity = capacity;
        this.price = price;
    }

    public abstract int findNumberOfSoldTickets();

    public int findIncome() {
        return findNumberOfSoldTickets()*price;
    }

    public String getTribuneName() {
        return tribuneName;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    public abstract Ticket[] buyTicket(int numberOfTickets);
    public abstract Ticket[] buyTicket(String[] names);

    @Override
    public String toString() {
        return "Tribune{" +
                "tribuneName='" + tribuneName + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                ", income=" + findIncome() +
                '}';
    }
}
