package cn.chriswood.imooc.legacy

import android.app.Activity
import android.os.AsyncTask
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import cn.chriswood.imooc.R
import java.io.File

class DownloadActivity : Activity(), OnClickListener {
    private val TAG = "DownloadActivity"
    private var progressBar: ProgressBar? = null
    private var button: Button? = null
    private var text: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_download)
        progressBar = findViewById(R.id.download_progressBar)
        button = findViewById(R.id.download_button)
        text = findViewById(R.id.download_textView)
        initData()
        button?.setOnClickListener(this)
    }

    private fun initData() {
        progressBar?.progress = 0
        button?.setText(R.string.download_btn_start)
        text?.setText(R.string.download_text_1)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.download_button) {
            //下载
            val downloadAsyncTask = DownloadAsyncTask()
            downloadAsyncTask.execute("button", "onClick", "OnClickListener")
        }
    }

    inner class DownloadAsyncTask : AsyncTask<String, Int, Boolean>() {
        override fun onPreExecute() {
            button?.setText(R.string.download_btn_doing)
            text?.setText(R.string.download_text_2)
        }

        override fun doInBackground(vararg params: String?): Boolean {
            Log.d(TAG, "params: $params")
            for (i in 0..3) {
                Thread.sleep(1000)
                publishProgress(((i + 1) * 100 / 3))
            }
            val filePath = Environment.getExternalStorageDirectory().path + File.separator
            Log.d(TAG, "filePath: $filePath")
            return true
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            Log.d(TAG, "onProgressUpdate: $values")
            if (values.isNotEmpty())
                progressBar?.progress = values[0]!!
        }

        override fun onPostExecute(result: Boolean?) {
            super.onPostExecute(result)
            initData()
        }

    }
}