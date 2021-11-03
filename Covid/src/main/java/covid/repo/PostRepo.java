package covid.repo;

import java.util.List;

import covid.model.CovidModel;
import covid.model.PostModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostRepo {
	@POST("posts")
	Call<PostModel> inputPost(@Body PostModel model);
}
