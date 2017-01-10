package documents;


import com.mongodb.BasicDBObject;
import responses.Fixture;

public class FixtureDocument extends BasicDBObject {

    private static final String date = "date";
    private static final String status = "status";
    private static final String matchday = "matchday";
    private static final String homeTeamName = "homeTeamName";
    private static final String homeTeamGoals = "homeTeamGoals";
    private static final String awayTeamName = "awayTeamName";
    private static final String awayTeamGoals = "awayTeamGoals";

    public FixtureDocument(Fixture fixture) {
        put(date, fixture.getDate());
        put(status, fixture.getStatus());
        put(matchday, fixture.getMatchday());
        put(homeTeamName, fixture.getHomeTeamName());
        put(awayTeamName, fixture.getAwayTeamName());
        put(homeTeamGoals, fixture.getResult().getGoalsHomeTeam());
        put(awayTeamGoals, fixture.getResult().getGoalsAwayTeam());
    }
}
