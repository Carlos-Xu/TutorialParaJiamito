
fun main() {
    val name = "TOYOTA"

    val regEx = Coche.values()
        .joinToString("|") { it.name }
        .toRegex()

    if (regEx.matches(name)) {
        val parsed = Coche.valueOf(name)

        println(parsed)
    } else {
        println("Doesn't match")
    }

}

enum class Coche {
    toyota,
    nisan,
    audi;

    companion object {
        fun createFromString(string: String): Coche? {
            return when (string) {
                "TOYOTA" -> toyota
                "NISAN" -> nisan
                "AUDI" -> audi
                else -> null
            }
        }
    }
}