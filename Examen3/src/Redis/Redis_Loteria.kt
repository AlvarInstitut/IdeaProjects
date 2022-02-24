package Redis

import redis.clients.jedis.Jedis

fun main(){
    val con = Jedis("89.36.214.106")
    con.auth("ieselcaminas.ad")

    for (i in 1..25)
        con.sadd("BomboNums_00",i.toString())

    con.sadd("BomboPremis_00","Primer Premi")
    con.sadd("BomboPremis_00","Segon Premi")
    con.sadd("BomboPremis_00","Tercer Premi")
    for (i in 1..5)
        con.sadd("BomboPremis_00","Pedrea " + i)

    while (con.exists("BomboPremis_00"))
        println (con.spop("BomboPremis_00") + ": " + con.spop("BomboNums_00"))

    println ("Números no premiats: " + con.smembers("BomboNums_00"))

    con.close()
}

