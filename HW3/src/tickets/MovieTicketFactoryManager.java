package tickets;

import java.util.Calendar;

public class MovieTicketFactoryManager {

    public static IMovieTicketFactory getMissionImpossibleMovieTicketFactory() {
        MovieTicket missionImpossible = new MovieTicket("Mission Impossible","DreamWorks","JJ Abrams");

        IMovieTicketFactory missionImposibleFactory = new IMovieTicketFactory() {
            @Override
            public IMovieTicket createTicket(Calendar showtime) {
                IMovieTicket missionImpossibleFly = new MovieTicketFlyweight(showtime, missionImpossible);
                return missionImpossibleFly;
            }
        };

        return missionImposibleFactory;
    }

    public static IMovieTicketFactory getStarWarsMovieTicketFactory() {
        MovieTicket starWar = new MovieTicket("Star Wars","LucasFilm","George Lucas");
        IMovieTicketFactory starWarsFactory = new IMovieTicketFactory() {
            @Override
            public IMovieTicket createTicket(Calendar showtime) {
                IMovieTicket starWarFly = new MovieTicketFlyweight(showtime, starWar);
                return starWarFly;
            }
        };
        return starWarsFactory;
    }

    public static IMovieTicketFactory getSpidermanMovieTicketFactory() {
        MovieTicket spiderMan = new MovieTicket("Spiderman","MGM","Steven Spielberg");
        IMovieTicketFactory spiderManFactory = new IMovieTicketFactory() {
            @Override
            public IMovieTicket createTicket(Calendar showtime) {
                IMovieTicket spiderManFly = new MovieTicketFlyweight(showtime, spiderMan);
                return spiderManFly;
            }
        };
        return spiderManFactory;
    }

}
