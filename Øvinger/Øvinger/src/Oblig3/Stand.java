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
    public StandingTicket[] buyTicket(int numberOfTickets){
        if(numberOfTickets > availableTickets()){
            return null;
        }
        StandingTicket[] tickets = new StandingTicket[numberOfTickets];
        for(int i = 0; i < numberOfTickets; i++) {
            tickets[i] = new StandingTicket(getTribuneName(), getPrice());
        }
        return tickets;
    }

    @Override
    public StandingTicket[] buyTicket(String[] names) {
        int numberOfTickets = names.length;
        return buyTicket(numberOfTickets);
    }
}
