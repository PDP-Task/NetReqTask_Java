package uz.context.androidnetwork_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uz.context.androidnetwork_java.model.PosterResp;
import uz.context.androidnetwork_java.retrofit.RetrofitHttp;
import uz.context.androidnetwork_java.util.Logger;
import uz.context.androidnetwork_java.volley.VolleyHandler;
import uz.context.androidnetwork_java.volley.VolleyHttp;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }
    private void initViews() {
        textView = findViewById(R.id.textView);

        getRetrofit();
    }

    private void getRetrofit() {
        RetrofitHttp.posterService.listPost().enqueue(new Callback<ArrayList<PosterResp>>() {
            @Override
            public void onResponse(Call<ArrayList<PosterResp>> call, Response<ArrayList<PosterResp>> response) {
                Log.d("@@@",response.body().toString());
                textView.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<ArrayList<PosterResp>> call, Throwable t) {
                Log.e("@@@",t.toString());
                textView.setText(t.toString());
            }
        });
    }

    private void getVolley() {
        VolleyHttp.get(VolleyHttp.API_LIST_POST, VolleyHttp.paramsEmpty(), new VolleyHandler() {
            @Override
            public void onSuccess(String response) {
                textView.setText(response);
            }

            @Override
            public void onError(String error) {
                textView.setText(error);
            }
        });
    }
}