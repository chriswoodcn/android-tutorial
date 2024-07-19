package cn.chriswood.tutorial.res.ui.view

import android.content.Context

class SwipeRefreshLayout(override var ctx: Context) : SwipeRefresh(ctx) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}