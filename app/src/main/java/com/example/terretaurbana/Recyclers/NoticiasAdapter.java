package com.example.terretaurbana.Recyclers;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.terretaurbana.Modelos.Noticia;
import com.example.terretaurbana.R;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import java.io.File;
import java.util.List;

public class NoticiasAdapter extends RecyclerView.Adapter<NoticiasAdapter.ViewHolder>
{
    private Context context;
    private List<Noticia> list;
    private Activity activity;

    public NoticiasAdapter(Context context, List<Noticia> list)
    {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.recylcerview_menu_inicio_line, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        Noticia noticia = list.get(position);

        holder.textview_inicio_descripcion.setText(noticia.getDescripcion());

        holder.cargarImagen(noticia.getImagen());
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textview_inicio_descripcion;
        public ImageView imageView_inicio_photo;
        StorageReference storageRf;

        public ViewHolder(View view)
        {
            super(view);
            imageView_inicio_photo      = (ImageView) view.findViewById(R.id.imageView_inicio_photo);
            textview_inicio_descripcion = (TextView) view.findViewById(R.id.textview_inicio_descripcion);
            storageRf = FirebaseStorage.getInstance().getReference();
        }

        private void cargarImagen(String nombre)
        {
            storageRf.child("imagenes/" + nombre).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>()
            {
                @Override
                public void onSuccess(Uri uri)
                {
                    Glide.with(itemView).load(uri.toString()).into(imageView_inicio_photo);
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
