package Mongo;

import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;

public class Prova3_ConnexioServidor {

    public static void main(String[] args) {
        MongoCredential credential = MongoCredential.createCredential("ad", "test", "ieselcaminas".toCharArray());
        MongoClient con = new MongoClient(new ServerAddress("89.36.214.106", 27017),
                Arrays.asList(credential));
        MongoDatabase bd = con.getDatabase("test");
        
        Document ordenar = new Document();
        ordenar.put("precio", -1);
        
        FindIterable<Document> llibres =  bd.getCollection("libro").find().sort(ordenar);
        
        for (Document llibre : llibres)
            System.out.println("Títol:" + llibre.get("titulo") + ". Preu:" + llibre.get("precio"));
        
        con.close();
    }
}