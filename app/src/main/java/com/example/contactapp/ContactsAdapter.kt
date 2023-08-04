package com.example.contactapp

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ContactsAdapter(private val list:List<ContactData>, private val iClickListener: OnContactClickListener):RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {

    inner class ContactViewHolder(view: View): ViewHolder(view) {
        val contactLayout:ConstraintLayout = view.findViewById(R.id.contact_layout)
        val ivImg:ImageView = view.findViewById(R.id.iv_img)
        val tvName:TextView = view.findViewById(R.id.tv_name)
        val tvPhone:TextView = view.findViewById(R.id.tv_phone)
        val tvDescription:TextView = view.findViewById(R.id.tv_description)
    }

    interface OnContactClickListener{
        fun onContactClick(contact:ContactData,position:Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item,parent,false)
        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = list[position]
        val color = Color.parseColor(contact.img)
        holder.ivImg.backgroundTintList = ColorStateList.valueOf(color)
        holder.tvName.text = contact.name
        holder.tvPhone.text = contact.phone
        holder.tvDescription.text = contact.description
        holder.contactLayout.setOnClickListener {
            iClickListener.onContactClick(contact, position)
        }
    }
}