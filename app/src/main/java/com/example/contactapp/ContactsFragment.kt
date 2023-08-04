package com.example.contactapp

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import java.util.Random

class ContactsFragment(private val onItemClick: OnItemClick) : Fragment(),ContactsAdapter.OnContactClickListener {

    private lateinit var etName: EditText
    private lateinit var etPhone: EditText
    private lateinit var etDescription: EditText
    private lateinit var btnAdd: Button
    private lateinit var rvContacts: RecyclerView
    private val contactsList:MutableList<ContactData> = mutableListOf()
    private lateinit var adapter: ContactsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contacts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        etName = view.findViewById(R.id.et_name)
        etPhone = view.findViewById(R.id.et_phone)
        etDescription = view.findViewById(R.id.et_description)
        btnAdd = view.findViewById(R.id.btn_add)
        rvContacts = view.findViewById(R.id.rv_contacts)
        adapter = ContactsAdapter(contactsList,this)
        rvContacts.adapter = adapter
        btnAdd.setOnClickListener {
            val name = etName.text.toString()
            val phone = "+2"+etPhone.text.toString()
            val description = etDescription.text.toString()
            val contact = ContactData(getRandomColor(),name,phone,description)
            Log.e("contact","$contact")
            if(name.isNotEmpty() && phone.isNotEmpty() && description.isNotEmpty()) {
                contactsList.add(contact)
                adapter.notifyDataSetChanged()
                etName.setText("")
                etPhone.setText("")
                etDescription.setText("")
            }
        }
    }
    private fun getRandomColor(): String {
        val random = Random()
        val color = Color.argb(56, random.nextInt(156), random.nextInt(256), random.nextInt(256))
        return String.format("#%06X", 0xFFFFFF and color)
    }

    override fun onContactClick(contact: ContactData, position: Int) {
        onItemClick.onItemClick(contact)
    }

    interface OnItemClick{
        fun onItemClick(contact: ContactData)
    }

}