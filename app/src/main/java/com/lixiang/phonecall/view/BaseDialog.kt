package com.lixiang.phonecall.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import com.lixiang.phonecall.R


abstract class BaseDialog(context: Context) :
    Dialog(context, R.style.DialogTransparent) {
    protected var dm: DisplayMetrics? = null
    protected var width = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (contentViewId <= 0) {
            throw RuntimeException("layout resId undefind")
        }
        setContentView(contentViewId)
        dm = context.resources.displayMetrics
        init()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val window = window
        width = (dm!!.widthPixels * 0.8).toInt()
        val layoutParams = window!!.attributes
        layoutParams.width = width
        window.attributes = layoutParams
    }

    override fun dismiss() {
        superDismiss()
    }

    fun superDismiss() {
        super.dismiss()
    }

    protected abstract fun init()

    protected abstract val contentViewId: Int
}