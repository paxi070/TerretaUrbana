package com.example.terretaurbana.Menu.TabsCoreo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.terretaurbana.Menu.TabsHorario.FragmentHorarioAbr27;
import com.example.terretaurbana.Menu.TabsHorario.FragmentHorarioAbr28;
import com.example.terretaurbana.Menu.TabsHorario.FragmentHorarioMay10;
import com.example.terretaurbana.Menu.TabsHorario.FragmentHorarioMay11;
import com.example.terretaurbana.Menu.TabsHorario.FragmentHorarioMay12;

public class PageAdapterResultadosCoreo extends FragmentStatePagerAdapter
{
    int NumOfTabs;
    int pos;

    public PageAdapterResultadosCoreo(FragmentManager fm, int NumOfTabs)
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
                FragmentResultadosCoreoInfantil fragmentResultadosCoreoInfantil = new FragmentResultadosCoreoInfantil();
                return fragmentResultadosCoreoInfantil;
            case 1:
                FragmentResultadosCoreoJunior fragmentResultadosCoreoJunior = new FragmentResultadosCoreoJunior();
                return fragmentResultadosCoreoJunior;
            case 2:
                FragmentResultadosCoreoAbsoluta fragmentResultadosCoreoAbsoluta = new FragmentResultadosCoreoAbsoluta();
                return fragmentResultadosCoreoAbsoluta;
            case 3:
                FragmentResultadosCoreoParejas fragmentResultadosCoreoParejas = new FragmentResultadosCoreoParejas();
                return fragmentResultadosCoreoParejas;
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

