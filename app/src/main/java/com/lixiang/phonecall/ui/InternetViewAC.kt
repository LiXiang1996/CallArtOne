package com.lixiang.phonecall.ui

import android.graphics.Bitmap
import android.os.Bundle
import android.view.KeyEvent
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.lixiang.phonecall.R
import com.lixiang.phonecall.base.LIGuangXu
import com.lixiang.phonecall.databinding.WebAaaaBinding

class InternetViewAC : LIGuangXu<WebAaaaBinding>() {
    override fun layoutId(): Int {
        return R.layout.web_aaaa
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && mBinding.callPrivacyWebview.canGoBack()) {
            mBinding.callPrivacyWebview.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event);
    }

    override fun onDestroy() {
        mBinding.callPrivacyWebview.loadDataWithBaseURL(null, "", "text/html", "utf-8", null)
        (mBinding.callPrivacyWebview.parent as ViewGroup).removeView(mBinding.callPrivacyWebview)
        mBinding.callPrivacyWebview.destroy()
        super.onDestroy()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.callPrivacyWebview.canGoBack()
        mBinding.callPrivacyWebview.canGoBack()
        mBinding.callPrivacyWebview.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?, request: WebResourceRequest?
            ): Boolean {
                view?.loadUrl("https://sites.google.com/view/ringart-app/%E9%A6%96%E9%A0%81")
                return true
            }
        }
        mBinding.callPrivacyWebview.loadUrl("https://sites.google.com/view/ringart-app/%E9%A6%96%E9%A0%81")

        mBinding.close.setOnClickListener { finish() }

    }


}