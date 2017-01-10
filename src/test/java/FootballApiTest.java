import api.FootballApi;
import junit.framework.Assert;
import org.junit.Test;
import responses.*;

public class FootballApiTest {

    @Test
    public void testShouldRetrieveSeasons() throws Exception {

        FootballApi api = new FootballApi();

        Season[] seasons = api.getResponse("http://api.football-data.org/v1/soccerseasons/", Season[].class);

        Season season = seasons[0];

        Assert.assertNotSame(0, season.getId());
        Assert.assertNotNull(season.getCaption());
        Assert.assertNotNull(season.getLeague());
    }

    @Test
    public void testShouldRetrieveLeague() throws Exception {

        FootballApi api = new FootballApi();

        LeagueTable table = api.getResponse("http://api.football-data.org/v1/soccerseasons/426/leagueTable", LeagueTable.class);
        Standing standing = table.getStanding()[0];

        Assert.assertNotNull(table.getLeagueCaption());
        Assert.assertNotSame(0, table.getMatchday());
        Assert.assertEquals(1, standing.getPosition());
        Assert.assertNotNull(standing.getTeamName());
    }

    @Test
    public void testShouldRetrieveFixtures() throws Exception {

        FootballApi api = new FootballApi();
        SeasonFixtures seasonFixtures = api.getResponse("http://api.football-data.org/v1/soccerseasons/427/fixtures", SeasonFixtures.class);
        Fixture fixture = seasonFixtures.getFixtures()[0];

        Assert.assertNotSame(0, seasonFixtures.getCount());
        Assert.assertNotNull(fixture);
        Assert.assertNotNull(fixture.getHomeTeamName());
        Assert.assertNotNull(fixture.getAwayTeamName());
        Assert.assertNotSame(0,fixture.getMatchday());
    }

    @Test
    public void testShouldRetrieveSeasonTeam() throws Exception {
        FootballApi api = new FootballApi();

        SeasonTeams seasonTeams = api.getResponse("http://api.football-data.org/v1/soccerseasons/426/teams", SeasonTeams.class);
        Team team = seasonTeams.getTeams()[0];

        Assert.assertNotSame(0, seasonTeams.getCount());
        Assert.assertNotNull(team);
        Assert.assertNotNull(team.getName());
    }

    @Test
    public void testShouldRetrieveSeasonFixturesForTeam() throws Exception {
        FootballApi api = new FootballApi();

        TeamFixtures teamFixtures = api.getResponse("http://api.football-data.org/v1/teams/322/fixtures", TeamFixtures.class);
        Fixture fixture = teamFixtures.getFixtures()[0];

        Assert.assertNotSame(0, teamFixtures.getCount());
        Assert.assertNotNull(fixture);
        Assert.assertNotNull(fixture.getHomeTeamName());
        Assert.assertNotNull(fixture.getAwayTeamName());
    }

    @Test
    public void testShouldRetrieveAllAvailableCompetitions() throws Exception {
        FootballApi api = new FootballApi();

        Competition[] competitions = api.getResponse("http://api.football-data.org/v1/competitions", Competition[].class);
        Competition competition = competitions[0];

        Assert.assertNotSame(0, competition.getId());
        Assert.assertNotNull(competition.getCaption());
        Assert.assertNotNull(competition.getLeague());
    }
}
