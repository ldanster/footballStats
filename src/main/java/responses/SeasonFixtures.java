package responses;

@lombok.Data
public class SeasonFixtures {
    private Link _links;
    private int count;
    private Fixture[] fixtures;
}
