package com.pinicius.android.cas2016.session.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pinicius.android.cas2016.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pinicius on 28/11/16.
 */

public class SessionsFragment extends Fragment {
    public static final String TAG = SessionsFragment.class.getSimpleName();

    private TabLayout tabs;
    private ViewPager viewPager;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        configureHomePager();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sessions, container, false);
        tabs = (TabLayout) v.findViewById(R.id.tabs);
        viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        return v;
    }

    private void configureHomePager() {
        SessionsPagerAdapter pagerAdapter = new SessionsPagerAdapter(getChildFragmentManager());
        pagerAdapter.addFragment(new DayOneSessionsFragment(), getString(R.string.tab_one_title));
        pagerAdapter.addFragment(new DayTwoSessionsFragment(), getString(R.string.tab_two_title));
        viewPager.setAdapter(pagerAdapter);
        tabs.setTabMode(TabLayout.MODE_FIXED);
        tabs.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(0);
    }

    class SessionsPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragments = new ArrayList<>();
        private final List<String> fragmentTitles = new ArrayList<>();

        public SessionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            fragments.add(fragment);
            fragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitles.get(position);
        }

    }
}
