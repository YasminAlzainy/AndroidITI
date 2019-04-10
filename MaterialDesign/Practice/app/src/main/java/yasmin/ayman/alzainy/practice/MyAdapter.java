package yasmin.ayman.alzainy.practice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private String[] dataArr;
    private Context context;

    public MyAdapter(String[] dataArr) {
        this.dataArr = dataArr;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        LayoutInflater layoutInflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View row = layoutInflater.inflate(R.layout.row_layout, viewGroup, false);
        //TextView textView = (TextView) row.findViewById(R.id.textViewRecycler);

        context = viewGroup.getContext();
        View view = LayoutInflater.from(context)
                .inflate(R.layout.row_layout, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, int i) {
        viewHolder.textView.setText(dataArr[i]);
        final String toastString = dataArr[i];

        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You clicked: "+ toastString + " :)", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataArr.length;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private LinearLayout linearLayout;

        public MyViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.textViewRecycler);
            linearLayout = v.findViewById(R.id.linearLayout);
        }
    }
}
