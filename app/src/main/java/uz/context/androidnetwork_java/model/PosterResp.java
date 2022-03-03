package uz.context.androidnetwork_java.model;

import com.google.gson.annotations.SerializedName;

public class PosterResp {
    @SerializedName("id")
    int id = 0;
    @SerializedName("userId")
    int userId = 0;
    @SerializedName("title")
    String title = null;
    @SerializedName("body")
    String body = null;
}
