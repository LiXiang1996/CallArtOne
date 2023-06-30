package com.lixiang.phonecall.view


import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.lixiang.phonecall.R
import com.lixiang.phonecall.ui.InternetViewAC


class CusSlideView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    lateinit var privacy: ConstraintLayout


    init {
        initView()
    }

    private fun initView() {
        LayoutInflater.from(context).inflate(R.layout.call_slide_aaaa, this, true)
        privacy = findViewById(R.id.set_2_cl)
        privacy.setOnClickListener {
            context.startActivity(Intent(context, InternetViewAC::class.java))
        }

    }
}

