import api.FootballApi;
import api.FootballRequestBuilder;
import responses.LeagueTable;
import responses.Season;

import java.util.List;


public class Application {

    public static void main(String[] args) throws Exception {

        getLeagueTable();
    }

    private static void getSeasons() throws Exception {
        FootballRequestBuilder builder = new FootballRequestBuilder("http://api.football-data.org/v1/soccerseasons/");

        FootballApi api = new FootballApi();

        List<Season> season = api.getResponse(builder);

        System.out.println(season.get(0).getCaption());
    }

    private static void getLeagueTable() throws Exception {
        FootballRequestBuilder builder = new FootballRequestBuilder("http://api.football-data.org/v1/soccerseasons/426/leagueTable");

        FootballApi api = new FootballApi();

        LeagueTable table = api.getResponse(builder, LeagueTable.class);

        System.out.println(table.getLeagueCaption());
    }
}
