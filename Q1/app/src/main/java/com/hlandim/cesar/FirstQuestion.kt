package com.hlandim.cesar

fun main(args: Array<String>) {
    val newValue = "&32"
    val stringArray = readLine()?.toCharArray()
    var count = 0
    if (stringArray != null) {
        for (i in 0..stringArray.size) {
            if (' ' == stringArray[i]) {
                count++
            }
        }
    }

    println(count)
}