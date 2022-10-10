package com.codingwithmitch.navigationcomponentsexample


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlin.properties.Delegates
import android.widget.Toast


class SignInFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    lateinit var username: String
    lateinit var password: String
    lateinit var email: String
    lateinit var address: String
    lateinit var gender: String
    lateinit var phone: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        username = arguments!!.getString("username") as String
        password = arguments!!.getString("password") as String
        email = arguments!!.getString("email") as String
        address = arguments!!.getString("address") as String
        gender = arguments!!.getString("gender") as String
        phone = arguments!!.getString("phone") as String
        Log.d("myTag", "UserName= $username");
        Log.d("myTag", "Password= $password");
        Log.d("myTag", "Email= $email");
        Log.d("myTag", "Address= $address");
        Log.d("myTag", "Phone= $phone");
        Log.d("myTag", "Gender= $gender");

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.signin_btn2).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val signInNameStr = name_in_text.text.toString()
        val signInPasswordStr = password_in_text.text.toString()
        val bundle = bundleOf(
            "usernameLogin" to signInNameStr,
            "email" to email,
            "address" to address,
            "phone" to phone,
            "gender" to gender
        )
        when(v!!.id){

            R.id.signin_btn2 -> {
                //check whether username and password matches
                if(signInNameStr == username && signInPasswordStr == password){
                    navController!!.navigate(R.id.action_SignInFragment_to_HomeFragment,bundle)
                }else{
                    Toast.makeText(activity, "Username or Password Error", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }


}
