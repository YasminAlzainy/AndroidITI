package yasmin.ayman.alzainy.secondday;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Outline;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Toast;

public class RecyclerActivity extends AppCompatActivity {
    private RecyclerView recycleView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Day[] days;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private FloatingActionButton fab;

    public RecyclerActivity() {
        days = new Day[]{new Day("Saterday", "Description ", R.drawable.first),
                new Day("Sunday", "Description ", R.drawable.second),
                new Day("Monday", "Description ", R.drawable.first),
                new Day("Tuesday", "Description ", R.drawable.second),
                new Day("Wednesday", "Description ", R.drawable.first),
                new Day("Thursday", "Description ", R.drawable.second),
                new Day("Friday", "Description ", R.drawable.first)
        };
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recycleView = findViewById(R.id.recycleView);
        recycleView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new MyAdapter(days);
        recycleView.setAdapter(adapter);
        recycleView.setLayoutManager(layoutManager);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                Toast.makeText(RecyclerActivity.this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You clicked Yasmin's FAB! ^_^", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                fab.setCompatElevation(50);
                fab.setElevation(50);
                fab.setOutlineProvider(new ViewOutlineProvider() {
                    @Override
                    public void getOutline(View view, Outline outline) {
                        outline.setRect(5  ,5,5,5);
                    }
                });

                animateBtn();
            }
        });


    }

    private void animateBtn() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animation = ObjectAnimator.ofFloat(fab, "translationX", -800f);
        //animation.reverse();
        animation.setDuration(2000);

        ObjectAnimator returnAnimation = ObjectAnimator.ofFloat(fab, "translationX", 800f);
        returnAnimation.setDuration(2000);

        animatorSet.play(returnAnimation).after(animation);
        animation.start();


    }
}