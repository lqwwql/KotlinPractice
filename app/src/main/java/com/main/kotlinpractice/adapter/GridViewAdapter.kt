package com.main.kotlinpractice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.main.kotlinpractice.R
import com.main.kotlinpractice.bean.PhotoBean

/**
 * 版权：咸鱼信息科技有限公司 版权所有
 * @author lqw
 * 创建日期：2023/3/11 10:38
 * 描述：网格适配器
 */
class GridViewAdapter(
    private val context: Context,
    private val photoList: MutableList<PhotoBean>,
    private val backgroundColor: Int
) : BaseAdapter() {

    override fun getCount(): Int = photoList.size

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getItem(position: Int): Any = photoList[position]


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        val holder: ViewHolder
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.grid_view_item, null)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }
        holder.ivPhoto.setBackgroundResource(photoList[position].photoId)
        holder.ivPhotoName.text = photoList[position].photoName
        return view as View
    }

    inner class ViewHolder(val view: View) {
        val ivPhoto: ImageView = view.findViewById(R.id.iv_photo)
        val ivPhotoName: TextView = view.findViewById(R.id.tv_photo_name)
    }


}