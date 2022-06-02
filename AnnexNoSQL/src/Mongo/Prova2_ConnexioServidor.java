package Mongo;

import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;

public class Prova2_ConnexioServidor {

    public static void main(String[] args) {
        //MongoClient con = new MongoClient("89.36.214.106" , 27017);

        MongoCredential credential = MongoCredential.createCredential("ad", "test", "ieselcaminas".toCharArray());
        MongoClient con = new MongoClient(new ServerAddress("89.36.214.106", 27017),
                Arrays.asList(credential));
        MongoDatabase bd = con.getDatabase("test");
        FindIterable<Document> llibres =  bd.getCollection("libro").find();
        
        for (Document llibre : llibres)
            System.out.println(llibre.get("titulo"));
        
        con.close();
    }
}