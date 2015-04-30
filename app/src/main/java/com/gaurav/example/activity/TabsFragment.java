package com.gaurav.example.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.gaurav.example.R;

public class TabsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String TAG = "tabsFragment";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private LinearLayout tabsLayout;
    private ViewPager mViewPager;
    private AppSectionsPagerAdapter mAppSectionsPagerAdapter;
    private PagerSlidingTabStrip tabs;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PageSlidingTabStripFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TabsFragment newInstance(String param1, String param2) {
        TabsFragment fragment = new TabsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public TabsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mainView = inflater.inflate(R.layout.fragment_tabs, container, false);
        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getActivity().getSupportFragmentManager(), getActivity());

        mViewPager = (ViewPager) mainView.findViewById(R.id.action_bar_tabs_view_pager);
        mViewPager.setAdapter(mAppSectionsPagerAdapter);

        tabs = (PagerSlidingTabStrip) mainView.findViewById(R.id.action_bar_tabs);
        tabs.setViewPager(mViewPager);
        tabs.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                for(int i=0; i < tabsLayout.getChildCount(); i++){
                    TextView tab = (TextView) tabsLayout.getChildAt(i);
                    if(i == position){
                        tab.setTextColor(Color.WHITE);
                        tab.setSelected(true);
                    } else {
                        tab.setTextColor(Color.GRAY);
                        tab.setSelected(false);
                    }
                }
            }
        });

        tabs.setTextSize(40);
        tabs.setTextColorResource(R.color.tab_text);

        setUpTabStrip();
        return mainView;
    }

    private void setUpTabStrip(){
        // Set first tab selected
        tabsLayout = ((LinearLayout) tabs.getChildAt(0));
        for(int i=0; i < tabsLayout.getChildCount(); i++){
            TextView tab = (TextView) tabsLayout.getChildAt(i);

            if(i == 0){
                tab.setTextColor(Color.WHITE);
                tab.setSelected(true);
            } else {
                tab.setTextColor(Color.GRAY);
                tab.setSelected(false);
            }
        }
    }

    public class AppSectionsPagerAdapter extends FragmentStatePagerAdapter {

        private final Context context;

        public AppSectionsPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new Tab1Fragment();
                case 1:
                    return new Tab2Fragment();
                case 2:
                    return new Tab3Fragment();
            }

            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return context.getString(R.string.tab1_title);
                case 1:
                    return context.getString(R.string.tab2_title);
                case 2:
                    return context.getString(R.string.tab3_title);
            }
            return null;
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
