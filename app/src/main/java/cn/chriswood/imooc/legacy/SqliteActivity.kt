package cn.chriswood.imooc.legacy

import android.app.Activity
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.CursorAdapter
import android.widget.EditText
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.RadioGroup
import android.widget.SimpleCursorAdapter
import android.widget.TextView
import android.widget.Toast
import cn.chriswood.imooc.R
import java.io.File

class SqliteActivity : Activity(), OnClickListener, RadioGroup.OnCheckedChangeListener {
    private val TAG = "SqliteActivity"
    private lateinit var nameEdit: EditText
    private lateinit var ageEdit: EditText
    private lateinit var genderEdit: RadioGroup
    private lateinit var idEdit: EditText
    private lateinit var insertBtn: Button
    private lateinit var queryBtn: Button
    private lateinit var deleteBtn: Button
    private lateinit var updateBtn: Button
    private lateinit var tableView: ListView
    private lateinit var dao: UserDao
    private var gender: String = "1"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_sqlite)
        nameEdit = findViewById(R.id.sqlite_input_name)
        ageEdit = findViewById(R.id.sqlite_input_age)
        genderEdit = findViewById(R.id.sqlite_input_gender)
        genderEdit.setOnCheckedChangeListener(this)
        idEdit = findViewById(R.id.sqlite_input_id)
        tableView = findViewById(R.id.sqlite_table)
        insertBtn = findViewById(R.id.sqlite_btn_1)
        queryBtn = findViewById(R.id.sqlite_btn_2)
        deleteBtn = findViewById(R.id.sqlite_btn_3)
        updateBtn = findViewById(R.id.sqlite_btn_4)
        insertBtn.setOnClickListener(this)
        queryBtn.setOnClickListener(this)
        deleteBtn.setOnClickListener(this)
        updateBtn.setOnClickListener(this)

        dao = UserDao(this)
    }

    override fun onClick(v: View?) {
        val name = if (nameEdit.text.isEmpty()) null else nameEdit.text.toString()
        val age = if (ageEdit.text.isEmpty()) null else ageEdit.text.toString()
        val userBean =
            UserDao.UserBean(null, name, if (age.isNullOrEmpty()) null else age.toInt(), gender)
        val _id = idEdit.text.toString()
        when (v?.id) {
            R.id.sqlite_btn_1 -> {
                dao.insertUser(userBean)
                Toast.makeText(this, "insert success", Toast.LENGTH_SHORT).show()
            }

            R.id.sqlite_btn_2 -> {
                val cursor = dao.queryUser(userBean)
                val simpleCursorAdapter = SimpleCursorAdapter(
                    this,
                    R.layout.layout_sqlite_table_item,
                    cursor,
                    arrayOf("_id", "name", "age", "gender"),
                    arrayOf(
                        R.id.table_id,
                        R.id.table_name,
                        R.id.table_age,
                        R.id.table_gender
                    ).toIntArray(),
                    CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
                )
                tableView.adapter = simpleCursorAdapter
            }

            R.id.sqlite_btn_3 -> {
                dao.deleteUser(_id)
                Toast.makeText(this, "delete success", Toast.LENGTH_SHORT).show()
            }

            R.id.sqlite_btn_4 -> {
                dao.updateUser(userBean)
                Toast.makeText(this, "update success", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when (checkedId) {
            R.id.gender_1 -> gender = "1"
            R.id.gender_2 -> gender = "2"
            R.id.gender_3 -> gender = "3"
        }
    }
}