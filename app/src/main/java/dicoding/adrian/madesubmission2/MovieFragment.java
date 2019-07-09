package dicoding.adrian.madesubmission2;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment implements View.OnClickListener {

    private RecyclerView rvMovie;
    private ArrayList<Movie> list = new ArrayList<>();

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Divider between item list
        rvMovie = view.findViewById(R.id.rv_movie);
        DividerItemDecoration itemDecorator = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.divider));
        rvMovie.addItemDecoration(itemDecorator);
        rvMovie.setHasFixedSize(true);

        list.addAll(MoviesData.getListData());
        showRecyclerList();
    }

    @Override
    public void onClick(View v) {

    }

    private void showRecyclerList() {
        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        ListMovieAdapter listMovieAdapter = new ListMovieAdapter(getActivity());
        listMovieAdapter.setListMovie(list);
        rvMovie.setAdapter(listMovieAdapter);
    }

}
