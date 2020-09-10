package services;

import models.ParticipantHours;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HoursService {

    @GET("hours")
    Call<ArrayList<ParticipantHours>> getParticipants();
}
