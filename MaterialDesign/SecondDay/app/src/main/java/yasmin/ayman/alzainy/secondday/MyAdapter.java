package yasmin.ayman.alzainy.secondday;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Day[] daysArr;
    private Context context;

    public MyAdapter(Day[] daysArr) {
        this.daysArr = daysArr;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context)
                .inflate(R.layout.row_layout, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, final int i) {
        viewHolder.textView.setText(daysArr[i].getName());
        viewHolder.imageView.setImageResource(daysArr[i].getImag());

        final String toastString = daysArr[i].getName();
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You clicked: "+ toastString + " :)", Toast.LENGTH_SHORT).show();
                viewHolder.cardView.setCardElevation(50);
               // viewHolder.cardView.setCardBackgroundColor(R.color.colorAccent);
                Intent intent = new Intent(context, SelectedItemActivity.class);
                intent.putExtra(SelectedItemActivity.EXTRA_CONTACT, daysArr[i].getName());
                intent.putExtra(SelectedItemActivity.EXTRA_IMAGE, daysArr[i].getImag());

//                Pair<View, String> p1 = Pair.create((View)viewHolder.imageView, "profilePic");
//                Pair<View, String> p2 = Pair.create((View)viewHolder.textView, "profileText");
//                ActivityOptionsCompat options = (ActivityOptionsCompat) ActivityOptionsCompat.
//                        makeSceneTransitionAnimation(context, p1, p2);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation((Activity) context, (View)viewHolder.imageView, "profilePic");
                context.startActivity(intent, options.toBundle());
            }
        });


    }

    @Override
    public int getItemCount() {
        return daysArr.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private CardView cardView;
        private ImageView imageView;

        public MyViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.textViewDay);
            imageView = v.findViewById(R.id.imageView);
            cardView = v.findViewById(R.id.cardView);
        }
    }
}
