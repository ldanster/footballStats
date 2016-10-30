package responses;

import responses.links.*;

@lombok.Data
public class Link {

    private TeamLink team;
    private SoccerSeasonLink soccerseason;
    private FixturesLink fixtures;
    private LeagueTableLink leagueTable;
}
