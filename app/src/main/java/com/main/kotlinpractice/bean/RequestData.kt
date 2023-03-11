package com.main.kotlinpractice.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * 版权：咸鱼信息科技有限公司 版权所有
 * @author lqw
 * 创建日期：2023/3/4 17:33
 * 描述：测试数据类
 */
@Parcelize
data class RequestData (var name:String,var age:Int,var sex:Int) :Parcelable {

    init {

    }


}