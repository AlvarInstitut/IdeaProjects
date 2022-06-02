package Redis;

import redis.clients.jedis.Jedis;

public class Prova1 {

    public static void main(String[] args) {
        Jedis con = new Jedis("89.36.214.106");
        con.auth("ieselcaminas.ad");
        con.connect();
        
        System.out.println(con.get("LLOC"));
        
        con.close();
    }
}