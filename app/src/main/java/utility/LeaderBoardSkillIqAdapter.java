package utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import models.ParticipantSkillIQ;

import com.example.gadsleaderboard.R;

import java.util.ArrayList;

public class LeaderBoardSkillIqAdapter extends RecyclerView.Adapter  {

    private final Context mContext;
    private final LayoutInflater inflater;
    private ArrayList<ParticipantSkillIQ> mLeaderBoardParticipants;
    private View view;

    public LeaderBoardSkillIqAdapter(Context mContext, ArrayList<ParticipantSkillIQ> mLeaderBoardParticipants ) {
        this.mContext = mContext;
        this.mLeaderBoardParticipants = mLeaderBoardParticipants;
        inflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.leader_board_skill_iq, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n") // not sure of this
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = new ViewHolder(view);
        ParticipantSkillIQ participant = null;
        participant = mLeaderBoardParticipants.get(position);

        holder1.txtName.setText(participant.getName());
        holder1.txtHoursandCountry.setText(participant.getScore() + " skill IQ Score, " +
                participant.getCountry());


    }

    @Override
    public int getItemCount() {
        return mLeaderBoardParticipants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName;
        private TextView txtHoursandCountry;
        private ImageView imgBanner;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtHoursandCountry = itemView.findViewById(R.id.txt_hours_and_country);
        }
    }
}
