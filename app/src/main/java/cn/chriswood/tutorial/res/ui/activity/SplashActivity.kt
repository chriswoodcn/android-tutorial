package cn.chriswood.tutorial.res.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import cn.chriswood.tutorial.MainActivity
import cn.chriswood.tutorial.R

class SplashActivity : Activity() {
    private val mHandler = Handler()
    private lateinit var mBtnSkip: Button
    private val mRunnableToMain = Runnable { toMainActivity() }
    private fun toMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mBtnSkip = findViewById(R.id.id_btn_skip) as Button
        mHandler.postDelayed(mRunnableToMain, 3000)

        mBtnSkip.setOnClickListener(View.OnClickListener {
            mHandler.removeCallbacks(mRunnableToMain)
            toMainActivity()
        })
    }
}