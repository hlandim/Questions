package com.hlandim.questionfour

class WordService {

    private val wordList = arrayListOf("yuo", "bale", "bake", "pales", "ple", "porbalby", "desptie"
            , "nmoo", "mpeissngslli", "sister", "right", "party", "council", "hotdog", "pour", "diameter"
            , "stock", "whole", "morsel", "bomber", "difficult", "clean", "absorb", "peak", "pig"
            , "jury", "step", "coach", "applied", "disappear", "spite", "undress", "linen", "nursery"
            , "cutting", "position", "dealer", "tone", "bell", "negligence", "recovery", "ridge"
            , "enter", "win", "winne", "duty", "learn", "jungle", "incredible", "interest", "beef", "funny"
            , "goal", "photocopy", "nerve", "stitch", "cherry", "president", "crowd", "fountain"
            , "customer", "facility", "free", "nationalism", "climb", "contrast", "shower", "rape"
            , "pair", "monopoly", "glance", "cunning", "culture", "economics", "bundle", "bland"
            , "wrist", "launch", "choice", "positive", "division", "technology", "plastic", "weapon"
            , "space", "circulate", "cattle", "shark", "wreck", "remedy", "crevice", "moving"
            , "distinct", "radio", "inject", "white", "snail", "grant", "percent", "mist", "ritual"
            , "difference", "administration", "quality", "judicial", "mushroom", "insurance", "stay"
            , "farewell", "pension", "bet", "beat", "bat")


    fun getWords(query: String) = wordList.filter { validateWord(query, it) }

    fun getAll() = wordList

    private fun validateWord(query: String, word: String): Boolean {

        if (query == word) return true

        var count = 0
        if (isPartialPermutation(query, word)) {
            count++
        }
        if (hasOneTypos(query, word)) {
            count++
        }

        return count == 1

    }

    private fun isPartialPermutation(first: String, second: String): Boolean {

        if (second.length == first.length) {

            if (first[0] == second[0]) {

                val wordsLength = second.length

                var diffLettersCount = 0

                if (first[0] != second[0]) {
                    return false
                }

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

    private fun hasOneTypos(first: String, second: String): Boolean {

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

}