package responses;

import java.util.Date;

@lombok.Data
public class Competition {
    private Link _links;
    private int id;
    private String caption;
    private String league;
    private String year;
    private int currentMatchday;
    private int numberOfMatchdays;
    private int numberOfTeams;
    private int numberOfGames;
    private Date lastUpdated;
}
