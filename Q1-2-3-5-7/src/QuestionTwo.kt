/**
 * Created by hlandim on 22/06/18.
 */

fun main(args: Array<String>) {

    checkPartialPermutation("you", "yuo")
    checkPartialPermutation("probably", "porbalby")
    checkPartialPermutation("despite", "desptie")
    checkPartialPermutation("moon", "nmoo")
    checkPartialPermutation("misspellings", "mpeissngslli")

}

fun checkPartialPermutation(first: String, second: String) {

    print("$first, $second -> ")
    println(isPartialPermutation(first, second))

}

fun isPartialPermutation(first: String, second: String): Boolean {

    if (second.length == first.length) {

        if (first[0] == second[0]) {

            val wordsLength = second.length

            var diffLettersCount = 0

            second.forEachIndexed { index, c ->
                val indexFirst = first.indexOf(c)
                if (indexFirst == -1) {
                    return false
                }
                if (index != indexFirst) {
                    diffLettersCount++
                }
            }

            if (wordsLength > 3) {
                if (diffLettersCount < (wordsLength * (2f / 3f))) {
                    return true
                }
            } else {
                return diffLettersCount > 0
            }

        }
    }

    return false
}
