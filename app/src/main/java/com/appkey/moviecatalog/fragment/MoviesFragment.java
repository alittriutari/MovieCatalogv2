package com.appkey.moviecatalog.fragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appkey.moviecatalog.R;
import com.appkey.moviecatalog.activity.DetailActivity;
import com.appkey.moviecatalog.adapter.MovieAdapter;
import com.appkey.moviecatalog.model.Movie;

import java.util.ArrayList;

public class MoviesFragment extends Fragment implements MovieAdapter.SelectedMovie {

    private ArrayList<Movie> list = new ArrayList<>();
    RecyclerView recyclerView;

    public MoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerview_movies);
        recyclerView.setHasFixedSize(true);

        list.addAll(getMovie());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MovieAdapter movieAdapter = new MovieAdapter(list, this);
        recyclerView.setAdapter(movieAdapter);
    }

    public ArrayList<Movie> getMovie() {
        String[] dataTitle = getResources().getStringArray(R.array.data_title);
        String[] dataDesc = getResources().getStringArray(R.array.data_desc);
        TypedArray dataPoster = getResources().obtainTypedArray(R.array.data_poster);
        ArrayList<Movie> listMovie = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setJudul(dataTitle[i]);
            movie.setDeskripsi(dataDesc[i]);
            movie.setPoster(dataPoster.getResourceId(i, -1));
            list.add(movie);
        }
        return listMovie;
    }

    @Override
    public void selectedMovie(Movie movie) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("movie", movie);
        startActivity(intent);
    }
}
