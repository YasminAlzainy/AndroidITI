package yasmin.ayman.alzainy.countriesretrofit;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class ViewHolder {
    private ImageView imageView;
    private TextView tvRank, tvCountry, tvPopulation;
    private View currentView;

    public ViewHolder(View currentView) {
        this.currentView = currentView;
    }

    public ImageView getImageView() {
        if (imageView == null)
            imageView = currentView.findViewById(R.id.imageView);
        return imageView;
    }

    public TextView getTvRank() {
        if (tvRank == null)
            tvRank = currentView.findViewById(R.id.tvRank);
        return tvRank;
    }

    public TextView getTvCountry() {
        if (tvCountry == null)
            tvCountry = currentView.findViewById(R.id.tvCountry);
        return tvCountry;
    }

    public TextView getTvPopulation() {
        if (tvPopulation == null)
            tvPopulation = currentView.findViewById(R.id.tvPopulation);
        return tvPopulation;
    }
}
