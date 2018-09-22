package tickets;

import java.util.Calendar;

public class MovieTicketFlyweight implements IMovieTicket{

    private final Calendar showTime;
    private MovieTicket movieTicket;

    public MovieTicketFlyweight(Calendar showTime, MovieTicket movieTicket) {
        this.showTime = showTime;
        this.movieTicket = movieTicket;
    }

    @Override
    public String getMovieName() {
        return movieTicket.getMovieName();
    }

    @Override
    public String getMovieStudio() {
        return movieTicket.getMovieStudio();
    }

    @Override
    public String getDirector() {
        return movieTicket.getDirector();
    }

    @Override
    public Calendar getShowtime() {
        return showTime;
    }
}
