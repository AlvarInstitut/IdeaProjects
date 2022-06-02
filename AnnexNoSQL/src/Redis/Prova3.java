package Redis;

import java.util.List;
import redis.clients.jedis.Jedis;

public class Prova3 {

    public static void main(String[] args) {
        Jedis con = new Jedis("localhost");
        con.connect();
        
        List<String> c = con.mget("mes1","mes2","mes3");
        for (String s : c)
            System.out.println(s);
        
        con.close();
    }
}