package yasmin.ayman.alzainy.thread.screens.jsonScreen;

import android.content.Context;

import yasmin.ayman.alzainy.thread.model.Country;

public interface Contract {
    interface JsonView {
        void setCountryET(Country country);
    }

    interface JsonPresenter {
        void returnCountry(Country country);

        void handleJsonCountry(String jsonUrl, String counter);

    }
}
