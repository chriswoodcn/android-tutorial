package cn.chriswood.imooc.legacy

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import cn.chriswood.imooc.R

class CardViewActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_card_view)
        val text: TextView = findViewById(R.id.hello_card_view)
        text.setText(R.string.main_button_4)
    }
}