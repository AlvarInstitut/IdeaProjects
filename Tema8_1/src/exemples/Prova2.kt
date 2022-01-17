package exemples

import redis.clients.jedis.Jedis

fun main() {
    val con = Jedis("localhost")
    con.connect()

    val valor = "Aquesta clau és una clau creada des de Kotlin"
    con.set("clau_Kotlin", valor)

    println(con.get("clau_Kotlin"))
    con.close()
}