package responses;

@lombok.Data
public class LeagueTable {
    private Link _links;
    private String leagueCaption;
    private int matchday;
    private Standing[] standing;
}
