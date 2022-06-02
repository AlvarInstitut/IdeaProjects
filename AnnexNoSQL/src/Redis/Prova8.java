package Redis;

import java.util.Set;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

public class Prova8 {

    public static void main(String[] args) {
        Jedis con = new Jedis("localhost");
        con.connect();
        
        Set<Tuple> conjOrd = con.zrangeWithScores("puntuacions", 0, -1);
        for (Tuple t : conjOrd)
            System.out.println(t.getElement() + " ---> " + t.getScore());
        
        con.close();

    }
}