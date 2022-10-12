package com.codingwithmitch.navigationcomponentsexample


import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices


class HomeFragment : Fragment(), View.OnClickListener, LocationListener {
    lateinit var username: String
    lateinit var email: String
    lateinit var address: String
    lateinit var gender: String
    lateinit var phone: String

    lateinit var navController: NavController

    private lateinit var locationManager: LocationManager
    private lateinit var tvGpsLocation: TextView
    private val locationPermissionCode = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        username = arguments!!.getString("usernameLogin") as String
        email = arguments!!.getString("email") as String
        address = arguments!!.getString("address") as String
        gender = arguments!!.getString("gender") as String
        phone = arguments!!.getString("phone") as String

    }

    private fun getLocation() {
        Log.d("myTag", "Clicked get location");
        locationManager = activity?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if ((ContextCompat.checkSelfPermission(context!!, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(activity!!, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), locationPermissionCode)
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this)
    }
    override fun onLocationChanged(location: Location) {
        Log.d("myTag", "Location changed");
        val tvGpsLocation= "Your current location:\n Latitude: " + location.latitude + " , Longitude: " + location.longitude
        view?.findViewById<TextView>(R.id.text_view_location)?.text =tvGpsLocation
    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun onProviderEnabled(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onProviderDisabled(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == locationPermissionCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(activity, "Permission Granted", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(activity, "Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
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
        val phoneShow = "Phone Number is $phone"
        view.findViewById<TextView>(R.id.text_view_phone).text = phoneShow
        val genderShow = "Gender is $gender"
        view.findViewById<TextView>(R.id.text_view_gender).text = genderShow

        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.video_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.bt_location).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.video_btn -> navController!!.navigate(R.id.action_HomeFragment_to_VideoSelectionFragment)
            R.id.bt_location->getLocation()
        }
    }



}
