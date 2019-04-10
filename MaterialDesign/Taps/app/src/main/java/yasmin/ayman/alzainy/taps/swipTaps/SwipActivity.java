package yasmin.ayman.alzainy.taps.swipTaps;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import yasmin.ayman.alzainy.taps.R;

public class SwipActivity extends AppCompatActivity {

    // When requested, this adapter returns a DemoObjectFragment,
    // representing an object in the collection.
    private DemoCollectionPagerAdapter demoCollectionPagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swip);

        demoCollectionPagerAdapter = new DemoCollectionPagerAdapter(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(demoCollectionPagerAdapter);
    }
}
