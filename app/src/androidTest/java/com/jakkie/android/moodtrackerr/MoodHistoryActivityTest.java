package com.jakkie.android.moodtrackerr;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import com.jakkie.android.moodtrackerr.ui.MoodHistoryActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Jakkie on ${Date}.
 */
public class MoodHistoryActivityTest {

    //test launch mood history activity
    @Rule
    public ActivityTestRule<MoodHistoryActivity> activityRule
            = new ActivityTestRule<>(
            MoodHistoryActivity.class,
            true,     // initialTouchMode
            false);   // launchActivity. False to customize the intent


    @Test
    public void intent() {
        Intent intent = new Intent();
        intent.putExtra("your_key", "your_value");

        activityRule.launchActivity(intent);

        // Continue with your test
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}