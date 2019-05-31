package com.example.hesabin.feature.showAccountBalance

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.hesabin.R
import com.example.hesabin.databinding.ActivityMainBinding
import com.example.hesabin.feature.registerReceiveMoney.RegisterActivity

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : AccountBalanceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(AccountBalanceViewModel::class.java)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        viewModel.intentObservable.observe(this, Observer { click ->

            click?.let { startActivity(Intent(this, RegisterActivity::class.java).putExtra("mode", it)) }
        })
    }

    override fun onPause() {
        super.onPause()
        viewModel.onActivityPause()
    }
}
