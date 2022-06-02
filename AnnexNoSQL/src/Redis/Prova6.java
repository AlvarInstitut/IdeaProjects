package Redis;

import java.util.Set;
import redis.clients.jedis.Jedis;


public class Prova6 {

    public static void main(String[] args) {
        Jedis con = new Jedis("localhost");
        con.connect();
        
        Set<String> s = con.smembers("Moduls_meus");
        for (String e : s)
            System.out.println(e);
        
        con.close();
    }
}