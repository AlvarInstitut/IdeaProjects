package exemples

import net.xqj.exist.ExistXQDataSource

fun main() {
    val s = ExistXQDataSource();
    s.setProperty("serverName", "89.36.214.106")
    //s.setProperty("port", "8080")

    val conn = s.getConnection()
    println("Connexió feta")
}