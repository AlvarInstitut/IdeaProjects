package Redis;

import java.util.Set;
import redis.clients.jedis.Jedis;


public class Prova7 {

    public static void main(String[] args) {
        Jedis con = new Jedis("localhost");
        con.connect();
        
        Set<String> subcamps = con.hkeys("empleat_1");
        for (String subcamp : subcamps)
            System.out.println(subcamp + ": " + con.hget("empleat_1", subcamp));
        
        con.close();
    }
}