package covid.repo;

import java.util.List;

import covid.model.CovidModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CovidRepo {
	@GET("v1")
	Call<List<CovidModel>> getAll();
	Call<CovidModel> getByCountry(@Path("country") String country);
}
