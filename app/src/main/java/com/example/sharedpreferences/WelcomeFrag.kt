package com.example.sharedpreferences

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.loginfrag.view.*
import kotlinx.android.synthetic.main.welcomefrag.*
import kotlinx.android.synthetic.main.welcomefrag.view.*

class WelcomeFrag:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v = inflater.inflate(R.layout.welcomefrag, container, false)
        var spf=activity?.getSharedPreferences("userdata",Context.MODE_PRIVATE)
        var user_spf=spf?.getString("uname","no_value")
        v.txtwelcome.text="Welcome: $user_spf"
        return v;
    }
}