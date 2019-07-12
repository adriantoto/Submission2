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
public class MovieFragment extends Fragment {

    private ListMovieAdapter listMovieAdapter;

    // Item Data Variables Declaration
    private String[] movieTitle;
    private String[] movieReleasedYear;
    private String[] movieOverview;
    private String[] movieRating;
    private String[] movieGenre;
    private int[] movieScore;
    private String[] movieTrailer;
    private String[] movieRuntime;
    private String[] movieDirector;
    private String[] moviePoster;

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Casting data resources
        movieTitle = getResources().getStringArray(R.array.movie_title);
        movieDirector = getResources().getStringArray(R.array.movie_director);
        movieGenre = getResources().getStringArray(R.array.movie_genre);
        movieOverview = getResources().getStringArray(R.array.movie_overview);
        moviePoster = getResources().getStringArray(R.array.movie_poster);
        movieRating = getResources().getStringArray(R.array.movie_rating);
        movieReleasedYear = getResources().getStringArray(R.array.movie_released);
        movieRuntime = getResources().getStringArray(R.array.movie_runtime);
        movieTrailer = getResources().getStringArray(R.array.movie_trailer);
        movieScore = getResources().getIntArray(R.array.movie_score);

        // Adapter Instance
        listMovieAdapter = new ListMovieAdapter(getActivity(), getMovies());

        // Declare and Cast RecyclerView
        RecyclerView rvMovie = view.findViewById(R.id.rv_movie);

        // Layout Manager
        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Divider between item list
        DividerItemDecoration itemDecorator = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(Objects.requireNonNull(ContextCompat.getDrawable(Objects.requireNonNull(getContext()), R.drawable.divider)));
        rvMovie.addItemDecoration(itemDecorator);
        rvMovie.setHasFixedSize(true);

        // Set Adapter
        rvMovie.setAdapter(listMovieAdapter);
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
                listMovieAdapter.getFilter().filter(newText);
                return false;
            }
        });

    }

    private ArrayList<Movie> getMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieTitle.length; i++) {
            Movie movie = new Movie();
            movie.setPoster(moviePoster[i]);
            movie.setTitle(movieTitle[i]);
            movie.setOverview(movieOverview[i]);
            movie.setRating(movieRating[i]);
            movie.setGenre(movieGenre[i]);
            movie.setReleasedYear(movieReleasedYear[i]);
            movie.setScore(movieScore[i]);
            movie.setTrailer(movieTrailer[i]);
            movie.setRuntime(movieRuntime[i]);
            movie.setDirector(movieDirector[i]);
            movies.add(movie);
        }
        return movies;
    }

}
