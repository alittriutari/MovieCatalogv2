package com.appkey.moviecatalog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.ViewHolder> {

    private ArrayList<TvShow> listTvShow;

    public TvShowAdapter(ArrayList<TvShow> listTvShow) {
        this.listTvShow = listTvShow;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tv_show, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TvShow tvShow = listTvShow.get(position);
        holder.txtTVTitle.setText(tvShow.getJudul());
        holder.txtTVDesc.setText(tvShow.getDeskripsi());
        Glide.with(holder.itemView.getContext()).load(tvShow.getPoster()).into(holder.imgTVPoster);
    }

    @Override
    public int getItemCount() {
        return listTvShow.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivTVShowPoster)
        ImageView imgTVPoster;
        @BindView(R.id.tvTVShowTitle)
        TextView txtTVTitle;
        @BindView(R.id.tvTVShowDesc)
        TextView txtTVDesc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
