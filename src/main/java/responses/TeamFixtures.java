package responses;

@lombok.Data
public class TeamFixtures {
    private Link _links;
    private int count;
    private Fixture[] fixtures;
}
