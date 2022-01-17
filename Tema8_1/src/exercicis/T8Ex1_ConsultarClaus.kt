package exercicis

import redis.clients.jedis.Jedis
import java.util.*

fun main(){
    val con = Jedis("89.36.214.106")
    con.connect()
    con.auth("ieselcaminas.ad")
    val c = con.keys("*")  //c és un MutableSet
    var i=1
    for (s in c) {
        println("" + i + ".- " + s)
        i++
    }
    val sc = Scanner(System.`in`)
    println("Introdueix un número (0 per a eixir)")
    var op = sc.nextInt()
    while (op != 0){
        if (op>0 && op <= c.size){
            val clau = c.elementAt(op-1)
            println (clau + " (" + con.type(clau) + ")")
            when(con.type(clau)){
                "string" -> println ("\t" + con.get(clau))
                "hash" ->   for (s in con.hkeys(clau))
                                println ("\t" + s + " -> " + con.hget(clau,s))
                "list" ->   for (s in con.lrange(clau,0,-1))
                                println ("\t" + s)
                "set" ->    for (s in con.smembers(clau))
                                println ("\t" + s)
                "zset" ->   for (s in con.zrangeWithScores(clau, 0, -1))
                            println ("\t" + s.element + " -> " + s.score)
            }
        }
        println("Introdueix un número (0 per a eixir)")
        op = sc.nextInt()
    }
    con.close()
}