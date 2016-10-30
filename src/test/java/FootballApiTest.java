import api.FootballApi;
import api.FootballRequestBuilder;
import junit.framework.Assert;
import org.junit.Test;

import responses.*;

public class FootballApiTest {

    @Test
    public void testShouldRetrieveSeasons() throws Exception {
        FootballRequestBuilder builder = new FootballRequestBuilder("http://api.football-data.org/v1/soccerseasons/");

        FootballApi api = new FootballApi();

        Season[] seasons = api.getResponse(builder, Season[].class);

        Season season = seasons[0];

        Assert.assertNotSame(0, season.getId());
        Assert.assertNotNull(season.getCaption());
        Assert.assertNotNull(season.getLeague());
    }

    @Test
    public void testShouldRetrieveLeague() throws Exception {
        FootballRequestBuilder builder = new FootballRequestBuilder("http://api.football-data.org/v1/soccerseasons/426/leagueTable");

        FootballApi api = new FootballApi();

        LeagueTable table = api.getResponse(builder, LeagueTable.class);
        Standing standing = table.getStanding()[0];

        Assert.assertNotNull(table.getLeagueCaption());
        Assert.assertNotSame(0, table.getMatchday());
        Assert.assertEquals(1, standing.getPosition());
        Assert.assertNotNull(standing.getTeamName());
    }

    @Test
    public void testShouldRetrieveFixtures() throws Exception {
        FootballRequestBuilder builder = new FootballRequestBuilder("http://api.football-data.org/v1/soccerseasons/427/fixtures");

        FootballApi api = new FootballApi();
        SeasonFixtures seasonFixtures = api.getResponse(builder, SeasonFixtures.class);
        Fixture fixture = seasonFixtures.getFixtures()[0];

        Assert.assertNotSame(0, seasonFixtures.getCount());
        Assert.assertNotNull(fixture);
        Assert.assertNotNull(fixture.getHomeTeamName());
        Assert.assertNotNull(fixture.getAwayTeamName());
        Assert.assertNotSame(0,fixture.getMatchday());
    }

    @Test
    public void testShouldRetrieveSeasonTeam() throws Exception {
        FootballRequestBuilder builder = new FootballRequestBuilder("http://api.football-data.org/v1/soccerseasons/426/teams");
        FootballApi api = new FootballApi();

        SeasonTeams seasonTeams = api.getResponse(builder, SeasonTeams.class);
        Team team = seasonTeams.getTeams()[0];

        Assert.assertNotSame(0, seasonTeams.getCount());
        Assert.assertNotNull(team);
        Assert.assertNotNull(team.getName());
    }

    @Test
    public void testShouldRetrieveSeasonFixturesForTeam() throws Exception {
        FootballRequestBuilder builder = new FootballRequestBuilder("http://api.football-data.org/v1/teams/322/fixtures");
        FootballApi api = new FootballApi();

        TeamFixtures teamFixtures = api.getResponse(builder, TeamFixtures.class);
        Fixture fixture = teamFixtures.getFixtures()[0];

        Assert.assertNotSame(0, teamFixtures.getCount());
        Assert.assertNotNull(fixture);
        Assert.assertNotNull(fixture.getHomeTeamName());
        Assert.assertNotNull(fixture.getAwayTeamName());
    }
}
