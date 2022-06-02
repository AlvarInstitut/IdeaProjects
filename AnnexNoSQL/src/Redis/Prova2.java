package Redis;

import redis.clients.jedis.Jedis;


public class Prova2 {

    public static void main(String[] args) {
        Jedis con = new Jedis("localhost");
        con.connect();
        
        String valor = "Aquesta clau és una clau creada des de Java";
        con.set("clau_Java", valor);
        
        System.out.println(con.get("clau_Java"));
        con.close();
    }
}