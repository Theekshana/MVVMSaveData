package com.example.filesave

import android.os.Bundle
import android.widget.Toast
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

            viewModel.saveText(binding.editTextText.text.toString())
            FileSaver(this).writeToFile(viewModel.savedText.value.toString())
            Toast.makeText(this,"File Saved",Toast.LENGTH_SHORT).show()


        }
        binding.buttonView.setOnClickListener {

            binding.view.setText(FileSaver(this).readFromFile())

        }

    }


}














