package uz.context.androidnetwork_java.retrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import uz.context.androidnetwork_java.model.Poster;
import uz.context.androidnetwork_java.model.PosterResp;

public interface PosterService {
    @Headers(
            "Content-type:application/json"
    )

    @GET("posts")
    Call<ArrayList<PosterResp>> listPost();

    @GET("posts/{id}")
    Call<PosterResp> singlePost(@Path("id") int id);

    @POST("posts")
    Call<PosterResp> createPost(@Body Poster poster);

    @PUT("posts/id")
    Call<PosterResp> updatePost(@Path("id") int id, @Body Poster poster);

    @DELETE("posts/{id}")
    Call<PosterResp> deletePost(@Path("id") int id);
}
