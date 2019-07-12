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
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListTvshowAdapter extends RecyclerView.Adapter<ListTvshowAdapter.CategoryViewHolder> implements Filterable {

    private Context context;
    private ArrayList<Tvshow> listTvshow, filterListTvshow;
    private CustomFilterTvshow filter;

    ListTvshowAdapter(Context context, ArrayList<Tvshow> listTvshow) {
        this.context = context;
        this.listTvshow = listTvshow;
        this.filterListTvshow = listTvshow;
    }

    private ArrayList<Tvshow> getListTvshow() {
        return listTvshow;
    }

    void setListTvshow(ArrayList<Tvshow> listTvshow) {
        this.listTvshow = listTvshow;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_tvshow, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryViewHolder holder, int position) {
        holder.tvTitle.setText(getListTvshow().get(position).getTitle());
        holder.tvReleasedYear.setText(getListTvshow().get(position).getReleasedYear());
        holder.tvRating.setText(getListTvshow().get(position).getRating());
        holder.tvGenre.setText(getListTvshow().get(position).getGenre());
        holder.tvScoreAngkaHome.setText(String.valueOf(getListTvshow().get(position).getScore()));
        holder.tvOverviewHome.setText(getListTvshow().get(position).getOverview());
        holder.scoreHome.setRating((float) ((getListTvshow().get(position).getScore() * 5) / 100));
        Glide.with(context)
                .load(getListTvshow().get(position).getPoster())
                .into(holder.imgPoster);

        // Implement Click Listener ---------> Intent
        holder.setItemClickListenerTvshow(new ItemClickListenerTvshow() {
            @Override
            public void onItemClick(View v, int pos) {
                // Define and Start Intent
                Intent moveWithObjectIntentTvshow = new Intent(context, DetailTvshowActivity.class);
                moveWithObjectIntentTvshow.putExtra(DetailTvshowActivity.EXTRA_TVSHOW, listTvshow.get(pos));
                context.startActivity(moveWithObjectIntentTvshow);

                // Intent Transition Animation
                ((Activity) context).overridePendingTransition(R.anim.slide_up, R.anim.no_animation);
            }
        });

        // Animation
        setFadeAnimation(holder.itemView);
    }

    @Override
    public int getItemCount() {
        return getListTvshow().size();
    }

    @Override
    public Filter getFilter() {
        if (filter == null) filter = new CustomFilterTvshow(filterListTvshow, this);
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

        ItemClickListenerTvshow itemClickListenerTvshow;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title_tvshow);
            tvReleasedYear = itemView.findViewById(R.id.tv_item_releasedYear_tvshow);
            imgPoster = itemView.findViewById(R.id.img_item_poster_tvshow);
            tvRating = itemView.findViewById(R.id.tv_item_retingHome_tvshow);
            tvGenre = itemView.findViewById(R.id.tv_item_genreHome_tvshow);
            scoreHome = itemView.findViewById(R.id.scoreHome_tvshow);
            tvScoreAngkaHome = itemView.findViewById(R.id.tv_item_scoreAngkaHome_tvshow);
            tvOverviewHome = itemView.findViewById(R.id.tv_item_overview_tvshow);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.itemClickListenerTvshow.onItemClick(v, getLayoutPosition());
        }

        void setItemClickListenerTvshow(ItemClickListenerTvshow ic) {
            this.itemClickListenerTvshow = ic;
        }
    }

    // Methods

    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000);
        view.startAnimation(anim);
    }

}
