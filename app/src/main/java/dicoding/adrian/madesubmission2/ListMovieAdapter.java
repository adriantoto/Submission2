package dicoding.adrian.madesubmission2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<Movie> listMovie;
    private int lastPosition = -1;

    public ListMovieAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Movie> getListMovie() {
        return listMovie;
    }

    public void setListMovie(ArrayList<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_movies, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.tvTitle.setText(getListMovie().get(position).getTitle());
        holder.tvReleasedYear.setText(getListMovie().get(position).getReleasedYear());
        holder.tvRating.setText(getListMovie().get(position).getRating());
        holder.tvGenre.setText(getListMovie().get(position).getGenre());
        holder.tvScoreAngkaHome.setText(String.valueOf(getListMovie().get(position).getScore()));
        holder.tvOverviewHome.setText(getListMovie().get(position).getOverview());
        holder.scoreHome.setRating((float) ((getListMovie().get(position).getScore() * 5) / 100));
        Glide.with(context)
                .load(getListMovie().get(position).getPoster())
                .into(holder.imgPoster);

        // Animation
        setFadeAnimation(holder.itemView);
    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvReleasedYear;
        ImageView imgPoster;
        TextView tvRating;
        TextView tvGenre;
        RatingBar scoreHome;
        TextView tvScoreAngkaHome;
        TextView tvOverviewHome;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvReleasedYear = itemView.findViewById(R.id.tv_item_releasedYear);
            imgPoster = itemView.findViewById(R.id.img_item_poster);
            tvRating = itemView.findViewById(R.id.tv_item_retingHome);
            tvGenre = itemView.findViewById(R.id.tv_item_genreHome);
            scoreHome = itemView.findViewById(R.id.scoreHome);
            tvScoreAngkaHome = itemView.findViewById(R.id.tv_item_scoreAngkaHome);
            tvOverviewHome = itemView.findViewById(R.id.tv_item_overview);
        }
    }

    // Methods

    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000);
        view.startAnimation(anim);
    }

}
