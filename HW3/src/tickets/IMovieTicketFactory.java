package tickets;

import java.util.Calendar;

public interface IMovieTicketFactory {
    IMovieTicket createTicket(Calendar showtime);
}
