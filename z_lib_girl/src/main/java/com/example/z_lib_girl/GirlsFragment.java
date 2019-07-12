package com.example.z_lib_girl;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.z_lib_common.base.BaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class GirlsFragment extends BaseFragment {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment GirlsFragment.
     */
    public static GirlsFragment newInstance() {
        return new GirlsFragment();
    }


    public GirlsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.gril_fragment_girls, container, false);
    }


}
