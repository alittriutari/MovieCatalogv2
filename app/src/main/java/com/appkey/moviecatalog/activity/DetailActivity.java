package com.appkey.moviecatalog.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.appkey.moviecatalog.model.Movie;
import com.appkey.moviecatalog.R;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {
    @BindView(R.id.ivImage)
    ImageView imgPoster;
    @BindView(R.id.tvTitle)
    TextView txtTitle;
    @BindView(R.id.tvDesc)
    TextView txtDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Movie movie = getIntent().getParcelableExtra("movie");
        txtTitle.setText(movie.getJudul());
        txtDesc.setText(movie.getDeskripsi());
        Glide.with(getApplicationContext()).load(movie.getPoster()).into(imgPoster);
    }
}
