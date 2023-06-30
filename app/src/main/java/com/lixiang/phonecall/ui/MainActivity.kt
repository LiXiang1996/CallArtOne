package com.lixiang.phonecall.ui

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.lixiang.phonecall.R
import com.lixiang.phonecall.base.LIGuangXu
import com.lixiang.phonecall.databinding.ActivityMainBinding
import com.lixiang.phonecall.ui.adapter.CallAdapter
import com.lixiang.phonecall.view.GridDecoration

class MainActivity : LIGuangXu<ActivityMainBinding>() {

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    private var callAdapter: CallAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val spanCount = 2 // 每行的列数，根据需要设置
        val layoutManager = GridLayoutManager(this, spanCount)
        mBinding.list.layoutManager = layoutManager
        callAdapter = CallAdapter(R.layout.rv_item)
        val list = arrayListOf(
            R.mipmap.call_img_1,
            R.mipmap.call_img_2,
            R.mipmap.call_img3,
            R.mipmap.call_img4,
            R.mipmap.call_img5,

            )
        mBinding.list.adapter = callAdapter

        mBinding.list.addItemDecoration(GridDecoration(1, 10, 2))

        callAdapter?.submitList(list)


        mBinding.shabi.addDrawerListener(object : DrawerLayout.SimpleDrawerListener() {
            private var lastSlideOffset = 0f
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                if (slideOffset > lastSlideOffset) {
                    mBinding.shabi.openDrawer(GravityCompat.START)
                }
                lastSlideOffset = slideOffset
            }
        })

        mBinding.set.setOnClickListener {
            mBinding.shabi.openDrawer(GravityCompat.START)
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return if (mBinding.shabi.isDrawerOpen(GravityCompat.START)) {
                mBinding.shabi.closeDrawer(GravityCompat.START)
                true
            } else {
                moveTaskToBack(true)
                true
            }
        }
        return super.onKeyDown(keyCode, event)
    }

}