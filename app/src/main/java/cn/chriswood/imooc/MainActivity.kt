package cn.chriswood.imooc

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

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
        }
    }
}