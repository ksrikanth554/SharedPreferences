package com.example.sharedpreferences

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.loginfrag.*
import kotlinx.android.synthetic.main.loginfrag.view.*
import kotlinx.android.synthetic.main.registration.*
import kotlinx.android.synthetic.main.welcomefrag.*

class LoginFrag:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v = inflater.inflate(R.layout.loginfrag, container, false)
        v.btnlogregister.setOnClickListener {
            var fmanager=activity?.supportFragmentManager
            var ftransaction=fmanager?.beginTransaction()
            ftransaction?.replace(R.id.frame1,RegisterFrag())
            ftransaction?.commit()
        }
        v.btnloign.setOnClickListener {
            var spf=activity?.getSharedPreferences("userdata",Context.MODE_PRIVATE)
            var user_spf=spf?.getString("uname","no_value")
            var pass_spf=spf?.getString("pass","no value")

            if ((v.edtlogusername.text.toString().equals(user_spf))&&(v.edtloguserpassword.text.toString().equals(pass_spf)))
            {
                var fmanager=activity?.supportFragmentManager
                var ftransaction=fmanager?.beginTransaction()
                ftransaction?.replace(R.id.frame1,WelcomeFrag())
                ftransaction?.commit()

            }
            else
            {
                Toast.makeText(activity,"Please enter valid credentials",Toast.LENGTH_LONG).show()
            }
        }


        return v;
    }
}