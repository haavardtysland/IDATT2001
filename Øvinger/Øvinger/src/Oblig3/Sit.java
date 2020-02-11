package Oblig3;

public class Sit extends Tribune {
    private int[] noBusy;

    public Sit(String tribuneName, int capacity, int price, int rows) {
        super(tribuneName.trim(), capacity, price);
        this.noBusy = new int[rows];
    }

    public int findNumberOfSoldTickets() {
        int sold = 0;
        for (int i = 0; i < noBusy.length; i++) {
            sold += noBusy[i];
        }
        return sold;
    }

    private int numberOfSeats() {
        return getCapacity()/noBusy.length;
    }

    private int availableTickets() {
        return getCapacity() - findNumberOfSoldTickets();
    }

    @Override
    public SittingTicket[] buyTicket(int numberOfTickets) {
        if(numberOfTickets > availableTickets()) {
            return null;
        }
        return findAvailableTickets(numberOfTickets);
    }

    @Override
    public SittingTicket[] buyTicket(String[] names) {
        int numberOfTickets = names.length;
        if(numberOfTickets > availableTickets()) {
            return null;
        }
        return findAvailableTickets(numberOfTickets);
    }

    private SittingTicket[] findAvailableTickets(int numberOfTickets) {
        int availableRow = -1;
        int availableFrom= -1;
        SittingTicket[] tickets = new SittingTicket[numberOfTickets];
        for(int i = 0; i < noBusy.length; i++) {
            if(noBusy[i] + numberOfTickets <= numberOfSeats()){
                availableRow = i;
                availableFrom =  noBusy[i] + 1;
                for(int j = 0; j < numberOfTickets; j++) {
                    tickets[j] = new SittingTicket(getTribuneName(),getPrice(), availableRow + 1, availableFrom++);
                }
                noBusy[availableRow] += numberOfTickets;
                return tickets;
            }
        }
        return null;
    }
}
