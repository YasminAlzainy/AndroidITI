package yasmin.ayman.alzainy.thread.screens.jsonScreen;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import yasmin.ayman.alzainy.thread.R;
import yasmin.ayman.alzainy.thread.model.Country;
import yasmin.ayman.alzainy.thread.model.networkServices.CountryHandler;
import yasmin.ayman.alzainy.thread.model.networkServices.HttpHandler;

public class Json extends AppCompatActivity implements Contract.JsonView {
    private Contract.JsonPresenter jsonPresenter;

    private Handler jsonHandler;
    private EditText editTextRank, editTextCountry, editTextPopulation;
    private ImageView imageViewJson;
    private Button btnNext, btnPrev;
    private String jsonUrl;
    public static int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        jsonPresenter = new JsonPresenterImp(this);

        editTextCountry = findViewById(R.id.editTextCountry);
        editTextPopulation = findViewById(R.id.editTextPopulation);
        editTextRank = findViewById(R.id.editTextRank);
        imageViewJson = findViewById(R.id.imageViewJson);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);
        jsonHandler = new Handler();
        jsonUrl = "https://www.androidbegin.com/tutorial/jsonparsetutorial.txt";

        jsonPresenter.handleJsonCountry(jsonUrl, String.valueOf(counter));

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter == 10) {
                    counter = 0;
                } else {
                    counter++;
                }
                jsonPresenter.handleJsonCountry(jsonUrl, String.valueOf(counter));
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter == 0) {
                    counter = 9;
                } else {
                    counter--;
                }
                jsonPresenter.handleJsonCountry(jsonUrl, String.valueOf(counter));
            }
        });
    }

    @Override
    public void setCountryET(Country country) {
        editTextCountry.setText(country.getCountry());
        editTextPopulation.setText(country.getPopulation());
        editTextRank.setText(country.getRank());
    }
}
