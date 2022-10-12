package com.codingwithmitch.navigationcomponentsexample


import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_video.*


class VideoFragment : Fragment(),View.OnClickListener {
    lateinit var navController: NavController
    lateinit var item: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        item = arguments!!.getString("item") as String
        Log.d("myTag", "Item= $item");


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

//    private fun playVideoFromWeb(item: String) {
//        var link1= "https://www.youtube.com/watch?v=XsX3ATc3FbA&ab_channel=HYBELABELS"
//        var link2= "https://www.youtube.com/watch?v=9DwzBICPhdM&ab_channel=HYBELABELS"
//        var link3= "https://www.youtube.com/watch?v=XsX3ATc3FbA&ab_channel=HYBELABELS"
//        var videoView = view?.findViewById<VideoView>(R.id.videoView)
//        Log.d("myTag", "Item= $item");
//        if(item=="video1"){
//            val uri: Uri=Uri.parse("https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1")
//            videoView?.setVideoURI(uri)
//        }else if (item =="video2"){
//            val uri: Uri=Uri.parse(link2)
//            videoView?.setVideoURI(uri)
//        }else{
//            val uri: Uri=Uri.parse(link3)
//            videoView?.setVideoURI(uri)
//        }
//
//        val mediaController = MediaController(activity)
//        videoView?.setMediaController(mediaController)
//        mediaController.setAnchorView(videoView)
//        videoView?.start()
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //button navigation controller
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.bt_videolist).setOnClickListener(this)

        var videoView1 = view?.findViewById<VideoView>(R.id.videoView_vv)
        Log.d("myTag", "videoView= $videoView1");
        if (item=="video1"){
            val uri: Uri = Uri.parse("https://media.geeksforgeeks.org/wp-content/uploads/20210217101214/Screenrecorder-2021-02-17-10-10-20-513.mp4?_=1")
            videoView1?.setVideoURI(uri)
        }else if(item == "video2"){
            val uri: Uri = Uri.parse("https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1")
            videoView1?.setVideoURI(uri)
        }else{
            val uri: Uri = Uri.parse("https://media.geeksforgeeks.org/wp-content/uploads/20201028015557/MVVMOutputRecording.mp4?_=1")
            videoView1?.setVideoURI(uri)
        }
        val mediaController = MediaController(activity)
        mediaController.setAnchorView(videoView1)
        mediaController.setMediaPlayer(videoView1)
        videoView1?.setMediaController(mediaController)
        videoView1?.start()
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.bt_videolist -> navController!!.navigate(R.id.action_VideoFragment_to_VideoSelectionFragment)
        }
    }


}