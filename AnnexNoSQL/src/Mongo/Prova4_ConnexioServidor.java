package Mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prova4_ConnexioServidor {
    public static void main(String[] args) {
        MongoCredential credential = MongoCredential.createCredential("ad", "test", "ieselcaminas".toCharArray());
        MongoClient con = new MongoClient(new ServerAddress("89.36.214.106", 27017),
                Arrays.asList(credential));
        MongoDatabase bd = con.getDatabase("test");

        Document ordenar = new Document("$sort", new Document("suma_preus",-1));
        Document agru = new Document();
        agru.put("_id", "$editorial");
        agru.put("suma_preus", new Document("$sum","$precio"));
        Document agrupar = new Document("$group",agru);

        List<Document> llistaParms = new ArrayList<>();
        llistaParms.add(agrupar);
        llistaParms.add(ordenar);

        AggregateIterable<Document> llibres =  bd.getCollection("libro").aggregate(llistaParms);

        for (Document llibre : llibres)
            System.out.println("Títol:" + llibre.get("_id") + ". Preu:" + llibre.get("suma_preus"));

        con.close();
    }
}
