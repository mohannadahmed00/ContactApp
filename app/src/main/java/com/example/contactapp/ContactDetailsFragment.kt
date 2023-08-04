package com.example.contactapp

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class ContactDetailsFragment(private val contact: ContactData) : Fragment() {

    private lateinit var ivImg: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvPhone: TextView
    private lateinit var tvDescription: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ivImg = view.findViewById(R.id.iv_img)
        tvName = view.findViewById(R.id.tv_name)
        tvPhone = view.findViewById(R.id.tv_phone)
        tvDescription = view.findViewById(R.id.tv_description)

        val color = Color.parseColor(contact.img)
        ivImg.backgroundTintList = ColorStateList.valueOf(color)
        tvName.text = contact.name
        tvPhone.text = contact.phone
        tvDescription.text = contact.description

    }

}