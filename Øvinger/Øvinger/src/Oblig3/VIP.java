package Oblig3;

public class VIP extends Tribune {
    private String[][] spectator;

    public VIP(String tribuneName, int capacity, int price, String[][] spectator) {
        super(tribuneName.trim(), capacity, price);
        this.spectator = spectator;
    }

    private int availableTickets() {
        int available = 0;
        for(int i = 0; i < spectator.length; i++) {
            for(int j = 0; j < spectator[i].length; j++) {
                if(spectator[i][j] == null) {
                    available+=1;
                }
            }
        }
        return available;
    }

    @Override
    public int findNumberOfSoldTickets() {
        return getCapacity() - availableTickets();
    }

    @Override
    public Ticket[] buyTicket(int numberOfTickets) {
        return null;
    }

    private boolean availableOnSameRow(int numberOfTickets) {
        int available = 0;
        for(int i = 0; i < spectator.length; i++) {
            available = 0;
            for(int j = 0; j < spectator[i].length; j++) {
                available++;
                if(numberOfTickets <= available) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Ticket[] buyTicket(String[] names) {
        int numberOfTickets = names.length;
        if(availableOnSameRow(numberOfTickets)) {
            Ticket[] tickets = new Ticket[numberOfTickets];
            return tickets;
        }
        return null;
    }
}
