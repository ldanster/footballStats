package responses;

import responses.links.FixturesLink;
import responses.links.SoccerSeasonLink;
import responses.links.TeamLink;

@lombok.Data
public class Link {

    private TeamLink team;
    private SoccerSeasonLink soccerseason;
    private FixturesLink fixtures;
}
