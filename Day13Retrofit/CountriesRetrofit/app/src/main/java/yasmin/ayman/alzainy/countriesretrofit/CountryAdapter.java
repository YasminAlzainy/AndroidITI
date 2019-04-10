package yasmin.ayman.alzainy.countriesretrofit;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;


public class CountryAdapter extends ArrayAdapter<CountryPOJO> {
    private Context context;
    private List<CountryPOJO> countries;
    private static int counter = 0;
    private ViewHolder viewHolder;


    public CountryAdapter(Context context, int resource, int textViewResourceId, List<CountryPOJO> countries) {
        super(context, resource, textViewResourceId, countries);
        this.context = context;

        this.countries = countries;
    }

    @Override
    public View getView(int position, View currentRowView, ViewGroup listView) {
        super.getView(position, currentRowView, listView);
        View row = currentRowView;

        if (currentRowView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, listView, false);
            viewHolder = new ViewHolder(row);
            row.setTag(viewHolder);
            counter++;
        } else {
            viewHolder = (ViewHolder) row.getTag();
            Log.i("ListView", "recycle");
        }
        viewHolder.getTvCountry().setText(countries.get(position).getCountry());
        viewHolder.getTvPopulation().setText(countries.get(position).getPopulation());
        viewHolder.getTvRank().setText(countries.get(position).getRank());

       // viewHolder.getImageView().setImageResource(countries[position].getFlag());

        Log.i("ListView", Integer.toString(counter));
        return row;
    }
}
