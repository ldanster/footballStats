import api.FootballApi;
import api.FootballRequestBuilder;
import junit.framework.Assert;
import org.junit.Test;

import responses.*;

public class FootballApiTest {

    @Test
    public void testShouldBeAbleToGetSeasons() throws Exception {
        FootballRequestBuilder builder = new FootballRequestBuilder("soccerseasons/");

        FootballApi api = new FootballApi();

        Season[] seasons = api.getResponse(builder, Season[].class);

        Season season = seasons[0];

        Assert.assertNotSame(0, season.getId());
        Assert.assertNotNull(season.getCaption());
        Assert.assertNotNull(season.getLeague());
    }

    @Test
    public void testShouldRetrieveLeague() throws Exception {
        FootballRequestBuilder builder = new FootballRequestBuilder("soccerseasons/426/leagueTable");

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
        FootballRequestBuilder builder = new FootballRequestBuilder("soccerseasons/427/fixtures");

        FootballApi api = new FootballApi();
        Fixtures fixtures = api.getResponse(builder, Fixtures.class);
        Fixture fixture = fixtures.getFixtures()[0];

        Assert.assertNotSame(0, fixtures.getCount());
        Assert.assertNotNull(fixture);
        Assert.assertNotNull(fixture.getHomeTeamName());
        Assert.assertNotNull(fixture.getAwayTeamName());
        Assert.assertNotSame(0,fixture.getMatchday());
    }
}
