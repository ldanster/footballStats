package utils;


import com.mongodb.DBCollection;
import junit.framework.Assert;
import org.junit.Test;

public class MongoDbHelperTest {

    @Test
    public void testShouldGetMongoDbCollection() {
        MongoDbHelper helper = new MongoDbHelper();
        DBCollection collection = helper.getCollection("TestCollection");

        Assert.assertNotNull(collection);
        Assert.assertEquals(0, collection.count());
    }
}
