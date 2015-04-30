package com.gaurav.example.espresso.activity;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import com.gaurav.example.R;
import com.gaurav.example.activity.MainActivity;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        getActivity();
    }

    @Test
    public void displaysActionBarTabsOnHomeScreen() {
        onView(withId(R.id.action_bar_tabs)).check(matches(isDisplayed()));
        onView(withId(R.id.action_bar_title)).check(matches(withText("Mercury")));
    }

    @Ignore("Couldn't find a way to test action bar tabs, navigation drawer app icon, etc." +
            "Hence, moved to Robotium from this point")
    @Test
    public void displaysNavDrawerOnTouchingAppIcon() {
//        onView(withTag).perform(click());
//
//        onView(withText("Mercury")).perform(click());
//        onView(withId(R.id.action_bar_title)).check(matches(withText("Neptune")));
//        onView(withId(R.id.image)).check(matches(withText("Mercury"))).check(matches(isDisplayed()));
    }
}