package com.lixiang.phonecall.bean

class AdBean(
    val origin:String="",
    val adform:String="",
    val identity:String="",
    val location:Int=0,
) {
    override fun toString(): String {
        return "AdBean(origin='$origin', adform='$adform', identity='$identity', location=$location)"
    }
}