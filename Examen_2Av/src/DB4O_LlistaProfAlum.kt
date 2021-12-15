import com.db4o.Db4oEmbedded

fun main(){
    val bd = Db4oEmbedded.openFile("AutoEscola.db4o")
    val patro = Professor()
    val llista = bd.queryByExample<Professor>(patro)

    for (p in llista.sortedBy { it.nom }){
        println(p.nom)
        for (a in p.llAlumnes.sortedBy { it.nom }){
            var t = 0
            for (pract in a.llPractiques)
                t += pract.km
            println("\t---> " + a.nom + " " + a.llPractiques.size + " practiques. Total quilòmetres: " + t)
        }
    }
    bd.close()
}