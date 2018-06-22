/**
 * Created by hlandim on 22/06/18.
 */
fun main(args: Array<String>) {

    checkTypos("pale", "ple")
    checkTypos("pales", "pale")
    checkTypos("pale", "bale")
    checkTypos("pale", "bake")
}

fun checkTypos(first: String, second: String) {

    print("$first, $second -> ")
    println(hasOneTypos(first, second))

}

fun hasOneTypos(first: String, second: String): Boolean {

    if (first == second) return false

    var diffCount = 0
    var secondAux = second
    var firstAux = first
    when {
        first.length == second.length -> {
            first.forEachIndexed { index, c ->
                if (second[index] != c) {
                    diffCount++
                }
            }
        }
        first.length > second.length -> {
            var diffLength = first.length - second.length
            while (diffLength > 0) {
                secondAux += " "
                diffLength--
            }
            first.forEachIndexed { index, c ->
                if (c != secondAux[index]) {
                    secondAux = secondAux.substring(0, index) + c + secondAux.substring(index, secondAux.length - 1)
                    diffCount++
                }
            }
        }
        else -> {
            var diffLength = second.length - first.length
            while (diffLength > 0) {
                firstAux += " "
                diffLength--
            }
            second.forEachIndexed { index, c ->
                if (c != firstAux[index]) {
                    firstAux = firstAux.substring(0, index) + c + firstAux.substring(index, firstAux.length - 1)
                    diffCount++
                }
            }
        }
    }
    return diffCount == 1
}