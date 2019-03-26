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

import com.example.terretaurbana.Menu.TabsHorario.PageAdapterHorario;
import com.example.terretaurbana.R;

public class FragmentResultadosCoreo extends Fragment
{
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    TabLayout tabs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_menu_resultados_coreo, container, false);

        drawerLayout = (DrawerLayout) view.findViewById(R.id.drawerLayout);
        //toolbar = (Toolbar) view.findViewById(R.id.toolBar);

        //setSupportActionBar(toolbar);
        //ActionBar actionBar = getActivity().getSupportActionBar();

        //actionBar.setHomeAsUpIndicator(android.R.drawable.ic_menu_gallery);
        //actionBar.setDisplayHomeAsUpEnabled(true);

        tabs = (TabLayout) view.findViewById(R.id.tablayout);
        tabs.addTab(tabs.newTab().setText("INFANTIL"));
        tabs.addTab(tabs.newTab().setText("JUNIOR"));
        tabs.addTab(tabs.newTab().setText("ABSOLUTA"));
        tabs.addTab(tabs.newTab().setText("PAREJAS"));

        final ViewPager mviewPager = (ViewPager) view.findViewById(R.id.viewpager);
        final PageAdapterHorario adapter = new PageAdapterHorario(getFragmentManager(), tabs.getTabCount());
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
