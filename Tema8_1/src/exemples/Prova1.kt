package exemples

import redis.clients.jedis.Jedis

fun main() {
    val con = Jedis("localhost")
    con.connect()
    println(con.get("clau_Java"))
    con.close()
}