package Redis;

import java.util.Set;
import redis.clients.jedis.Jedis;

public class Prova4 {

    public static void main(String[] args) {
        Jedis con = new Jedis("localhost");
        con.connect();
        
        Set<String> c = con.keys("*");
        for (String s : c)
            System.out.println(s);
        
        con.close();
    }
}