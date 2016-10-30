package responses;

@lombok.Data
public class Fixtures {
    private int count;
    private Fixture[] fixtures;
    private Link _links;
}
