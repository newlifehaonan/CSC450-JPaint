package tickets;

import java.util.Calendar;
import java.util.List;

public class MovieTicket {
    private final String movieName;
    private final String movieStudio;
    private final String director;

    public MovieTicket(String movieName, String movieStudio, String director) {
        this.movieName = movieName;
        this.movieStudio = movieStudio;
        this.director = director;
    }

    public String getMovieName() {
        return movieName;
    }


    public String getMovieStudio() {
        return  movieStudio;
    }


    public String getDirector() {
        return director;
    }

}
