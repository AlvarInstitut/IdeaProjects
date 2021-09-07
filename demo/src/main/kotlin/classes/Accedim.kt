package classes

import javax.persistence.Persistence

fun main(){
    val eMF = Persistence.createEntityManagerFactory("default")
    val eM = eMF.createEntityManager()
    val comarques = eM.createQuery("SELECT c FROM ComarcaEntity c").resultList
    for (c in comarques) {
        c as ComarcaEntity
        println(c.nomC + " --> " + c.provincia + " ---> " + c.poblaciosByNomC.size + " pobles")
        for (p in c.poblaciosByNomC)
            println("\t" + p.nom)
    }
}