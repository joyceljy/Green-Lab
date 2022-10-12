package com.codingwithmitch.navigationcomponentsexample


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation


class VideoSelectionFragment : Fragment() {
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //set navigation controller
        navController = Navigation.findNavController(view)

        //create list view items
        var lv = view?.findViewById<ListView>(R.id.listview_videolist)
        val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1,listOf("video1", "video2","video3"))
        lv?.adapter = adapter
        lv.onItemClickListener = OnItemClickListener { adapterView, view, i, l ->
            //get clicked item
            var itemName=lv.adapter.getItem(i)
            Log.d("myTag", "Item= $itemName");
            //create data bundle
            val bundle = bundleOf(
                "item" to itemName
            )
            //navigate to video page
            navController!!.navigate(R.id.action_VideoSelectionFragment_to_VideoFragment,bundle)
        }

    }


}
