package com.example.thiagohenry.tcc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thiagohenry on 16/04/17.
 */
public class VendasSectionsPageAdapter extends FragmentPagerAdapter{

    private final List<Fragment>    vendaFragmentList       = new ArrayList<>();
    private final List<String>      vendaFragmentTitleList  = new ArrayList<>();

    public void addFragment(Fragment fragment, String title){
        vendaFragmentList.add(fragment);
        vendaFragmentTitleList.add(title);
    }

    public VendasSectionsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public CharSequence getPageTitle(int position){
        return vendaFragmentTitleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return vendaFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return vendaFragmentList.size();
    }
}
