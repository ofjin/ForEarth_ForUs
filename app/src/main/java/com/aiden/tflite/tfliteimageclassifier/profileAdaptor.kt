package com.aiden.tflite.tfliteimageclassifier

import android.app.AlertDialog
import android.app.ProgressDialog.show
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.aiden.tflite.tfliteimageclassifier.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.list_item.view.*

class profileAdaptor(val profilesList:ArrayList<profiles>) : RecyclerView.Adapter<profileAdaptor.CustomviewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): profileAdaptor.CustomviewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return CustomviewHolder(view)


    }




    override fun getItemCount(): Int {
        return profilesList.size
    }



    override fun onBindViewHolder(holder: profileAdaptor.CustomviewHolder, position: Int) {

        holder.variety.setImageResource(profilesList.get(position).variety)  // 아이템과 연결
        holder.name.text = profilesList.get(position).name
        holder.point.text = profilesList.get(position).point
        holder.confirm.text = profilesList.get(position).confirm
        holder.date.text = profilesList.get(position).date
        holder.quantity.text = profilesList.get(position).quantity.toString()

        holder.confirm.setOnClickListener{
            fun reminderAlertDialog(context: Context){
                val dialog=AlertDialog.Builder(context)
                dialog.setTitle("확인 처리를 하시겠습니까?")
                dialog.setMessage("확인 후에는 사용처리되어 더 이상 사용할 수 없습니다")
                dialog.setPositiveButton("확인") { dialog, which ->
                    holder.confirm.isClickable=false
                    holder.confirm.text="사용완료"
                    holder.confirm.text=profilesList.get(position).confirm
                    holder.confirm.setBackgroundColor(Color.parseColor("#D5D5D5"))  // 파이어베이스의 데이터로 버튼 상태가 사용완료라고 전달-> 파이어베이스의 데이터가 사용완료일 경우 버튼 상태가 사용완료인 경우 비활성화가 되 비활성화되도록

                }
                dialog.setNegativeButton("취소") { dialog, which ->
                }
                dialog.show()
            }  // 다이얼로그 출력
            reminderAlertDialog(it.context)

        }

    }

    class CustomviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val variety = itemView.findViewById<ImageView>(R.id.iv_itempic) // 상품사진
        val name=itemView.findViewById<TextView>(R.id.tv_name)          // 상품이름
        val date=itemView.findViewById<TextView>(R.id.tv_date)          // 상품이름
        val quantity=itemView.findViewById<TextView>(R.id.tv_quantity)          // 상품이름
        val point=itemView.findViewById<TextView>(R.id.tv_point)          // 상품이름
        val confirm=itemView.findViewById<Button>(R.id.btn_confirm) // 상품이름



    }


}