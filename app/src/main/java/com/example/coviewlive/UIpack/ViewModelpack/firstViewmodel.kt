package com.example.coviewlive.UIpack.ViewModelpack

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class firstViewmodel: ViewModel() {


   private  var _word = MutableLiveData("g")
   val word: LiveData<String> = _word




    // val todoItems: LiveData<List<TodoItem>> = _todoItems
    val letter2= MutableLiveData(listOf<String>())
    val score = MutableLiveData<Int>()


    fun setNewString(newWord:String) {
       _word.value=newWord

    }

}