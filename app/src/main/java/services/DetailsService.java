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
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    Call<Void> createDetail(
    @Field("entry.1824927963") String email,
    @Field("entry.1877115667") String firstName,
    @Field("entry.2006916086") String lastname,
    @Field("entry.284483984") String link
    );



}
