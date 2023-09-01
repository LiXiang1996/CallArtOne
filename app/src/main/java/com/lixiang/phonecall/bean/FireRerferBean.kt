package com.lixiang.phonecall.bean

class FireRerferBean(
    var ringrt_base_abc:Int=1,
    var ringrt_base_bcd:Int=2,
    var ringrt_base_ext:Int=2,
    var ringrt_base_have:Int=1,
    var ringrt_base_it:Int=1,
    var ringrt_base_vip:Int=1,
    var ringrt_base_sip:Int=1,
) {

    fun isFB(string: String):Boolean{
        if (ringrt_base_abc==2){
            return false
        }
        return string.contains("fb4a")||string.contains("facebook")
    }

    fun isBuyUser(string: String):Boolean{
        return (string.contains("gclid")&&ringrt_base_bcd==1)
                || (string.contains("not%20set")&&ringrt_base_ext==1)
                || (string.contains("youtubeads")&&ringrt_base_have==1)
                || (string.contains("%7B%22")&&ringrt_base_it==1)
                || (string.contains("adjust")&&ringrt_base_vip==1)
                || (string.contains("bytedance")&&ringrt_base_sip==1)
    }
}