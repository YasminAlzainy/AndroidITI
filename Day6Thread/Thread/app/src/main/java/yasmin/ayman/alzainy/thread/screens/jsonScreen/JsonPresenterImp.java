package yasmin.ayman.alzainy.thread.screens.jsonScreen;

import android.content.Context;

import yasmin.ayman.alzainy.thread.model.Country;
import yasmin.ayman.alzainy.thread.model.networkServices.CountryHandler;

public class JsonPresenterImp implements Contract.JsonPresenter {

    private Contract.JsonView jsonView;

    public JsonPresenterImp(Contract.JsonView jsonView) {
        this.jsonView = jsonView;
    }

    @Override
    public void returnCountry(Country country) {
        jsonView.setCountryET(country);
    }

    @Override
    public void handleJsonCountry(String jsonUrl, String counter) {
        CountryHandler countryHandler = new CountryHandler();
        countryHandler.setJsonPresenter(this);
        countryHandler.execute(jsonUrl, counter);
    }

}
