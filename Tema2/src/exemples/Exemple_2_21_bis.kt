package exemples

import java.io.File

fun main(){
    val tot = File("f1.txt").readText()
    for(c in tot){
        println(c)
    }
}

