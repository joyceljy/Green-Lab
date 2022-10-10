package com.codingwithmitch.navigationcomponentsexample


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


class VideoSelectionFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val users = arrayOf(
            "Virat Kohli", "Rohit Sharma", "Steve Smith",
            "Kane Williamson", "Ross Taylor"
        )
        val arrayAdapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, users)
        var vListView = view?.findViewById<ListView>(R.id.listview_videolist)
        if (vListView != null) {
            vListView.adapter = arrayAdapter
        }
        if (vListView != null) {
            vListView.onItemClickListener =
                AdapterView.OnItemClickListener { adapterView, view, position, id ->
                    val selectedItem = adapterView.getItemAtPosition(position) as String
                    val itemIdAtPos = adapterView.getItemIdAtPosition(position)
                    Toast.makeText(
                        activity,
                        "click item $selectedItem its position $itemIdAtPos",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }
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

    }


}
