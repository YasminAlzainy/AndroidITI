package yasmin.ayman.alzainy.fragmentdaynamic;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements Communnicator {

    public static final String COUNTER = "Counter";
    private static final String SECOND_FRAGMENT = "Second_Fragment";
    private SecondFragment secondFragment;
    private FirstFragment firstFragment;
    private FirstFragment fragmentByTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            firstFragment = new FirstFragment();
            fragmentTransaction.add(R.id.first, firstFragment, "first");

            secondFragment = new SecondFragment();
            fragmentTransaction.add(R.id.second, secondFragment, "second");
            fragmentTransaction.commit();
        } else {
            firstFragment = (FirstFragment) getSupportFragmentManager().findFragmentByTag("first");
            secondFragment = (SecondFragment) getSupportFragmentManager().findFragmentByTag("second");
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isCreated" , true);
    }

    @Override
    public void count(int counter) {
        Log.i("counter", Integer.toString(counter));
        secondFragment.changeText(counter);
    }

}
