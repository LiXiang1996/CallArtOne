package com.lixiang.phonecall.base


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.gyf.immersionbar.ImmersionBar
import com.lixiang.phonecall.R
import org.greenrobot.eventbus.EventBus


abstract class LIGuangXu<V : ViewDataBinding> : AppCompatActivity() {

    lateinit var mBinding: V
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, layoutId())
        mBinding.lifecycleOwner = this
        setContentView(mBinding.root)
        ImmersionBar.with(this).fullScreen(false).navigationBarColor(R.color.trans)
            .statusBarColor(R.color.trans).init()
//        EventBus.getDefault().register(this)

    }

    override fun onDestroy() {
        super.onDestroy()
//        EventBus.getDefault().unregister(this)

    }

    abstract fun layoutId(): Int


}