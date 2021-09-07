package exemples

import java.io.File

fun main() {
    val text = "Contingut per al fitxer."
    File("f3.txt").writeBytes(text.toByteArray())
}