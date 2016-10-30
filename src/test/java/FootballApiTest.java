import api.FootballApi;
import api.FootballRequestBuilder;
import junit.framework.Assert;
import org.junit.Test;

import responses.LeagueTable;
import responses.Season;

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
    public void testShouldRetreiveLeague() throws Exception {
        FootballRequestBuilder builder = new FootballRequestBuilder("soccerseasons/426/leagueTable");

        FootballApi api = new FootballApi();

        LeagueTable table = api.getResponse(builder, LeagueTable.class);

        Assert.assertNotNull(table.getLeagueCaption());
        Assert.assertNotSame(0, table.getMatchday());
    }
}
