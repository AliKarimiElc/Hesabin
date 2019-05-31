package com.example.hesabin.repository

import android.app.Application
import androidx.lifecycle.MediatorLiveData
import com.example.hesabin.repository.model.ApplicationRoom

class Repository(application: Application) {

    var accountBalanceAmount = MediatorLiveData<Int>()
    private var db = ApplicationRoom.getInstance(application)

    init {
        accountBalanceAmount.addSource(db.transactions().balance()) {
            if (db.transactions().balance().value != null)
                accountBalanceAmount.postValue(db.transactions().balance().value)
            else
                accountBalanceAmount.postValue(0)
        }
    }

}