package yasmin.ayman.alzainy.thread.model.networkServices;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import yasmin.ayman.alzainy.thread.model.Country;
import yasmin.ayman.alzainy.thread.screens.jsonScreen.Contract;
import yasmin.ayman.alzainy.thread.screens.jsonScreen.JsonPresenterImp;

public class CountryHandler extends AsyncTask<String, Void, Country> {
    private Contract.JsonPresenter jsonPresenter;

    @Override
    protected Country doInBackground(String... strings) {
        return downloadJson(strings[0], Integer.parseInt(strings[1]));
    }

    public void setJsonPresenter(Contract.JsonPresenter presenter){
        this.jsonPresenter = presenter;
    }

    @Override
    protected void onPostExecute(Country country) {
        super.onPostExecute(country);
        jsonPresenter = new JsonPresenterImp(this);
        jsonPresenter.returnCountry(country);
    }

    private Country downloadJson(String url, int counter) {
        Country countryObj = null;
        try {
            String rank = "not found", country = "not found", population = "not found", flag = "not found";
            HttpHandler httpHandler = new HttpHandler();
            String jsonString = httpHandler.makeServiceCall(url);
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = (JSONArray) jsonObject.getJSONArray("worldpopulation");
            JSONObject objInArray = jsonArray.getJSONObject(counter);
            rank = objInArray.getString("rank");
            country = objInArray.getString("country");
            population = objInArray.getString("population");
            flag = objInArray.getString("flag");

            countryObj = new Country(country, population, rank);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return countryObj;
    }

}



