package utils;


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import documents.CompetitionDocument;

public class MongoDbHelper {

    private DB db;

    public MongoDbHelper() {
        Mongo mongo = new Mongo("localhost", 27017);
        db = mongo.getDB("sportsDb");
    }

    public DBCollection getCollection(String collectionName) {
        return db.getCollection(collectionName);
    }
}
