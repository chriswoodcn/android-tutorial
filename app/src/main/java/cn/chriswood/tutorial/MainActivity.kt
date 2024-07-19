package cn.chriswood.tutorial

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import cn.chriswood.tutorial.legacy.CardViewActivity
import cn.chriswood.tutorial.legacy.DownloadActivity
import cn.chriswood.tutorial.legacy.ExternalStorageActivity
import cn.chriswood.tutorial.legacy.LaunchModeActivity
import cn.chriswood.tutorial.legacy.ListViewActivity
import cn.chriswood.tutorial.legacy.SharePreferenceActivity
import cn.chriswood.tutorial.legacy.SqliteActivity

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

            v.id == R.id.button6 ->
                startActivity(Intent(this, ExternalStorageActivity::class.java))

            v.id == R.id.button7 ->
                startActivity(Intent(this, SqliteActivity::class.java))}
    }
}