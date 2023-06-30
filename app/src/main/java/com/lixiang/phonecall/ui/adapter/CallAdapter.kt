package com.lixiang.phonecall.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.ViewGroup
import android.widget.ImageView
import com.blankj.utilcode.util.SizeUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.QuickViewHolder
import com.lixiang.phonecall.R
import com.lixiang.phonecall.ui.ApplyAC
import com.lixiang.phonecall.util.ImgConor


class CallAdapter(val layoutId: Int) : BaseQuickAdapter<Int, QuickViewHolder>() {
    override fun onBindViewHolder(holder: QuickViewHolder, position: Int, item: Int?) {
        val img = holder.getView<ImageView>(R.id.item_img)
        item?.let {
            loadRoundedImage(it, 6, img)
        }
        img.setOnClickListener {
            val intent = Intent(context, ApplyAC::class.java)
            intent.putExtra("img", item)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(
        context: Context,
        parent: ViewGroup,
        viewType: Int
    ): QuickViewHolder {
        return QuickViewHolder(layoutId, parent)
    }

    @SuppressLint("CheckResult")
    private fun loadRoundedImage(url: Int, cornerRadius: Int, imageView: ImageView) {
        val transformation = ImgConor(
            context,
            SizeUtils.dp2px(cornerRadius.toFloat()).toFloat()
        )
        val options = RequestOptions()
        options.diskCacheStrategy(DiskCacheStrategy.NONE)
        Glide.with(context).load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .apply(options)
            .transform(transformation)
            .into(imageView)

    }

}