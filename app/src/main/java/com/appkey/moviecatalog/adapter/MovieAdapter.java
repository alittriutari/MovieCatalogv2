package com.appkey.moviecatalog.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appkey.moviecatalog.R;
import com.appkey.moviecatalog.model.Movie;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private ArrayList<Movie> listMovie;
    private SelectedMovie selectedMovie;

    public MovieAdapter(ArrayList<Movie> listMovie, SelectedMovie selectedMovie) {
        this.listMovie = listMovie;
        this.selectedMovie = selectedMovie;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = listMovie.get(position);
        holder.txtMovieTitle.setText(movie.getTitle());
        holder.txtMovieDesc.setText(movie.getDescription());
        Glide.with(holder.itemView.getContext()).load(movie.getPoster()).into(holder.imgMoviePoster);
    }


    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivMoviePoster)
        ImageView imgMoviePoster;
        @BindView(R.id.tvMovieTitle)
        TextView txtMovieTitle;
        @BindView(R.id.tvMovieDesc)
        TextView txtMovieDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> selectedMovie.selectedMovie(listMovie.get(getAdapterPosition())));
        }
    }

    public interface SelectedMovie {
        void selectedMovie(Movie movie);
    }
}
