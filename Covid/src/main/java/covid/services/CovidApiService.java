package covid.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import covid.model.CovidModel;
import covid.repo.CovidRepo;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class CovidApiService {
	private CovidRepo service;
	
	public CovidApiService() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://covid-19.dataflowkit.com/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		service = retrofit.create(CovidRepo.class);
	}
	
	public List<CovidModel> getAllCovidModel() {
		Call<List<CovidModel>> getCovid = service.getAll();
		Response<List<CovidModel>> response = null;
		
		try {
			response = getCovid.execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response.body();
	}
	
	public CovidModel getCovidModel(String country) {
		Call<CovidModel> getCovid = service.getByCountry(country);
		Response<CovidModel> response = null;
		
		try {
			response = getCovid.execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response.body();
	}
}
