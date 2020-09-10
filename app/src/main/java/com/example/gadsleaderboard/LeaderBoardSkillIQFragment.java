package com.example.gadsleaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import models.ParticipantHours;
import models.ParticipantSkillIQ;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.ServiceBuilder;
import services.SkillService;
import utility.LeaderBoardAdapter;
import utility.LeaderBoardSkillIqAdapter;

public class LeaderBoardSkillIQFragment extends Fragment  {
    private RecyclerView mListLeaderBoardParticipants;
    private LeaderBoardSkillIqAdapter mLeaderBoardAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leaderboard_skill_iq, container, false);


        mListLeaderBoardParticipants = view.findViewById(R.id.list_participants_skill_iq);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mListLeaderBoardParticipants.setLayoutManager(layoutManager);

//        mLeaderBoardAdapter = new LeaderBoardAdapter(getContext(), ParticipantsSingleton.getOurInstance().getmParticipantsSkillIq());
//        mListLeaderBoardParticipants.setAdapter(mLeaderBoardAdapter);
        getSkillDAta();
        return view;
    }

    private void getSkillDAta() {
        SkillService skillService = ServiceBuilder.buildService(SkillService.class);
        Call<ArrayList<ParticipantSkillIQ>> skillIQRequest = skillService.getParticipants();

        skillIQRequest.enqueue(new Callback<ArrayList<ParticipantSkillIQ>>() {
            @Override
            public void onResponse(Call<ArrayList<ParticipantSkillIQ>> call, Response<ArrayList<ParticipantSkillIQ>> response) {
                mLeaderBoardAdapter = new LeaderBoardSkillIqAdapter(getContext(), response.body());
                mListLeaderBoardParticipants.setAdapter(mLeaderBoardAdapter);

            }

            @Override
            public void onFailure(Call<ArrayList<ParticipantSkillIQ>> call, Throwable t) {

            }
        });
    }
}
