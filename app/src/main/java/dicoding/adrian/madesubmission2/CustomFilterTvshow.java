package dicoding.adrian.madesubmission2;

import android.widget.Filter;

import java.util.ArrayList;

public class CustomFilterTvshow extends Filter {

    private ListTvshowAdapter listTvshowAdapter;
    private ArrayList<Tvshow> filterListTvshow;

    CustomFilterTvshow(ArrayList<Tvshow> filterListTvshow, ListTvshowAdapter listTvshowAdapter) {
        this.listTvshowAdapter = listTvshowAdapter;
        this.filterListTvshow = filterListTvshow;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        // Check Constraint Validity
        if (constraint != null && constraint.length() > 0) {
            // Change to Uppercase
            constraint = constraint.toString().trim().toUpperCase();
            // Store Our Fltered TV Shows
            ArrayList<Tvshow> filteredTvshows = new ArrayList<>();
            for (int i = 0; i < filterListTvshow.size(); i++) {
                // Check
                if (filterListTvshow.get(i).getTitle().toUpperCase().contains(constraint)) {
                    // Add TVShow to Filtered TVShows
                    filteredTvshows.add(filterListTvshow.get(i));
                }
            }
            results.count = filteredTvshows.size();
            results.values = filteredTvshows;
        } else {
            results.count = filterListTvshow.size();
            results.values = filterListTvshow;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        listTvshowAdapter.setListTvshow((ArrayList<Tvshow>) results.values);
        // Refresh
        listTvshowAdapter.notifyDataSetChanged();
    }
}
