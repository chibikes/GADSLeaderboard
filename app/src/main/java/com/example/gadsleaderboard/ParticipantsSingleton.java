package com.example.gadsleaderboard;

import java.util.ArrayList;

import models.ParticipantHours;

public class ParticipantsSingleton {

    private static ParticipantsSingleton ourInstance = null;


    private ArrayList<ParticipantHours> mParticipants = new ArrayList<>();

    public ArrayList<ParticipantHours> getmParticipantsSkillIq() {
        return mParticipantsSkillIq;
    }

    public void setmParticipantsSkillIq(ArrayList<ParticipantHours> mParticipantsSkillIq) {
        this.mParticipantsSkillIq = mParticipantsSkillIq;
    }

    private ArrayList<ParticipantHours> mParticipantsSkillIq = new ArrayList<>();

    private ParticipantsSingleton() { // private constructor so our participant list can only be instantiated only once
    }

    public static ParticipantsSingleton getOurInstance() {
        if(ourInstance == null) {
            ourInstance = new ParticipantsSingleton();
        }
        return ourInstance;
    }

    public ArrayList<ParticipantHours> getmParticipants() {
        return mParticipants;
    }

    public void setmParticipants(ArrayList<ParticipantHours> mParticipants) {
        this.mParticipants = mParticipants;
    }
}
