package dicoding.adrian.madesubmission2;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import dicoding.adrian.madesubmission2.R;

import com.bumptech.glide.Glide;
import com.like.LikeButton;
import com.like.OnLikeListener;

public class DetailMovieActivity extends AppCompatActivity {

    // Default Value
    public static final String EXTRA_MOVIE = "extra_movie";

    // Data Variables Declaration
    TextView txtTitleDetail;
    TextView txtGenreDetail;
    TextView txtRuntimeDetail;
    TextView txtDirectorDetail;
    TextView txtRatingDetail;
    TextView txtOverviewDetail;
    TextView txtScoreAngkaDetail;
    ImageView posterBanner;
    ImageView posterDetail;

    // Like Button Variable
    LikeButton likeButton;

    // URL
    String urlTrailer;

    // Button Variable Declaration
    ImageButton btnPlay;
    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        // TextView Layout Gradient
        TextView myBackground = findViewById(R.id.textView5);
        AnimationDrawable animationDrawable = (AnimationDrawable) myBackground.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        // Translucent Status Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        // Casting Data Variables
        txtTitleDetail = findViewById(R.id.txt_title_detail);
        txtGenreDetail = findViewById(R.id.txt_genreDetail);
        txtRuntimeDetail = findViewById(R.id.txt_runtimeDetail);
        txtDirectorDetail = findViewById(R.id.txt_directorDetail);
        txtRatingDetail = findViewById(R.id.txt_ratingDetail);
        txtOverviewDetail = findViewById(R.id.txt_overviewDetail);
        txtScoreAngkaDetail = findViewById(R.id.txt_scoreAngkaDetail);
        posterBanner = findViewById(R.id.poster_banner);
        posterDetail = findViewById(R.id.poster_detail);

        // Casting Like Button Variables
        likeButton = findViewById(R.id.star_button);

        // Casting Button Variables
        btnPlay = findViewById(R.id.btn_play);
        btnBack = findViewById(R.id.btn_back);

        // Menerima intent
        final Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        // Mengisi data String
        txtTitleDetail.setText(movie.getTitle());
        txtGenreDetail.setText(movie.getGenre());
        txtRuntimeDetail.setText(movie.getRuntime());
        txtDirectorDetail.setText(movie.getDirector());
        txtRatingDetail.setText(movie.getRating());
        txtOverviewDetail.setText(movie.getOverview());
        txtScoreAngkaDetail.setText(String.valueOf(movie.getScore()));

        // Mengisi data image
        Glide.with(DetailMovieActivity.this).load(movie.getPoster()).into(posterBanner);
        Glide.with(DetailMovieActivity.this).load(movie.getPoster()).into(posterDetail);

        // Mengisi data URL Trailer
        urlTrailer = movie.getTrailer();

        // setOnLikeListener likeButton
        final String forToast = DetailMovieActivity.this.getString(R.string.movie_like) + " " + movie.getTitle();
        likeButton.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                Toast.makeText(DetailMovieActivity.this, forToast, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void unLiked(LikeButton likeButton) {

            }
        });

        // setOnClickListener untuk Button Play
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked_btn(urlTrailer);
            }
        });

        // setOnClickListener untuk Button Back
        btnBack.setOnClickListener(new View.OnClickListener() {
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
        DetailMovieActivity.this.overridePendingTransition(R.anim.no_animation, R.anim.slide_down);
    }

    // Methods clicked_button
    public void clicked_btn(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

}
