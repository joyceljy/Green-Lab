package com.codingwithmitch.navigationcomponentsexample


import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_sign_up.*


class SignUpFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.signup_btn2).setOnClickListener(this)
    }


    override fun onClick(v: View?) {


        when(v!!.id){
            R.id.signup_btn2 -> {
                val nameStr = name_up_text.text.toString()
                val passwordStr = password_up_text.text.toString()
                val emailStr = email_text.text.toString()
                val addressStr = address_text.text.toString()
                val phoneStr = phone_text.text.toString()
                val genderStr = gender_text.text.toString()

                val bundle = bundleOf(
                    "username" to nameStr,
                    "password" to passwordStr,
                    "email" to emailStr,
                    "address" to addressStr,
                    "gender" to genderStr,
                    "phone" to phoneStr
                )
                navController!!.navigate(R.id.action_SignUpFragment_to_SignInFragment,bundle)
            }
        }
    }
}
