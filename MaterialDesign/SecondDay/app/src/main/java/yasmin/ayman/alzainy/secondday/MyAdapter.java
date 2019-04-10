package yasmin.ayman.alzainy.secondday;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
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
    public void onBindViewHolder(final MyViewHolder viewHolder, int i) {
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
