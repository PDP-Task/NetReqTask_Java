package uz.context.androidnetwork_java;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MyApplication extends Application {
    public static String TAG = MyApplication.class.getSimpleName();
    public static MyApplication instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    private RequestQueue requestQueue = null;

    public RequestQueue getRequestQueue() {
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(this);
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request) {
        getRequestQueue().add(request);
    }
}
