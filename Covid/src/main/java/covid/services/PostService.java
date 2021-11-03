package covid.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import covid.model.CovidModel;
import covid.model.PostModel;
import covid.repo.CovidRepo;
import covid.repo.PostRepo;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class PostService {
	private PostRepo service;
	
	public PostService() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://jsonplaceholder.typicode.com/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		service = retrofit.create(PostRepo.class);
	}
	
	public PostModel inputModel(PostModel model) {
		Call<PostModel> call = service.inputPost(model);
		Response<PostModel> response = null;
		
		try {
			response = call.execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response.body();
	}
}
