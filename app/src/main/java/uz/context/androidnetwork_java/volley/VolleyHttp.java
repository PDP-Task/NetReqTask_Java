package uz.context.androidnetwork_java.volley;

import android.util.Log;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.lang.invoke.MethodHandle;
import java.util.HashMap;
import java.util.Map;

import uz.context.androidnetwork_java.MyApplication;
import uz.context.androidnetwork_java.model.Poster;
import uz.context.androidnetwork_java.util.Logger;

public class VolleyHttp {
    public static String TAG = VolleyHttp.class.getSimpleName();
    public static boolean IS_TESTER = true;
    static String SERVER_DEVELOPMENT = "https://jsonplaceholder.typicode.com/";
    static String SERVER_PRODUCTION = "https://jsonplaceholder.typicode.com/";

    public static String server(String url) {
        if (IS_TESTER)
            return SERVER_DEVELOPMENT + url;
        return SERVER_PRODUCTION + url;
    }

    public static HashMap<String, String> headers() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-type", "application/json; charset=UTF-8");
        return headers;
    }

    public static void get(String api, HashMap<String, String> params, VolleyHandler handler) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, server(api),
                response -> {
                    Logger.d(TAG, response);
                    handler.onSuccess(response);
                }, error -> {
            Logger.e(TAG, error.toString());
            handler.onError(error.toString());
        }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };
        MyApplication.instance.addToRequestQueue(stringRequest);
    }

    public static void post(String api, HashMap<String, Object> body, VolleyHandler volleyHandler) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, server(api),
                response -> {
                    Logger.d(TAG, response);
                    volleyHandler.onSuccess(response);
                }, error -> {
            Logger.e(TAG, error.toString());
            volleyHandler.onError(error.toString());
        }
        );
        MyApplication.instance.addToRequestQueue(stringRequest);
    }

    public static String API_LIST_POST = "posts";
    public static String API_SINGLE_POST = "posts/";
    public static String API_CREATE_POST = "posts";
    public static String API_UPDATE_POST = "posts/";
    public static String API_DELETE_POST = "posts/";

    public static HashMap<String, String> paramsEmpty() {
        return new HashMap<String, String>();
    }

    private static HashMap<String, Object> paramsCreate(Poster poster) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("title", poster.getTitle());
        params.put("body", poster.getBody());
        params.put("userId", poster.getUserId());
        return params;
    }

    public static HashMap<String, Object> paramsUpdate(Poster poster) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", poster.getId());
        params.put("title", poster.getTitle());
        params.put("body", poster.getBody());
        params.put("userId", poster.getUserId());
        return params;
    }
}
