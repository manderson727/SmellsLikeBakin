package com.trale.smellslikebakin;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

/**
 * Created by Mike on 1/1/2018.
 */

public class ListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //The view returned by this method is what will displayed by our Fragment
        //return super.onCreate(inflater, container, savedInstanceState);
        //We need to return a view that represents our fragment_list layout
        //The LayoutInflater is used to turn XML layouts to Views
        //second argument - view group - where our new view gets added
        //third argument - determines whether or not we attached this View to the ViewGroup provided in the second parameter
            //If not set to false, it'll be added twice and we'll get an error.
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        return view;
    }
}
