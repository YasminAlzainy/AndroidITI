package yasmin.ayman.alzainy.practice;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.widget.Toast;

public class RecycleWithCardsActivity extends AppCompatActivity {

    private RecyclerView  recycleView ;
    private RecyclerView.Adapter adapter ;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        String [] dummy = {"Hello" , "Hi" , "yasmin" , "sara" , "home" , "Egypt" , "Turkey" ,"korea" ,
                "data" ,"nothing" , "loading" , "Don't Know" , "so ?!"};

        recycleView = findViewById(R.id.recycleView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recycleView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        adapter = new MyAdapter(dummy);

        recycleView.setAdapter(adapter);
        recycleView.setLayoutManager(layoutManager);

//        recycleView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//            @Override
//            public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
//                return false;
//            }
//
//            @Override
//            public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
//
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean b) {
//
//            }
//        });


    }
}
