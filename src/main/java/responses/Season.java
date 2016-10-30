package responses;
import java.util.Date;

@lombok.Data
public class Season {
    private Link _links;
    private int id;
    private String league;
    private String caption;
    private int year;
    private int currentMatchday;
    private int numberOfMatchdays;
    private int numberOfTeams;
    private int numberOfGames;
    private Date lastUpdated;
}
