package responses;

@lombok.Data
public class SeasonTeams {
    private Link _links;
    private int count;
    private Team[] teams;
}
