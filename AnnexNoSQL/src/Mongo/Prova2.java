package Mongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

public class Prova2 {

    public static void main(String[] args) {
        MongoClient con = new MongoClient("localhost" , 27017);
        MongoDatabase bd = con.getDatabase("test");
        
        FindIterable<Document> llibres =  bd.getCollection("libro").find();
        
        for (Document llibre : llibres)
            System.out.println(llibre.get("titulo"));
        
        con.close();
    }
}