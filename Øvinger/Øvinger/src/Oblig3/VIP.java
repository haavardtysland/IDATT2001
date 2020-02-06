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
}
