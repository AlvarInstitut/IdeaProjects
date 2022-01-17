package exemples

import redis.clients.jedis.Jedis

fun main() {
    val con = Jedis("89.36.214.106")
    con.connect()
    con.auth("ieselcaminas.ad")
    println(con.get("LLOC"))
    con.close()
}