package Redis

import redis.clients.jedis.Jedis

fun main(){
    val con = Jedis("89.36.214.106")
    con.auth("ieselcaminas.ad")
    for (i in 1..12)
        con.sadd("Baralla_77","O"+i)
    for (i in 1..12)
        con.sadd("Baralla_77","C"+i)
    for (i in 1..12)
        con.sadd("Baralla_77","E"+i)
    for (i in 1..12)
        con.sadd("Baralla_77","B"+i)

    for (i in 1..4) {
        print("Jugador " + i + " ---> ")
        for (j in 1..6)
            print(con.spop("Baralla_77") + " ")
        println()
    }
    println("Cartes sobrants:")
    println (con.smembers("Baralla_77"))
    con.close()

}