package tickets;

import java.util.Calendar;
import java.util.List;

public interface IMovieTicket {
    String getMovieName();
    String getMovieStudio();
    String getDirector();
    Calendar getShowtime();
}
