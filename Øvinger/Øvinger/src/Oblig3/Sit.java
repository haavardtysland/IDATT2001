package Oblig3;

public class Sit extends Tribune {
    private int[] noBusy;

    public Sit(String tribuneName, int capacity, int price, int[] noBusy) {
        super(tribuneName.trim(), capacity, price);
        this.noBusy = noBusy;
    }

    public int findNumberOfSoldTickets() {
        int sold = 0;
        for (int i = 0; i < noBusy.length; i++) {
            sold += noBusy[i];
        }
        return sold;
    }

    private int availableTickets() {
        return getCapacity() - findNumberOfSoldTickets();
    }

    @Override
    public Ticket[] buyTicket(int numberOfTickets) {
        if(numberOfTickets > availableTickets()) {
            return null;
        }
        Ticket[] tickets = new Ticket[numberOfTickets];
        return tickets;
    }

    public Ticket[] buyTicket(String[] names) {
            int numberOfTickets = names.length;
        if(numberOfTickets > availableTickets()) {
            return null;
        }
        Ticket[] tickets = new Ticket[numberOfTickets];
        return tickets;
    }
}
