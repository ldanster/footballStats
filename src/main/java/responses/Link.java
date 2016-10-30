package responses;

import responses.links.*;

@lombok.Data
public class Link {

    private NavigationLink self;
    private NavigationLink team;
    private NavigationLink soccerseason;
    private NavigationLink fixtures;
    private NavigationLink leagueTable;
    private NavigationLink players;
    private NavigationLink competition;
    private NavigationLink homeTeam;
    private NavigationLink awayTeam;
}
