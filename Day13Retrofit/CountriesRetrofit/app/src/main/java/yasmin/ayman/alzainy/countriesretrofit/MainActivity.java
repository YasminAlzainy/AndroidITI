package yasmin.ayman.alzainy.countriesretrofit;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String WORLD_BASE = "http://www.androidbegin.com/";
    private APIRetrofitInterface retrofitInterface;
    private ListView listView;
    private CountryAdapter countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewCountry);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WORLD_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(APIRetrofitInterface.class);
        Call<WorldPOJO> worldCall = retrofitInterface.getCountries();
        worldCall.enqueue(new Callback<WorldPOJO>() {
            @Override
            public void onResponse(Call<WorldPOJO> call, Response<WorldPOJO> response) {
                List<CountryPOJO> countryList = response.body().getCountryPOJO();
                countryAdapter = new CountryAdapter(MainActivity.this,R.layout.row_layout ,R.id.tvCountry , countryList);
            }

            @Override
            public void onFailure(Call<WorldPOJO> call, Throwable t) {

            }
        });

    }
}
