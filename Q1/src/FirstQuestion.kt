/**
 * Created by hlandim on 21/06/18.
 */

fun main(args: Array<String>) {

    val string = "User is not allowed      ".toCharArray()

    replaceWhiteSpace(string)

    println(string)

    print("Size: ${string.size}")


}

private fun replaceWhiteSpace(string: CharArray) {
    while (string.contains(' ')) {
        val withSpaceIndex = string.indexOf(' ')
        val lastLetterIndex = string.indexOfLast { v -> v != ' ' }

        for (i in lastLetterIndex downTo withSpaceIndex) {
            string[i + 2] = string[i]
        }
        string[withSpaceIndex] = '&'
        string[withSpaceIndex + 1] = '3'
        string[withSpaceIndex + 2] = '2'
    }
}