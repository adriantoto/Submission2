package dicoding.adrian.madesubmission2;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class TVShowFragment extends Fragment {

    private ListTvshowAdapter listTvshowAdapter;

    // Item Data Variables Declaration
    private String[] tvshowTitle;
    private String[] tvshowReleasedYear;
    private String[] tvshowOverview;
    private String[] tvshowRating;
    private String[] tvshowGenre;
    private int[] tvshowScore;
    private String[] tvshowTrailer;
    private String[] tvshowRuntime;
    private String[] tvshowDirector;
    private String[] tvshowPoster;

    public TVShowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tvshow, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Casting data resources
        tvshowTitle = getResources().getStringArray(R.array.tv_title);
        tvshowDirector = getResources().getStringArray(R.array.tv_director);
        tvshowGenre = getResources().getStringArray(R.array.tv_genre);
        tvshowOverview = getResources().getStringArray(R.array.tv_overview);
        tvshowPoster = getResources().getStringArray(R.array.tv_poster);
        tvshowRating = getResources().getStringArray(R.array.tv_rating);
        tvshowReleasedYear = getResources().getStringArray(R.array.tv_released);
        tvshowRuntime = getResources().getStringArray(R.array.tv_runtime);
        tvshowTrailer = getResources().getStringArray(R.array.tv_trailer);
        tvshowScore = getResources().getIntArray(R.array.tv_score);

        // Adapter Instance
        listTvshowAdapter = new ListTvshowAdapter(getActivity(), getTvshow());

        // Declare and Cast RecyclerView
        RecyclerView rvTvshow = view.findViewById(R.id.rv_tvShow);

        // Layout Manager
        rvTvshow.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Divider between item list
        DividerItemDecoration itemDecorator = new DividerItemDecoration(Objects.requireNonNull(getContext()), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(Objects.requireNonNull(ContextCompat.getDrawable(Objects.requireNonNull(getContext()), R.drawable.divider)));
        rvTvshow.addItemDecoration(itemDecorator);
        rvTvshow.setHasFixedSize(true);

        // Set Adapter
        rvTvshow.setAdapter(listTvshowAdapter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onPrepareOptionsMenu(menu);
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        final SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                listTvshowAdapter.getFilter().filter(newText);
                return false;
            }
        });

    }

    private ArrayList<Tvshow> getTvshow() {
        ArrayList<Tvshow> tvshows = new ArrayList<>();
        for (int i = 0; i < tvshowTitle.length; i++) {
            Tvshow tvshow = new Tvshow();
            tvshow.setPoster(tvshowPoster[i]);
            tvshow.setTitle(tvshowTitle[i]);
            tvshow.setOverview(tvshowOverview[i]);
            tvshow.setRating(tvshowRating[i]);
            tvshow.setGenre(tvshowGenre[i]);
            tvshow.setReleasedYear(tvshowReleasedYear[i]);
            tvshow.setScore(tvshowScore[i]);
            tvshow.setTrailer(tvshowTrailer[i]);
            tvshow.setRuntime(tvshowRuntime[i]);
            tvshow.setDirector(tvshowDirector[i]);
            tvshows.add(tvshow);
        }
        return tvshows;
    }

}
