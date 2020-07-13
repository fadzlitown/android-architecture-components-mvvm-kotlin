package com.anushka.viewmodeldemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.anushka.viewmodeldemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var total = 0
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.countText.text = viewModel.getCurCount().toString()
        binding.button.setOnClickListener {
            total = viewModel.updatedCount() //increase the count val (count survive data survive even configuration change / rotation)
            binding.countText.text = total.toString()
        }

        binding.calculate.setOnClickListener{
            viewModel.setTotal(binding.totalEdittext.text.toString().toInt()) //increase the count val (count survive data survive even configuration change / rotation)
            total = viewModel.getTotal()
            binding.countText.text = total.toString()
        }

    }
}
