package com.aiden.tflite.tfliteimageclassifier

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.aiden.tflite.tfliteimageclassifier.databinding.ActivityCameraBinding
import com.aiden.tflite.tfliteimageclassifier.databinding.ActivityMainBinding
import java.io.File
import java.io.IOException
import java.util.*

class CameraActivity : AppCompatActivity() {
    private val binding by lazy { ActivityCameraBinding.inflate(layoutInflater, null, false) }
    private lateinit var classifier: Classifier
    //사용 확인 팝업 버튼
    private var imageUri: Uri? = null
    private val cameraResult =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { isSuccess: Boolean ->
            if (isSuccess.not()) return@registerForActivityResult
            val selectedImage = imageUri ?: return@registerForActivityResult
            var bitmap: Bitmap? = null
            try {
                bitmap = if (Build.VERSION.SDK_INT >= 28) {
                    val src = ImageDecoder.createSource(contentResolver, selectedImage)
                    ImageDecoder.decodeBitmap(src)
                } else {
                    MediaStore.Images.Media.getBitmap(contentResolver, selectedImage)
                }
            } catch (exception: IOException) {
                Toast.makeText(this, "Can not load image!!", Toast.LENGTH_SHORT).show()
            }
            bitmap?.let {
                val output = classifier.classify(bitmap)
                val resultStr =
                    // String.format(Locale.ENGLISH, "class : %s, prob : %.2f%%", output.first, output.second * 100)
                    String.format(Locale.ENGLISH, "%s류에 배출해주세요.", output.first)
                binding.run {
                    textResult.text = resultStr
                    imagePhoto.setImageBitmap(bitmap)
                }

            }
        }

    // 플라스틱 화면으로 전환
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initClassifier()
        setContentView(R.layout.activity_camera)

        val textResult=findViewById<Button>(R.id.textResult)
        textResult.setOnClickListener {
            startActivity(Intent(this@CameraActivity,Dialogcamera_plastic::class.java))
        }


        binding.run {
            btnTakePhoto.setOnClickListener {
                getTmpFileUri().let { uri ->
                    imageUri = uri
                    cameraResult.launch(uri)

                }
            }
        }

        //네비게이션  바
        val homeCameraView = findViewById<ImageButton>(R.id.home)
        val cameraCameraView = findViewById<ImageButton>(R.id.camera)
        val earthCameraView = findViewById<ImageButton>(R.id.earth)
        val pointCameraView = findViewById<ImageButton>(R.id.point)

        homeCameraView.setOnClickListener{
            startActivity(Intent(this,Home::class.java))
        }
        cameraCameraView.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
        earthCameraView.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
        pointCameraView.setOnClickListener{
            startActivity(Intent(this,StoreMain::class.java))
        }
    }

    override fun onDestroy() {
        classifier.finish()
        super.onDestroy()
    }

    private fun initClassifier() {
        classifier = Classifier(this, Classifier.IMAGENET_CLASSIFY_MODEL)
        try {
            classifier.init()
        } catch (exception: IOException) {
            Toast.makeText(this, "Can not init Classifier!!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getTmpFileUri(): Uri {
        val tmpFile = File.createTempFile("tmp_image_file", ".png", cacheDir).apply {
            createNewFile()
            deleteOnExit()
        }
        return FileProvider.getUriForFile(applicationContext, "${BuildConfig.APPLICATION_ID}.provider", tmpFile)
    }
}
