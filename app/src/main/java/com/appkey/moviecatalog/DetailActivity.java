package com.appkey.moviecatalog;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
//        imgPoster.setImageResource(movie.getPoster());
        txtTitle.setText(movie.getJudul());
        txtDesc.setText(movie.getDeskripsi());
    }
}
