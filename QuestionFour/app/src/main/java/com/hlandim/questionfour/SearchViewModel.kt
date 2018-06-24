package com.hlandim.questionfour

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class SearchViewModel : ViewModel() {

    val mList: MutableLiveData<List<String>> = MutableLiveData()
    private val mWordService = WordService()


    fun search(query: String) {
        mList.value = mWordService.getWords(query)
    }

    fun getAll() {
        mList.value = mWordService.getAll()
    }


}