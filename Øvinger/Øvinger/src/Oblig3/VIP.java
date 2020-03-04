package Oblig3;

public class VIP extends Tribune {
    private String[][] spectator;
    private final int seats;

    public VIP(String tribuneName, int capacity, int price, int rows) {
        super(tribuneName.trim(), capacity, price);
        this.spectator = new String[rows][capacity/rows];
        this.seats = capacity/rows;
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

    private int findAvailableRow(int numberOfTickets) {
        int count;
        for(int i = 0; i < spectator.length; i++) {
            count = 0;
            for(int j = 0; j < spectator[i].length; j++) {
                if(spectator[i][j] == null) {
                    count++;
                }
                if(numberOfTickets <= count) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int findAvailableOnRow(int row) {
        int available = 0;
        for(int i = 0; i < spectator[row].length; i++ ) {
            if(spectator[row][i] == null) {
                available++;
            }
        }
        return available;
    }

    @Override
    public SittingTicket[] buyTicket(int numberOfTickets) {
        return null;
    }


    @Override
    public SittingTicket[] buyTicket(String[] names) {
        int numberOfTickets = names.length;
        if(availableTickets() < numberOfTickets) {return null;}
        SittingTicket[] tickets = new SittingTicket[numberOfTickets];
        if(findAvailableRow(numberOfTickets) >= 0) {
            int row = findAvailableRow(numberOfTickets);
            int seat = seats - findAvailableOnRow(row);
            for (int i = 0; i < numberOfTickets; i++) {
                tickets[i] = new SittingTicket(getTribuneName(), getPrice(), row + 1, seat + 1);
                seat++;
            }
            int n = 0;
            for(int i = 0; i < numberOfTickets; i++) {
                spectator[row][i] = names[n];
                n++;
            }
            return tickets;
        }
        return null;
    }
}
