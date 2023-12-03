package com.jude.addshowf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewAnime> {


    private Context context;

    private ArrayList<Anime> list;

    public Adapter(Context context, ArrayList<Anime> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewAnime onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new ViewAnime(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAnime holder, int position) {

        Anime anime = list.get(position);
        holder.animename.setText(anime.getName());
        holder.animeyear.setText(anime.getYear());
        holder.animerate.setText((int) anime.getRate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewAnime extends RecyclerView.ViewHolder{

        TextView animename, animeyear, animerate;

        public ViewAnime(@NonNull View itemView) {
            super(itemView);

            animename = itemView.findViewById(R.id.SAnimeName);
            animeyear = itemView.findViewById(R.id.SAnimeRelease);
            animerate = itemView.findViewById(R.id.SAnimeRating);

        }
    }
}
