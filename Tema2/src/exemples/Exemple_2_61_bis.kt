package exemples

import java.io.File

fun main() {
    File("f5_2.txt").writeText(File("f5.txt").readText(), Charsets.ISO_8859_1)
}