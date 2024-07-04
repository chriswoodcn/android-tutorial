package cn.chriswood.imooc.legacy

import android.app.Activity
import android.os.Bundle
import cn.chriswood.imooc.R

class SqliteActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_sqlite)
    }
}