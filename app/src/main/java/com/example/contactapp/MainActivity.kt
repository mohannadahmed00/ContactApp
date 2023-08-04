package com.example.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(),ContactsFragment.OnItemClick {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ContactsFragment(this)).commit()
    }

    override fun onItemClick(contact: ContactData) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ContactDetailsFragment(contact)).addToBackStack(null).commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount>0){
            supportFragmentManager.popBackStack()
        }else{
            super.onBackPressed()
        }

    }

}