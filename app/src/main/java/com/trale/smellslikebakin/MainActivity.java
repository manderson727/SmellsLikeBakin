package com.trale.smellslikebakin;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListFragment.OnRecipeSelectedInterface {
    public static final String LIST_FRAGMENT = "list_fragment";
    public static final String VIEWPAGER_FRAGMENT = "viewpager_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Activity Life Cycle - onCreate, onStart, onResume, onPause, onStop, onDestroy
        //Fragments have all activity life cycles plus the 5 below.
        //Fragment Life Cycle
        //1. onAttach()
            //called when a fragment has first been associated with it's Activity
            //getActivity() will return null if it's called before onAttach()
        //2. onCreateView()
            //set up the view for our fragments
                //inflate the view, do any setup then return it
        //3. onActivityCreated()
            //this is called when the Activity's onCreate() method has returned
            //if work has to be done AFTER the Activity is intialized, but before the user sees the Activity... work should be done here
        //4. onDestroyView()
            //Called when fragmented view is being destroyed.
            //if any cleanup resources associated with fragments view are needed... do it here
        //5. onDetach()
            //When the fragment is being removed from the Activity
            //After onDetach(), any calls to getActivity() will return null

        //Regular fragments should be paired with activity class, support fragments should be paired with AppCompatActivity

        ListFragment savedFragment = (ListFragment) getSupportFragmentManager()
                //.findFragmentById(R.id.placeHolder);
                .findFragmentByTag(LIST_FRAGMENT);
        if (savedFragment == null) {
            ListFragment fragment = new ListFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.placeHolder, fragment, LIST_FRAGMENT);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onListRecipeSelected(int index) {
        ViewPagerFragment fragment = new ViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeHolder, fragment, VIEWPAGER_FRAGMENT);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
