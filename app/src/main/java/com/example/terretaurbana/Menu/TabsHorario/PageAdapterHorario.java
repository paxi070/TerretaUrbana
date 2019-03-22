package com.example.terretaurbana.Menu.TabsHorario;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PageAdapterHorario extends FragmentStatePagerAdapter
{
    int NumOfTabs;
    int pos;

    public PageAdapterHorario(FragmentManager fm, int NumOfTabs)
    {
        super(fm);
        this.NumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                FragmentHorarioAbr27 fragmentHorarioAbr27 = new FragmentHorarioAbr27();
                return fragmentHorarioAbr27;
            case 1:
                FragmentHorarioAbr28 fragmentHorarioAbr28 = new FragmentHorarioAbr28();
                return fragmentHorarioAbr28;
            case 2:
                FragmentHorarioMay10 fragmentHorarioMay10 = new FragmentHorarioMay10();
                return fragmentHorarioMay10;
            case 3:
                FragmentHorarioMay11 fragmentHorarioMay11 = new FragmentHorarioMay11();
                return fragmentHorarioMay11;
            case 4:
                FragmentHorarioMay12 fragmentHorarioMay12 = new FragmentHorarioMay12();
                return fragmentHorarioMay12;
            default:
                return null;
        }

    }

    @Override
    public int getCount()
    {
        return NumOfTabs;
    }
}

