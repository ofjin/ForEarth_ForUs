package com.aiden.tflite.tfliteimageclassifier

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class profileAdaptor(val profilesList:ArrayList<profiles>) : RecyclerView.Adapter<profileAdaptor.CustomviewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): profileAdaptor.CustomviewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return CustomviewHolder(view)
    }


    override fun getItemCount(): Int {
        return profilesList.size
    }


    override fun onBindViewHolder(holder: profileAdaptor.CustomviewHolder, position: Int) {
        holder.variety.setImageResource(profilesList.get(position).variety)
        holder.name.text= profilesList.get(position).name
        holder.point.text=profilesList.get(position).point
        holder.confirm.text=profilesList.get(position).confirm
        holder.date.text=profilesList.get(position).date
        holder.quantity.text=profilesList.get(position).quantity.toString()
    }

    class CustomviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val variety = itemView.findViewById<ImageView>(R.id.iv_itempic) // 상품사진
        val name=itemView.findViewById<TextView>(R.id.tv_name)          // 상품이름
        val date=itemView.findViewById<TextView>(R.id.tv_date)          // 상품이름
        val quantity=itemView.findViewById<TextView>(R.id.tv_quantity)          // 상품이름
        val point=itemView.findViewById<TextView>(R.id.tv_point)          // 상품이름
        val confirm=itemView.findViewById<Button>(R.id.btn_confirm)          // 상품이름




    }


}