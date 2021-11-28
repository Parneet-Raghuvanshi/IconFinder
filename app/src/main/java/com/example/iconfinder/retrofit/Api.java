package com.example.iconfinder.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface Api {

    String authHead = "Authorization";

    @GET("iconsets/{iconSetId}/icons")
    Call<ResponseBody> mainIconsApi(@Header(authHead) String userToken,@Path("iconSetId") String iconSetId);

}
