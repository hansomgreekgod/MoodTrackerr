package com.jakkie.android.moodtrackerr.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.jakkie.android.moodtrackerr.R;
import com.jakkie.android.moodtrackerr.adapter.MoodsAdapter;
import com.jakkie.android.moodtrackerr.data.SharedPreferencesHelper;

import java.util.ArrayList;

/**
 * Show moods previously saved
 */
public class MoodHistoryActivity extends AppCompatActivity {

    private static final String TAG = "MoodHistoryActivity";

    private RecyclerView moodsRecyclerView;

    private MoodsAdapter moodsAdapter;
    private SharedPreferences mPreferences;
    private ArrayList<Integer> moods = new ArrayList<>();
    private ArrayList<String> comments = new ArrayList<>();
    private int currentDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_history);
        Log.d(TAG, "onCreate: MoodHistoryActivity");

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        currentDay = mPreferences.getInt(SharedPreferencesHelper.KEY_CURRENT_DAY, 1);

        moodsRecyclerView = findViewById(R.id.recycler_moods);
        moodsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));

        for (int i = 0;i < currentDay;i++) {
            moods.add(mPreferences.getInt("KEY_MOOD" + i, 3));
            comments.add(mPreferences.getString("KEY_COMMENT" + i, ""));
        }

        moodsAdapter = new MoodsAdapter(this, currentDay, moods, comments);
        moodsRecyclerView.setAdapter(moodsAdapter);
    }
}


