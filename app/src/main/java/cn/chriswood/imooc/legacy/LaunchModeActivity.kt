package cn.chriswood.imooc.legacy

import android.app.AlertDialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupWindow
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import cn.chriswood.imooc.R


class LaunchModeActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_launch_mode)
        val button = findViewById<Button>(R.id.launch_mode_alert)
        button.setOnClickListener {
            AlertDialog.Builder(this).setMessage("this is a alert dialog")
                .setTitle("注意")
                .setPositiveButton("确定") { d, _ -> d.dismiss() }
                .setNegativeButton("取消") { d, _ -> d.dismiss() }
                .show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // xml资源
        menuInflater.inflate(R.menu.option, menu)
        // kotlin代码
        // menu?.add(1, 1, 1, "设置")
        // val sub = menu?.addSubMenu(1, 2, 2, "更多")
        // sub?.add(2, 3, 1, "更多1")
        // sub?.add(2, 4, 1, "更多1")
        // sub?.add(2, 5, 1, "更多1")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_option_search -> Toast.makeText(this, "search", Toast.LENGTH_LONG).show()
            R.id.menu_option_detail -> Toast.makeText(this, "detail", Toast.LENGTH_LONG).show()
            R.id.menu_option_more -> Toast.makeText(this, "more", Toast.LENGTH_LONG).show()
            R.id.menu_option_more_1 -> Toast.makeText(this, "more_1", Toast.LENGTH_LONG).show()
            R.id.menu_option_more_2 -> Toast.makeText(this, "more_2", Toast.LENGTH_LONG).show()
            R.id.menu_option_more_3 -> Toast.makeText(this, "more_3", Toast.LENGTH_LONG).show()
        }
        return true
    }

    fun onClick(v: View) {
        when (v.id) {
            R.id.launch_mode_pop1 -> showPop1()
            R.id.launch_mode_pop2 -> showPop1()
            R.id.launch_mode_pop3 -> showPop1()
            R.id.launch_mode_pop4 -> showPop1()
        }
    }

    private fun showPop1() {
        val view = layoutInflater.inflate(R.layout.layout_pop_1, null)
        val popupWindow = PopupWindow(view, 600, 40, true)
        popupWindow.animationStyle = R.style.pop_translate
        popupWindow.showAsDropDown(findViewById(R.id.launch_mode_pop1), 50, 50)
    }
}
