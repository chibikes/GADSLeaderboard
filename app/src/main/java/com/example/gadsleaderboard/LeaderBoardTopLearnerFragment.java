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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.HoursService;
import services.ServiceBuilder;
import utility.LeaderBoardAdapter;

public class LeaderBoardTopLearnerFragment extends Fragment {

    private RecyclerView listLeaderBoardParticipants;
    private LinearLayoutManager mLayoutManager;
    private LeaderBoardAdapter mLeaderBoardAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_leaderboard_top_learner,container,false);

        listLeaderBoardParticipants = view.findViewById(R.id.list_participants);
        mLayoutManager = new LinearLayoutManager(getContext());
        listLeaderBoardParticipants.setLayoutManager(mLayoutManager);

        mLeaderBoardAdapter = new LeaderBoardAdapter(getContext(), ParticipantsSingleton.getOurInstance().getmParticipants());
        listLeaderBoardParticipants.setAdapter(mLeaderBoardAdapter);

        getHoursData();

       return view;
    }
    private void getHoursData() {
        HoursService hoursService = ServiceBuilder.buildService(HoursService.class);
        Call<ArrayList<ParticipantHours>> hoursRequest = hoursService.getParticipants();

        hoursRequest.enqueue(new Callback<ArrayList<ParticipantHours>>() {
            @Override
            public void onResponse(Call<ArrayList<ParticipantHours>> call, Response<ArrayList<ParticipantHours>> response) {
                mLeaderBoardAdapter = new LeaderBoardAdapter(getContext(), response.body());
                listLeaderBoardParticipants.setAdapter(mLeaderBoardAdapter);
                MainActivity2.setConstraintLayout();


            }

            @Override
            public void onFailure(Call<ArrayList<ParticipantHours>> call, Throwable t) {
                Toast.makeText(getContext(),"YOU FAILED",Toast.LENGTH_LONG).show();
            }
        });
    }
    }

