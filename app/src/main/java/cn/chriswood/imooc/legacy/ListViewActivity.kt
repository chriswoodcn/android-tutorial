package cn.chriswood.imooc.legacy

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import cn.chriswood.imooc.R

class ListViewActivity : Activity() {
    private val dataList: List<String>
        get() {
            return listOf(
                "hahaha", "welcome", "hello", "world", "good", "wood" +
                        "nice job"
            )
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_list_view)
        val listView = findViewById<ListView>(R.id.list_view_1)
        listView.adapter = ListAdapter()
    }

    inner class ListAdapter : BaseAdapter() {
        override fun getCount(): Int {
            return dataList.size
        }

        override fun getItem(position: Int): Any {
            return dataList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var itemView = convertView ?: layoutInflater.inflate(R.layout.list_view_item, null)
            val itemImage: ImageView = itemView.findViewById(R.id.item_icon)
            val itemTitle: TextView = itemView.findViewById(R.id.item_title)
            itemTitle.text = dataList[position]
            return itemView
        }

    }
}