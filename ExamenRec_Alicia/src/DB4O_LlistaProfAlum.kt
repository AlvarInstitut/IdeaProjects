import com.db4o.Db4oEmbedded

fun main(){
    val bd = Db4oEmbedded.openFile("AutoEscola.db4o")
    val patro = Professor()
    val llista = bd.queryByExample<Professor>(patro)

    for (p in llista){
        println(p.nom)
        for (a in p.llAlumnes.sortedBy { it.nom }){  // Això d'ordenar seria opcional, però mira què fàcil en Kotlin
            var tot = 0
            for (pr in a.llPractiques)
                tot += pr.km
            println("\t---> " + a.nom + " " + a.llPractiques.size + ". Total quilòmetres: " + tot)
        }
    }

    bd.close()
}