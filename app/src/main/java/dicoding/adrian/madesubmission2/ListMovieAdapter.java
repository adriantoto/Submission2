package dicoding.adrian.madesubmission2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.CategoryViewHolder> implements Filterable {

    private Context context;
    private ArrayList<Movie> listMovie, filterListMovie;
    CustomFilterMovie filter;

    public ListMovieAdapter(Context context, ArrayList<Movie> listMovie) {
        this.context = context;
        this.listMovie = listMovie;
        this.filterListMovie = listMovie;
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
    public void onBindViewHolder(@NonNull final CategoryViewHolder holder, int position) {
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

        // Implement Click Listener ---------> Intent
        holder.setItemClickListenerMovie(new ItemClickListenerMovie() {
            @Override
            public void onItemClick(View v, int pos) {
                //Toast.makeText(context, listMovie.get(pos).getTitle(), Toast.LENGTH_SHORT).show();
                // Define and Start Intent
                Intent moveWithObjectIntent = new Intent(context, DetailMovieActivity.class);
                moveWithObjectIntent.putExtra(DetailMovieActivity.EXTRA_MOVIE, listMovie.get(pos));
                context.startActivity(moveWithObjectIntent);

                // Intent Transition Animation
                ((Activity) context).overridePendingTransition(R.anim.slide_up, R.anim.no_animation);
            }
        });

        // Animation
        setFadeAnimation(holder.itemView);
    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new CustomFilterMovie(filterListMovie, this);
        }
        return filter;
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTitle;
        TextView tvReleasedYear;
        ImageView imgPoster;
        TextView tvRating;
        TextView tvGenre;
        RatingBar scoreHome;
        TextView tvScoreAngkaHome;
        TextView tvOverviewHome;

        ItemClickListenerMovie itemClickListenerMovie;

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

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.itemClickListenerMovie.onItemClick(v, getLayoutPosition());
        }

        public void setItemClickListenerMovie(ItemClickListenerMovie ic) {
            this.itemClickListenerMovie = ic;
        }
    }

    // Methods

    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000);
        view.startAnimation(anim);
    }

}
