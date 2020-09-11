package services;

import models.Detail;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface DetailsService {


    @FormUrlEncoded
    @POST
    Call<Void> createDetail(@Url String altUrl,
    @Field("entry.1824927963") String email,
    @Field("entry.1877115667") String firstName,
    @Field("entry.2006916086") String lastname,
    @Field("entry.284483984") String link
    );



}
