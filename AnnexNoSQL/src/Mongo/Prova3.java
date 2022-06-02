package Mongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

public class Prova3 {

    public static void main(String[] args) {
        MongoClient con = new MongoClient("localhost" , 27017);
        MongoDatabase bd = con.getDatabase("test");
        
        Document ordenar = new Document();
        ordenar.put("precio", -1);
        
        FindIterable<Document> llibres =  bd.getCollection("libro").find().sort(ordenar);
        
        for (Document llibre : llibres)
            System.out.println("Títol:" + llibre.get("titulo") + ". Preu:" + llibre.get("precio"));
        
        con.close();
    }
}