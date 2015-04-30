package com.gaurav.example.robotium.activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.gaurav.example.R;
import com.gaurav.example.activity.MainActivity;
import com.robotium.solo.Solo;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testElementsOnHomeScreen() {
        Activity currentActivity = solo.getCurrentActivity();

        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);

        Context context = currentActivity.getApplicationContext();
        Resources resources = context.getResources();
        String homeScreenTitle = resources.getString(R.string.app_name);

        solo.unlockScreen();

        TextView tab1 = solo.getText("Tab 1");
        TextView tab2 = solo.getText("Tab 2");
        TextView tab3 = solo.getText("Tab 3");

        org.assertj.core.api.Assertions.assertThat(currentActivity.getTitle().toString()).isEqualTo(homeScreenTitle);

        org.assertj.android.api.Assertions.assertThat(tab1).isSelected();
        org.assertj.core.api.Assertions.assertThat(tab1.getCurrentTextColor())
                .isEqualTo(Color.WHITE);

        org.assertj.android.api.Assertions.assertThat(tab2).isNotSelected();
        org.assertj.core.api.Assertions.assertThat(tab2.getCurrentTextColor())
                .isEqualTo(Color.GRAY);

        org.assertj.android.api.Assertions.assertThat(tab3).isNotSelected();
        org.assertj.core.api.Assertions.assertThat(tab3.getCurrentTextColor())
                .isEqualTo(Color.GRAY);
    }
}