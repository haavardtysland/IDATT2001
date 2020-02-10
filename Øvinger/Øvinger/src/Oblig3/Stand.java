package Oblig3;

public class Stand extends Tribune {
    private int noSoldTickets;

    public Stand(String tribuneName, int capacity, int price, int noSoldTickets) {
        super(tribuneName.trim(), capacity, price);
        this.noSoldTickets = noSoldTickets;
    }

    @Override
    public int findNumberOfSoldTickets() {
        return noSoldTickets;
    }

    private int availableTickets() {
        return getCapacity() - noSoldTickets;
    }

    @Override
    public Ticket[] buyTicket(int numberOfTickets){
        if(numberOfTickets > availableTickets()){
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
