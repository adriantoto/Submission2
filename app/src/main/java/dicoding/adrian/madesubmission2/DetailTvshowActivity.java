package dicoding.adrian.madesubmission2;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.like.LikeButton;
import com.like.OnLikeListener;

public class DetailTvshowActivity extends AppCompatActivity {

    // Default Value
    public static final String EXTRA_TVSHOW = "extra_tvshow";

    // Data Variables Declaration
    TextView txtTitleDetailTvshow;
    TextView txtGenreDetailTvshow;
    TextView txtRuntimeDetailTvshow;
    TextView txtDirectorDetailTvshow;
    TextView txtRatingDetailTvshow;
    TextView txtOverviewDetailTvshow;
    TextView txtScoreAngkaDetailTvshow;
    ImageView posterBannerTvshow;
    ImageView posterDetailTvshow;

    // Like Button Variable
    LikeButton likeButtonTvshow;

    // URL
    String urlTrailerTvshow;

    // Button Variable Declaration
    ImageButton btnPlayTvshow;
    ImageButton btnBackTvshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tvshow);

        // TextView Layout Gradient
        TextView myBackgroundTvshow = findViewById(R.id.textView5_tvshow);
        AnimationDrawable animationDrawableTvshow = (AnimationDrawable) myBackgroundTvshow.getBackground();
        animationDrawableTvshow.setEnterFadeDuration(2000);
        animationDrawableTvshow.setExitFadeDuration(4000);
        animationDrawableTvshow.start();

        // Translucent Status Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        // Casting Data Variables
        txtTitleDetailTvshow = findViewById(R.id.txt_title_detail_tvshow);
        txtGenreDetailTvshow = findViewById(R.id.txt_genreDetail_tvshow);
        txtRuntimeDetailTvshow = findViewById(R.id.txt_runtimeDetail_tvshow);
        txtDirectorDetailTvshow = findViewById(R.id.txt_directorDetail_tvshow);
        txtRatingDetailTvshow = findViewById(R.id.txt_ratingDetail_tvshow);
        txtOverviewDetailTvshow = findViewById(R.id.txt_overviewDetail_tvshow);
        txtScoreAngkaDetailTvshow = findViewById(R.id.txt_scoreAngkaDetail_tvshow);
        posterBannerTvshow = findViewById(R.id.poster_banner_tvshow);
        posterDetailTvshow = findViewById(R.id.poster_detail_tvshow);

        // Casting Like Button Variables
        likeButtonTvshow = findViewById(R.id.star_button_tvshow);

        // Casting Button Variables
        btnPlayTvshow = findViewById(R.id.btn_play_tvshow);
        btnBackTvshow = findViewById(R.id.btn_back_tvshow);

        // Menerima intent
        final Tvshow tvshow = getIntent().getParcelableExtra(EXTRA_TVSHOW);

        // Mengisi data String
        txtTitleDetailTvshow.setText(tvshow.getTitle());
        txtGenreDetailTvshow.setText(tvshow.getGenre());
        txtRuntimeDetailTvshow.setText(tvshow.getRuntime());
        txtDirectorDetailTvshow.setText(tvshow.getDirector());
        txtRatingDetailTvshow.setText(tvshow.getRating());
        txtOverviewDetailTvshow.setText(tvshow.getOverview());
        txtScoreAngkaDetailTvshow.setText(String.valueOf(tvshow.getScore()));

        // Mengisi data image
        Glide.with(DetailTvshowActivity.this).load(tvshow.getPoster()).into(posterBannerTvshow);
        Glide.with(DetailTvshowActivity.this).load(tvshow.getPoster()).into(posterDetailTvshow);

        // Mengisi data URL Trailer
        urlTrailerTvshow = tvshow.getTrailer();

        // setOnLikeListener likeButton
        final String forToastTvshow = DetailTvshowActivity.this.getString(R.string.tv_like) + " " + tvshow.getTitle();
        likeButtonTvshow.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                Toast.makeText(DetailTvshowActivity.this, forToastTvshow, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void unLiked(LikeButton likeButton) {

            }
        });

        // setOnClickListener untuk Button Play
        btnPlayTvshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked_btn(urlTrailerTvshow);
            }
        });

        // setOnClickListener untuk Button Back
        btnBackTvshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.no_animation, R.anim.slide_down);
            }
        });

    }

    // Animation onBackPressed
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        DetailTvshowActivity.this.overridePendingTransition(R.anim.no_animation, R.anim.slide_down);
    }

    // Methods clicked_button
    public void clicked_btn(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

}
