package services;

import models.ParticipantHours;

import java.util.ArrayList;

import models.ParticipantSkillIQ;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SkillService {

    @GET("skilliq")
    Call<ArrayList<ParticipantSkillIQ>> getParticipants();
}
