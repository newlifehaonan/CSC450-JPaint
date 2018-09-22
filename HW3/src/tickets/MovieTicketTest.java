package tickets;

import org.junit.Test;
import java.util.Calendar;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;

public class MovieTicketTest {
    @Test
    public void testSpidermanFactory() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 8,1, 10, 30);
        IMovieTicketFactory movieTicketFactory = MovieTicketFactoryManager.getSpidermanMovieTicketFactory();
        IMovieTicket ticket = movieTicketFactory.createTicket(calendar);

        assertEquals("Spiderman", ticket.getMovieName());
        assertEquals("Steven Spielberg", ticket.getDirector());
        assertEquals("MGM", ticket.getMovieStudio());
        assertEquals(calendar, ticket.getShowtime());
    }

    @Test
    public void testMissionImpossibleFactory() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 8,1, 10, 30);
        IMovieTicketFactory movieTicketFactory = MovieTicketFactoryManager.getStarWarsMovieTicketFactory();
        IMovieTicket ticket = movieTicketFactory.createTicket(calendar);

        assertEquals("Star Wars", ticket.getMovieName());
        assertEquals("George Lucas", ticket.getDirector());
        assertEquals("LucasFilm", ticket.getMovieStudio());
        assertEquals(calendar, ticket.getShowtime());
    }

    @Test
    public void testStarWarsFactory() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 8,1, 10, 30);
        IMovieTicketFactory movieTicketFactory = MovieTicketFactoryManager.getMissionImpossibleMovieTicketFactory();
        IMovieTicket ticket = movieTicketFactory.createTicket(calendar);

        assertEquals("Mission Impossible", ticket.getMovieName());
        assertEquals("JJ Abrams", ticket.getDirector());
        assertEquals("DreamWorks", ticket.getMovieStudio());
        assertEquals(calendar, ticket.getShowtime());
    }
}
