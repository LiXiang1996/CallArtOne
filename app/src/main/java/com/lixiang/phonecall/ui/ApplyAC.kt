package com.lixiang.phonecall.ui

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.Settings
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.blankj.utilcode.util.SPUtils
import com.blankj.utilcode.util.ToastUtils
import com.bumptech.glide.Glide
import com.lixiang.phonecall.R
import com.lixiang.phonecall.base.LIGuangXu
import com.lixiang.phonecall.base.Variable
import com.lixiang.phonecall.databinding.ApplyAaaaBinding
import com.lixiang.phonecall.view.DgPermission

class ApplyAC : LIGuangXu<ApplyAaaaBinding>() {
    override fun layoutId(): Int {
        return R.layout.apply_aaaa
    }

    private val PERMISSION_REQUEST_CODE = 1
    private val RESULT_ACTION_MANAGE_OVERLAY_PERMISSION = 2

    private var imgId: Int = R.mipmap.call_img_1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imgId = intent.getIntExtra("img", R.mipmap.call_img_1)

        Glide.with(this).load(imgId).centerCrop().into(mBinding.applyImg)

        mBinding.applyClose.setOnClickListener {
            finish()
        }
        mBinding.applyApply.setOnClickListener {
            check()
        }

    }


    private fun check() {
        val permissions = arrayOf(
            android.Manifest.permission.READ_PHONE_STATE,
            android.Manifest.permission.READ_CONTACTS,
            android.Manifest.permission.ANSWER_PHONE_CALLS,
            android.Manifest.permission.READ_CALL_LOG,
        )
        val deniedPermissions = permissions.filter {
            ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
        }
        // 检查权限
        if (!Settings.canDrawOverlays(this)) {
            val dialog = DgPermission(this)
            dialog.show()
            dialog.setOnClickListener(object : DgPermission.onClickListener {
                override fun onClick() {
                    val intent = Intent()
                    intent.action = Settings.ACTION_MANAGE_OVERLAY_PERMISSION
                    startActivityForResult(intent, RESULT_ACTION_MANAGE_OVERLAY_PERMISSION)
                    Variable.toRequestPermission2 = true
                }
            })
        } else if (deniedPermissions.isNotEmpty()) {
            // 请求权限
            ActivityCompat.requestPermissions(
                this,
                deniedPermissions.toTypedArray(),
                PERMISSION_REQUEST_CODE
            )
            Variable.toRequestPermission1 = true
        } else {
            applyImg()
        }
    }

    private fun applyImg() {
        SPUtils.getInstance().put("call_bg",imgId)
        mBinding.applyApply.text = "Applied"
        ToastUtils.showShort("Apply Success")
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
                check()
            } else {
                ToastUtils.showShort("No permission!!")
            }
        } else if (requestCode == RESULT_ACTION_MANAGE_OVERLAY_PERMISSION) {
            if (Settings.canDrawOverlays(this)) {
                check()
            } else {
                ToastUtils.showShort("No permission window")
            }
        }
    }


}