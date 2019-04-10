package yasmin.ayman.alzainy.countriesretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WorldPOJO {
    @SerializedName("CountryPOJO")
    @Expose
    private List<CountryPOJO> CountryPOJO = null;

    public List<CountryPOJO> getCountryPOJO() {
        return CountryPOJO;
    }

    public void setCountryPOJO(List<CountryPOJO> CountryPOJO) {
        this.CountryPOJO = CountryPOJO;
    }
}
