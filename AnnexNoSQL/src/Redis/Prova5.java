package Redis;

import java.util.List;
import redis.clients.jedis.Jedis;

public class Prova5 {

    public static void main(String[] args) {
        Jedis con = new Jedis("localhost");
        con.connect();
        
        List<String> ll = con.lrange("llista1", 0, -1);
        for (String e : ll)
            System.out.println(e);
        
        con.close();
    }
}