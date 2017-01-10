import api.FootballApi;
import documents.CompetitionDocument;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import documents.FixtureDocument;
import responses.Competition;
import responses.Fixture;
import responses.SeasonFixtures;
import utils.MongoDbHelper;


public class App {

    public static void main(String[] args) throws Exception {

        // Get all the competitions
        FootballApi api = new FootballApi();
        Competition[] competitions = api.getResponse("http://api.football-data.org/v1/competitions", Competition[].class);

        // Saving all the competitions to the document database
        MongoDbHelper dbHelper = new MongoDbHelper();
        DBCollection competitionCollection = dbHelper.getCollection(CompetitionDocument.COLLECTION_NAME);

        System.out.println(competitionCollection.count());

        for (Competition competition: competitions) {

            CompetitionDocument document = new CompetitionDocument(competition);
            SeasonFixtures seasonFixtures = api.getResponse(competition.get_links().getFixtures().href, SeasonFixtures.class);

            for (Fixture fixture: seasonFixtures.getFixtures()) {
                FixtureDocument fixtureDocument = new FixtureDocument(fixture);
                document.addFixture(fixtureDocument);
            }

            document.finaliseFixtures();
            competitionCollection.save(document);
        }

        System.out.println(competitionCollection.count());
    }
}
