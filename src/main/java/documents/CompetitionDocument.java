package documents;


import com.mongodb.BasicDBObject;
import responses.Competition;

import java.util.ArrayList;
import java.util.List;

public class CompetitionDocument extends BasicDBObject {

    private static final String id = "id";
    private static final String caption = "caption";
    private static final String league = "league";
    private static final String year = "year";
    private static final String currentMatchday = "currentMatchday";
    private static final String numberOfMatchdays = "numberOfMatchdays";
    private static final String numberOfTeams = "numberOfTeams";
    private static final String numberOfGames = "numberOfGames";
    private static final String games = "fixtures";

    public static final String COLLECTION_NAME = "Competitions";

    private List<FixtureDocument> fixtures = new ArrayList<FixtureDocument>();

    public CompetitionDocument(Competition competition) {
        put(id, competition.getId());
        put(caption, competition.getCaption());
        put(league, competition.getLeague());
        put(year, competition.getYear());
        put(currentMatchday, competition.getCurrentMatchday());
        put(numberOfMatchdays, competition.getNumberOfMatchdays());
        put(numberOfTeams, competition.getNumberOfTeams());
        put(numberOfGames, competition.getNumberOfGames());
    }

    public void addFixture(FixtureDocument fixture) {
        fixtures.add(fixture);
    }

    public void finaliseFixtures() {
        put(games, fixtures);
    }

    public int getId() {
        return getInt(id);
    }

    public String getCaption() {
        return getString(caption);
    }

    public String getLeague() {
        return getString(league);
    }

    public String getYear() {
        return getString(year);
    }

    public int getCurrentMatchday() {
        return getInt(currentMatchday);
    }

    public int getNumberOfMatchdays() {
        return getInt(numberOfMatchdays);
    }

    public int getNumberOfTeams() {
        return getInt(numberOfTeams);
    }

    public int getNumberOfGames() {
        return getInt(numberOfGames);
    }

}
