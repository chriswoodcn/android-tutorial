package cn.chriswood.imooc

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import cn.chriswood.imooc.legacy.CardViewActivity
import cn.chriswood.imooc.legacy.DownloadActivity
import cn.chriswood.imooc.legacy.LaunchModeActivity
import cn.chriswood.imooc.legacy.ListViewActivity
import cn.chriswood.imooc.legacy.SharePreferenceActivity

class MainActivity : Activity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)
    }

    fun onClick(v: View) {
        when {
            v.id == R.id.button1 ->
                startActivity(Intent(this, LaunchModeActivity::class.java))

            v.id == R.id.button2 ->
                startActivity(Intent(this, DownloadActivity::class.java))

            v.id == R.id.button3 ->
                startActivity(Intent(this, ListViewActivity::class.java))

            v.id == R.id.button4 ->
                startActivity(Intent(this, CardViewActivity::class.java))

            v.id == R.id.button5 ->
                startActivity(Intent(this, SharePreferenceActivity::class.java))
        }
    }
}