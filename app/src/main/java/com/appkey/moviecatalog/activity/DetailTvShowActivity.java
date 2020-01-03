package com.appkey.moviecatalog.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.appkey.moviecatalog.R;
import com.appkey.moviecatalog.model.TvShow;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailTvShowActivity extends AppCompatActivity {

    @BindView(R.id.ivImage)
    ImageView imgPoster;
    @BindView(R.id.tvTitle)
    TextView txtTitle;
    @BindView(R.id.tvDesc)
    TextView txtDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);
        ButterKnife.bind(this);

        TvShow tvShow = getIntent().getParcelableExtra("tvshow");
        txtTitle.setText(tvShow.getJudul());
        txtDesc.setText(tvShow.getDeskripsi());
        Glide.with(getApplicationContext()).load(tvShow.getPoster()).into(imgPoster);
    }
}
