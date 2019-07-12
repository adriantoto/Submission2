package dicoding.adrian.madesubmission2;

import android.widget.Filter;

import java.util.ArrayList;

public class CustomFilterMovie extends Filter {

    private ListMovieAdapter listMovieAdapter;
    private ArrayList<Movie> filterListMovie;

    CustomFilterMovie(ArrayList<Movie> filterListMovie, ListMovieAdapter listMovieAdapter) {
        this.listMovieAdapter = listMovieAdapter;
        this.filterListMovie = filterListMovie;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        // Check Constraint Validity
        if (constraint != null && constraint.length() > 0) {
            // Change to Uppercase
            constraint = constraint.toString().trim().toUpperCase();
            // Store Our Fltered Movies
            ArrayList<Movie> filteredMovies = new ArrayList<>();
            for (int i = 0; i < filterListMovie.size(); i++) {
                // Check
                if (filterListMovie.get(i).getTitle().toUpperCase().contains(constraint)) {
                    // Add Movie to Filtered Movies
                    filteredMovies.add(filterListMovie.get(i));
                }
            }
            results.count = filteredMovies.size();
            results.values = filteredMovies;
        } else {
            results.count = filterListMovie.size();
            results.values = filterListMovie;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        listMovieAdapter.setListMovie((ArrayList<Movie>) results.values);
        // Refresh
        listMovieAdapter.notifyDataSetChanged();
    }
}
