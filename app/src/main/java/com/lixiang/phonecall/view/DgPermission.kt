package com.lixiang.phonecall.view

import android.content.Context
import android.widget.TextView
import com.lixiang.phonecall.R


open class DgPermission(context: Context) : BaseDialog(context) {
    private var mBtnPermission: TextView? = null
    private var mOnClickListener: onClickListener? = null


    override fun init() {
        mBtnPermission = findViewById(R.id.btn_permission)
        mBtnPermission?.setOnClickListener { _ ->
            if (mOnClickListener != null) {
                dismiss()
                mOnClickListener!!.onClick()
            }
        }
    }

    fun setOnClickListener(onClickListener: onClickListener?) {
        mOnClickListener = onClickListener
    }

    interface onClickListener {
        fun onClick()
    }

    override val contentViewId: Int
        protected get() = R.layout.call_dg_per
}