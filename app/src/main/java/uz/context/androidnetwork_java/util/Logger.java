package uz.context.androidnetwork_java.util;

import android.util.Log;

import uz.context.androidnetwork_java.volley.VolleyHttp;

public class Logger {
    public static void d(String tag, String msg) {
        if (VolleyHttp.IS_TESTER) Log.d(tag, msg);
    }

    public static void i(String tag, String msg) {
        if (VolleyHttp.IS_TESTER) Log.i(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (VolleyHttp.IS_TESTER) Log.v(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (VolleyHttp.IS_TESTER) Log.e(tag, msg);
    }
}
