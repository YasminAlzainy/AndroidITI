package yasmin.ayman.alzainy.countriesretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRetrofitInterface {
    @GET("tutorial/jsonparsetutorial.txt")
    Call<WorldPOJO> getCountries ();
}
