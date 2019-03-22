package com.example.terretaurbana.Menu;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.terretaurbana.Menu.TabsResultados.PageAdapterResultados;
import com.example.terretaurbana.R;

public class FragmentResultados extends Fragment
{
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    TabLayout tabs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_menu_resultados, container, false);

        drawerLayout = (DrawerLayout) view.findViewById(R.id.drawerLayout);
        //toolbar = (Toolbar) view.findViewById(R.id.toolBar);

        //setSupportActionBar(toolbar);
        //ActionBar actionBar = getActivity().getSupportActionBar();

        //actionBar.setHomeAsUpIndicator(android.R.drawable.ic_menu_gallery);
        //actionBar.setDisplayHomeAsUpEnabled(true);

        tabs = (TabLayout) view.findViewById(R.id.tablayout);
        tabs.addTab(tabs.newTab().setText("Choreo"));
        tabs.addTab(tabs.newTab().setText("Battles"));

        final ViewPager mviewPager = (ViewPager) view.findViewById(R.id.viewpager);
        final PageAdapterResultados adapter = new PageAdapterResultados(getFragmentManager(), tabs.getTabCount());
        mviewPager.setAdapter(adapter);
        mviewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                mviewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        return view;
    }
}
