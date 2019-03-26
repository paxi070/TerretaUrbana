package com.example.terretaurbana.Menu;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.terretaurbana.Menu.TabsHorario.PageAdapterHorario;
import com.example.terretaurbana.Modelos.Jueces;
import com.example.terretaurbana.Modelos.Noticia;
import com.example.terretaurbana.R;
import com.example.terretaurbana.Recyclers.JuecesAdapter;
import com.example.terretaurbana.Recyclers.NoticiasAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class FragmentArtistsStaff extends Fragment
{
    private RecyclerView mList;
    private LinearLayoutManager linearLayoutManager;
    //private DividerItemDecoration dividerItemDecoration;
    private ArrayList<Jueces> juecesList;
    private RecyclerView.Adapter adapter;

    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference databaseReference;
    public ValueEventListener valueEventListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_menu_artistsstaff, container, false);

        FirebaseApp.initializeApp(getContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Jueces");

        mList = view.findViewById(R.id.recyclerview_menu_artistas);

        juecesList = new ArrayList<>();

        cargarEventosFireBase();
        mostrarRecycler(juecesList);

        return view;
    }

    private void mostrarRecycler(ArrayList<Jueces> lista_ev)
    {
        adapter = new JuecesAdapter(getContext(), lista_ev);

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());
        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        //mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);
    }

    private void cargarEventosFireBase()
    {
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        final Timer t = new Timer();
        t.schedule(new TimerTask()
        {
           public void run()
           {
               progressDialog.dismiss();
               t.cancel();
           }
        }, 2000);

        valueEventListener = new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                juecesList.clear();

                for (DataSnapshot dataSnapshotEventos: dataSnapshot.getChildren())
                {
                    cargarRecyclerViewEvento(dataSnapshotEventos);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                Log.e("ActivityParte2","DATABASE ERROR");
            }
        };

        databaseReference.addValueEventListener(valueEventListener);
    }

    private void cargarRecyclerViewEvento(DataSnapshot dataSnapshot)
    {
        juecesList.add(dataSnapshot.getValue(Jueces.class));

        mostrarRecycler(juecesList);
    }
}