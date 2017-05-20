package com.example.thiagohenry.tcc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thiagohenry on 16/04/17.
 */
public class RequestSectionsPageAdapter extends FragmentPagerAdapter{

    private final List<Fragment>    requestFragmentList       = new ArrayList<>();
    private final List<String>      requestFragmentTitleList  = new ArrayList<>();

    public void addFragment(Fragment fragment, String title){
        requestFragmentList.add(fragment);
        requestFragmentTitleList.add(title);
    }

    public RequestSectionsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public CharSequence getPageTitle(int position){
        return requestFragmentTitleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return requestFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return requestFragmentList.size();
    }
}
