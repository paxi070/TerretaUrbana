package com.example.terretaurbana.Recyclers;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.terretaurbana.Modelos.Jueces;
import com.example.terretaurbana.Modelos.Noticia;
import com.example.terretaurbana.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class JuecesAdapter extends RecyclerView.Adapter<JuecesAdapter.ViewHolder>
{
    private Context context;
    private List<Jueces> list;
    private Activity activity;

    public JuecesAdapter(Context context, List<Jueces> list)
    {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.recylcerview_menu_jueces_line, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        Jueces juez = list.get(position);

        //holder.textview_jueces_nombre.setText(juez.getNombre());

        holder.cargarImagen(juez.getImagen());
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textview_jueces_nombre;
        public ImageView imageView_jueces_photo;
        StorageReference storageRf;

        public ViewHolder(View view)
        {
            super(view);
            imageView_jueces_photo = (ImageView) view.findViewById(R.id.imageView_jueces_photo);
            //textview_jueces_nombre = (TextView) view.findViewById(R.id.textview_jueces_nombre);
            storageRf = FirebaseStorage.getInstance().getReference();
        }

        private void cargarImagen(String nombre)
        {
            storageRf.child("imagenes/" + nombre).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>()
            {
                @Override
                public void onSuccess(Uri uri)
                {
                    Glide.with(itemView).load(uri.toString()).into(imageView_jueces_photo);
                }
            }).addOnFailureListener(new OnFailureListener()
            {
                @Override
                public void onFailure(@NonNull Exception exception)
                {
                    // Handle any errors
                }
            });
        }
    }
}
