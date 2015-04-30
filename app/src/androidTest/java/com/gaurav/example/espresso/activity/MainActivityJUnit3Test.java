package com.gaurav.example.espresso.activity;

import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;

import com.gaurav.example.R;
import com.gaurav.example.activity.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class MainActivityJUnit3Test extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityJUnit3Test() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        getActivity();
    }

    public void testDisplaysTab1Fragment() {
        onView(withId(R.id.action_bar_tabs)).check(matches(isDisplayed()));
    }
}