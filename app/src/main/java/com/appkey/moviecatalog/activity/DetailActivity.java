package com.appkey.moviecatalog.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
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
    @BindView(R.id.scrollview)
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Movie movie = getIntent().getParcelableExtra("movie");
        txtTitle.setText(movie.getTitle());
        txtDesc.setText(movie.getDescription());
        Glide.with(getApplicationContext()).load(movie.getPoster()).into(imgPoster);
    }
}
