package com.example.filesave

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.filesave.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    val viewModel: MyViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.fileSave = viewModel
        binding.lifecycleOwner = this


        binding.buttonSave.setOnClickListener {

            //val data = binding.editTextText.text.toString()
            viewModel.saveText(binding.editTextText.text.toString())
            FileSaver(this).writeToFile(viewModel.savedText.value.toString())


        }
        binding.buttonView.setOnClickListener {

            binding.view.setText(FileSaver(this).readFromFile())

        }

    }


}














