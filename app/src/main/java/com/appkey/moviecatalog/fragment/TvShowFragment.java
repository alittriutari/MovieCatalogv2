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

import com.appkey.moviecatalog.activity.DetailTvShowActivity;
import com.appkey.moviecatalog.R;
import com.appkey.moviecatalog.adapter.TvShowAdapter;
import com.appkey.moviecatalog.model.TvShow;

import java.util.ArrayList;

public class TvShowFragment extends Fragment implements TvShowAdapter.SelectedTvShow{

    private ArrayList<TvShow> list = new ArrayList<>();
    RecyclerView recyclerView;

    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerview_tvshow);
        recyclerView.setHasFixedSize(true);

        list.addAll(getTvShow());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TvShowAdapter tvShowAdapter = new TvShowAdapter(list, this);
        recyclerView.setAdapter(tvShowAdapter);
    }

    public ArrayList<TvShow> getTvShow() {
        String[] dataTitle = getResources().getStringArray(R.array.data_tvshow_title);
        String[] dataDesc = getResources().getStringArray(R.array.data_tvshow_desc);
        TypedArray dataPoster = getResources().obtainTypedArray(R.array.data_tvshow_poster);
        ArrayList<TvShow> listTvShow = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            TvShow tvShow = new TvShow();
            tvShow.setJudul(dataTitle[i]);
            tvShow.setDeskripsi(dataDesc[i]);
            tvShow.setPoster(dataPoster.getResourceId(i, -1));
            list.add(tvShow);
        }
        return listTvShow;
    }

    @Override
    public void selectedTvShow(TvShow tvShow) {
        Intent intent = new Intent(getActivity(), DetailTvShowActivity.class);
        intent.putExtra("tvshow", tvShow);
        startActivity(intent);
    }
}
