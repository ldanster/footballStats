package responses;

@lombok.Data
public class SeasonFixtures {
    private int count;
    private Fixture[] fixtures;
    private Link _links;
}
