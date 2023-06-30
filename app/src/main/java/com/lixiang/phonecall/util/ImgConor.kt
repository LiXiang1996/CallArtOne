package com.lixiang.phonecall.util

import android.content.Context
import android.graphics.*
import com.bumptech.glide.Glide
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapResource
import java.security.MessageDigest


class ImgConor(context: Context?, radius: Float) : Transformation<Bitmap?> {
    private val mBitmapPool: BitmapPool
    private var radius: Float


    init {
        mBitmapPool = Glide.get(context!!).bitmapPool
        this.radius = radius
    }

    override fun transform(
        context: Context,
        resource: Resource<Bitmap?>,
        outWidth: Int,
        outHeight: Int
    ): Resource<Bitmap?> {
        val source = resource.get()
        var finalWidth: Int
        var finalHeight: Int
        var ratio: Float
        if (outWidth > outHeight) {
            ratio = outHeight.toFloat() / outWidth.toFloat()
            finalWidth = source.width
            finalHeight = (source.width.toFloat() * ratio).toInt()
            if (finalHeight > source.height) { //求出的最终高度>原图高度,求宽高比
                ratio = outWidth.toFloat() / outHeight.toFloat()
                finalHeight = source.height
                finalWidth = (source.height.toFloat() * ratio).toInt() //固定原图高度,求最终宽度
            }
        } else if (outWidth < outHeight) { //输出宽度 < 输出高度,求宽高比
            ratio = outWidth.toFloat() / outHeight.toFloat()
            finalHeight = source.height
            finalWidth = (source.height.toFloat() * ratio).toInt() //固定原图高度,求最终宽度
            if (finalWidth > source.width) { //求出的最终宽度 > 原图宽度,求高宽比
                ratio = outHeight.toFloat() / outWidth.toFloat()
                finalWidth = source.width
                finalHeight = (source.width.toFloat() * ratio).toInt()
            }
        } else {
            finalHeight = source.height
            finalWidth = finalHeight
        }

        //修正圆角
        radius *= finalHeight.toFloat() / outHeight.toFloat()
        var outBitmap: Bitmap? = mBitmapPool[finalWidth, finalHeight, Bitmap.Config.ARGB_8888]
        if (outBitmap == null) {
            outBitmap = Bitmap.createBitmap(finalWidth, finalHeight, Bitmap.Config.ARGB_8888)
        }
        val canvas = Canvas(outBitmap!!)
        val paint = Paint()
        //关联画笔绘制的原图bitmap
        val shader = BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        //计算中心位置,进行偏移
        val width = (source.width - finalWidth) / 2
        val height = (source.height - finalHeight) / 2
        if (width != 0 || height != 0) {
            val matrix = Matrix()
            matrix.setTranslate((-width).toFloat(), (-height).toFloat())
            shader.setLocalMatrix(matrix)
        }
        paint.shader = shader
        paint.isAntiAlias = true
        val rectF = RectF(0.0f, 0.0f, canvas.width.toFloat(), canvas.height.toFloat())
        canvas.drawRoundRect(rectF, radius, radius, paint) //先绘制圆角矩形
        return BitmapResource.obtain(outBitmap, mBitmapPool)!!
    }

    override fun updateDiskCacheKey(messageDigest: MessageDigest) {}
}
