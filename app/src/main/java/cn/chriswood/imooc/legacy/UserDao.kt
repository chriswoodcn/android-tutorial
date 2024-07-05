package cn.chriswood.imooc.legacy

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class UserDao(ctx: Context) {
    private val TAG = "UserDao"
    private var db: SQLiteDatabase = SqliteUserDb(ctx, "t_user.db", null, 1).writableDatabase;

    class SqliteUserDb(
        ctx: Context,
        path: String,
        c: SQLiteDatabase.CursorFactory?,
        v: Int
    ) : SQLiteOpenHelper(ctx, path, c, v) {
        private val TAG = "SqliteUserDb"
        override fun onCreate(db: SQLiteDatabase?) {
            Log.i(TAG, "onCreate: ")
            db?.execSQL(
                """
                    create table t_user (_id integer primary key autoincrement,
                            name varchar(20),
                            age integer,
                            gender varchar(1))
                """.trimIndent()
            )
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            Log.i(TAG, "onUpgrade: ")
        }
    }

    class UserBean(val _id: Int? = null, val name: String?, val age: Int?, val gender: String?)

    fun insertUser(bean: UserBean) {
        db.execSQL(
            """
            insert into t_user(name,age,gender) values(?,?,?)
        """.trimIndent(), arrayOf(bean.name, bean.age, bean.gender)
        )
    }

    fun queryUser(bean: UserBean): Cursor? {
        val sql = "select * from t_user where 1 = 1"
//        val values = emptyArray<String>()
//        if (bean.name != null) {
//            sql + "and name=?"
//            values + bean.name
//        }
//        if (bean.age != null) {
//            sql + "and age=?"
//            values + bean.age.toString()
//        }
//        if (bean.gender != null) {
//            sql + "and gender=?"
//            values + bean.gender
//        }
        val c = db.rawQuery(sql, null)
        Log.i(TAG, "queryUser: ${c.count}")
        return c
    }

    fun deleteUser(_id: String) {
        val sql = "delete from t_user where _id=?"
        db.execSQL(sql, arrayOf(_id))
    }

    fun updateUser(userBean: UserBean) {
        db.execSQL(
            """
            update t_user set name=?,age=?,gender=? where _id=?
        """.trimIndent(), arrayOf(userBean.name, userBean.age, userBean.gender, userBean._id)
        )
    }
}