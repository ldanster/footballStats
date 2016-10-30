package responses;


@lombok.Data
public class Standing {
    private int position;
    private String teamName;
    private int playedGames;
    private int points;
    private int goals;
    private int goalsAgainst;
    private int goalDifference;
    private int wins;
    private int draws;
    private int losses;
}
