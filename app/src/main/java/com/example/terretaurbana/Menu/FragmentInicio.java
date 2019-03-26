package com.example.terretaurbana.Menu;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.terretaurbana.Modelos.Noticia;
import com.example.terretaurbana.R;
import com.example.terretaurbana.Recyclers.NoticiasAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class FragmentInicio extends Fragment
{
    private RecyclerView mList;
    private LinearLayoutManager linearLayoutManager;
    //private DividerItemDecoration dividerItemDecoration;
    private ArrayList<Noticia> noticiasList;
    private RecyclerView.Adapter adapter;

    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference databaseReference;
    public ValueEventListener valueEventListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_menu_inicio, container, false);

        FirebaseApp.initializeApp(getContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Noticias");

        mList = view.findViewById(R.id.recyclerview_menu_inicio);

        noticiasList = new ArrayList<>();

        cargarEventosFireBase();
        mostrarRecycler(noticiasList);

        return view;
    }

    private void mostrarRecycler(ArrayList<Noticia> lista_ev)
    {
        adapter = new NoticiasAdapter(getContext(), lista_ev);

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
                noticiasList.clear();

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
        noticiasList.add(dataSnapshot.getValue(Noticia.class));

        mostrarRecycler(noticiasList);
    }
}
