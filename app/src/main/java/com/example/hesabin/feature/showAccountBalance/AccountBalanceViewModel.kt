package com.example.hesabin.feature.showAccountBalance

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.hesabin.repository.Repository
import java.io.Serializable
import kotlin.math.absoluteValue

class AccountBalanceViewModel(application: Application) : AndroidViewModel(application) {

    var accountBalanceAmount = MutableLiveData<Int>()
    var intentObservable = MutableLiveData<Click?>()

    private val repository: Repository = Repository(application)

    init {
        val balance = repository.accountBalanceAmount
        accountBalanceAmount.postValue(Transformations.map(balance) { x -> x.absoluteValue }.value)
    }

    fun onRegisterClick(view: View) {
        intentObservable.postValue(Click.Payment)
    }

    fun onActivityPause() {
        intentObservable.postValue(null)
    }

}

enum class Click : Serializable {
    Payment,
    Receive
}