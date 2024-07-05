package cn.chriswood.imooc.legacy

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import cn.chriswood.imooc.R
import java.io.File

class ExternalStorageActivity : Activity(), OnClickListener {
    private val TAG = "ExternalStorageActivity"
    private lateinit var writeBtn: Button
    private lateinit var readBtn: Button
    private lateinit var textEdit: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_exernal_storage)
        textEdit = findViewById(R.id.ex_storage_text)
        writeBtn = findViewById(R.id.ex_storage_write)
        readBtn = findViewById(R.id.ex_storage_read)
        writeBtn.setOnClickListener(this)
        readBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (Environment.MEDIA_MOUNTED != Environment.getExternalStorageState()) {
            Toast.makeText(
                this, "外部存储未挂载",
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        val text = textEdit.text.toString()
        Log.i(TAG, "text: $text")

        //真实外部存储的目录
        val path = Environment
            .getExternalStorageDirectory()
            .absolutePath + File.separator + "test_ex_storage.txt"
        when {
            v?.id == R.id.ex_storage_write -> {
                if (text.isEmpty()) {
                    Toast.makeText(
                        this, "内容为空",
                        Toast.LENGTH_SHORT
                    ).show()
                    return
                }
                try {

                    if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                        )
                    ) {
                        ActivityCompat.requestPermissions(
                            this,
                            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                            1
                        )
                    }
                    val file = File(path)
                    if (!file.exists()) {
                        file.createNewFile()
                    }
                    file.writer().buffered(1024).write(text)
                    Toast.makeText(this, "write success", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    Log.i(TAG, e.message.toString())
                }

            }

            v?.id == R.id.ex_storage_read -> {
                if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(
                        this,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    )
                ) {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        2
                    )
                }
                try {
                    val file = File(path)
                    if (file.exists()) {
                        val readText = file.reader().buffered(1024).readLines()
                        Log.i(TAG, "readText: $readText")
                        textEdit.setText(readText.joinToString())
                    } else {
                        textEdit.setText("")
                    }
                    Toast.makeText(this, "read success", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    Log.i(TAG, e.message.toString())
                }

            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {

        }
    }
}