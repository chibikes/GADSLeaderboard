package utility;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.gadsleaderboard.LeaderBoardSkillIQFragment;
import com.example.gadsleaderboard.LeaderBoardTopLearnerFragment;
import com.example.gadsleaderboard.MainActivity2;

public class TabsAdapter extends FragmentStateAdapter {
   // private final Context mContext;
    private Fragment fragment;


    public TabsAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
       // this.mContext = mContext;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                fragment = new LeaderBoardTopLearnerFragment();
                return fragment;
            case 1:
                fragment = new LeaderBoardSkillIQFragment();
                return fragment;
            default:
                return null;



        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
