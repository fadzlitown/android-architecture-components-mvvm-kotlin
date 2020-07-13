package com.anushka.viewmodeldemo1

import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    private var total = 0

    fun getCurCount(): Int{
        return total
    }

    fun updatedCount(): Int{
        return ++total;
    }

    fun setTotal(input: Int){
        total += input
    }

    fun getTotal(): Int{
        return total
    }


}