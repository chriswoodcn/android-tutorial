package cn.chriswood.imooc.legacy

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import cn.chriswood.imooc.R

class SharePreferenceActivity : Activity(), OnClickListener {
    private lateinit var accountEdit: EditText
    private lateinit var passwordEdit: EditText
    private lateinit var submitBtn: Button
    private lateinit var tip: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_share_preference)
        accountEdit = findViewById(R.id.share_preference_edit1)
        passwordEdit = findViewById(R.id.share_preference_edit2)
        submitBtn = findViewById(R.id.share_preference_submit)
        submitBtn.setOnClickListener(this)
        tip = findViewById(R.id.share_preference_tip)
        val sp = getSharedPreferences("account_password", MODE_PRIVATE)
        val account = sp.getString("account", "")
        val password = sp.getString("password", "")
        tip.text = "上次登录的用户：$account 密码：$password"
    }

    override fun onClick(v: View?) {
        when {
            v?.id == R.id.share_preference_submit -> {
                val account = accountEdit.text.toString()
                val password = passwordEdit.text.toString()
                if (account.isEmpty()) {
                    Toast.makeText(
                        this, "account must not be null",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                if (password.isEmpty()) {
                    Toast.makeText(
                        this, "password must not be null",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                val sp = getSharedPreferences("account_password", MODE_PRIVATE)
                val edit = sp.edit()
                edit.putString("account", account)
                edit.putString("password", password)
                edit.apply()
                Toast.makeText(
                    this, "save success!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}