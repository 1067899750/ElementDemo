package com.example.z_lib_video;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




/**
 *
 * Description
 * Author puyantao
 * Email 1067899750@qq.com
 * Date 2019/7/9 14:25
 */
public class VideoMainFragment extends Fragment {


    public VideoMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.video_fragment_main, container, false);
    }

}
