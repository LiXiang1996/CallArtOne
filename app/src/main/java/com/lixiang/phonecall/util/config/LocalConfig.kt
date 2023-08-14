package com.lixiang.phonecall.util.config

import com.lixiang.phonecall.BuildConfig

object LocalConfig {
    const val adJustToken="pfv45qhejsow"

    val topOnAppId=if (BuildConfig.DEBUG) "a62b013be01931" else "a64cb563161e0f"
    val topOnAppKey=if (BuildConfig.DEBUG) "c3d0d2a9a9d451b07e62b509659f7c97" else "956d7d14484b0fd19bce862bc1ed5d71"


    const val localAdStr="""{
"ra_vid":[
{
    "origin":"topon",
    "location":1,
    "adform":"interstitial",
    "identity":"b64cb5663dfb2c"
}
]
}"""
}