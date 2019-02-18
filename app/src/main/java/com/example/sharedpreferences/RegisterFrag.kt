package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.registration.*
import kotlinx.android.synthetic.main.registration.view.*

class RegisterFrag:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v = inflater.inflate(R.layout.registration, container, false)
        v.btnregregister.setOnClickListener {
            if(validations(v)) {
                var spf = activity!!.getSharedPreferences("userdata", Context.MODE_PRIVATE)

                var spe: SharedPreferences.Editor =spf.edit()
                    spe.putString("uname", v.edtregusername.text.toString())
                spe.putString("pass", v.edtregpassword.text.toString())
                spe.putString("email", v.edtregemail.text.toString())
                spe.putString("mobile", v.edtregmobile.text.toString())
                spe.commit()

                var fmanager = activity?.supportFragmentManager
                var ftransaction = fmanager?.beginTransaction()
                ftransaction?.replace(R.id.frame1, LoginFrag())
                ftransaction?.commit()
            }
        }
        return v;

    }
  fun validations(v:View):Boolean{
      var msg=""
      if (v.edtregusername.text.length==0)
      {
          msg="Please enter user name"
      }
      if (v.edtregpassword.text.length==0)
      {
          msg="Please enter password"
      }
      if (v.edtregemail.text.length==0)
      {
          msg="please enter password"
      }
      if (v.edtregmobile.text.length==0)
      {
          msg="Please enter mobile number"
      }
      if (msg.equals(""))
      {
          return true
      }
      else
      {
          Toast.makeText(activity,msg,Toast.LENGTH_LONG).show()
          return false
      }
  }
}