package ticket;

public class MeetAndGreetTicket implements ITicket {

    ITicket ticket;

    public MeetAndGreetTicket(ITicket ticket) {
        this.ticket = ticket;
    }

    @Override
    public int getPrice() {
        return ticket.getPrice() + 100;
    }

    @Override
    public String getSummary() {
        return ticket.getSummary() + " + Meet and Greet";
    }
}
