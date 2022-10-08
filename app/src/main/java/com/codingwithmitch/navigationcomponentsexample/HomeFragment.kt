package com.codingwithmitch.navigationcomponentsexample


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.properties.Delegates


class HomeFragment : Fragment() {
    lateinit var username: String
    lateinit var email: String
    lateinit var address: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        username = arguments!!.getString("usernameLogin") as String
        email = arguments!!.getString("email") as String
        address = arguments!!.getString("address") as String
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //show passed data on page
        val nameShow = "$username"
        view.findViewById<TextView>(R.id.text_view_username).text = nameShow
        val emailShow = "Email is $email"
        view.findViewById<TextView>(R.id.text_view_email).text = emailShow
        val addressShow = "Address is $address"
        view.findViewById<TextView>(R.id.text_view_address).text = addressShow
    }


}
