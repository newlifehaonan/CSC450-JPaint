package ticket;

public class TicketBuilder {
    ITicket ticket;

    public TicketBuilder addTicket(String showName, int price) {
        ticket = new Ticket(showName, price);

        return this;
    }

    public ITicket getTicket() {
        return ticket;
    }

    public TicketBuilder addMeetAndGreet() {

        ticket = new MeetAndGreetTicket(ticket);

        return this;
    }

    public TicketBuilder addBonusPackage() {

        ticket = new BonusPackageTicket(ticket);
        return this;
    }
}
