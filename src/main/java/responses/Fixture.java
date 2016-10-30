package responses;

import java.util.Date;

@lombok.Data
public class Fixture {
    private Date date;
    private String status;
    private int matchday;
    private String homeTeamName;
    private String awayTeamName;
    private FixtureResult result;
}
