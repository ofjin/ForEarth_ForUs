package com.aiden.tflite.tfliteimageclassifier

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aiden.tflite.tfliteimageclassifier.databinding.ActivityScanBinding

class ScanActivity : AppCompatActivity() {
    companion object{
        const val RESULT="RESULT"
    }

    private lateinit var binding: ActivityScanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnScan.setOnClickListener {
            val intent = Intent(applicationContext, QRScanner::class.java)
            startActivity(intent)
        }

        val result=intent.getStringExtra(RESULT)
        if(result!=null){
            if(result.contains("https://") || result.contains("http://")){
                val intent= Intent(Intent.ACTION_VIEW, Uri.parse(result))
                startActivity(intent)
            }
        }else{
            binding.result.text=result.toString()
        }
    }
}


