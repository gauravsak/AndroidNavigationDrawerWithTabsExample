package com.gaurav.example.activity;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.gaurav.example.activity.Tab2Fragment;
import com.gaurav.example.BuildConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(emulateSdk = 21, constants = BuildConfig.class)
public class Tab1FragmentTest {

    @Test
    public void displaysElementsInTab1Fragment() {
        Fragment fragment = Tab1Fragment.newInstance(null, null);
        startFragment(fragment);
        assertThat(fragment, is(notNullValue()));
    }

    private static void startFragment(Fragment fragment) {
        FragmentActivity activity = Robolectric.buildActivity(CustomFragmentActivity.class)
                .create()
                .start()
                .resume()
                .get();

        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(fragment, null);
        fragmentTransaction.commit();
    }

    private static class CustomFragmentActivity extends FragmentActivity implements Tab1Fragment.OnFragmentInteractionListener {
        @Override
        public void onFragmentInteraction(Uri uri) {
            // do nothing, STUB
        }
    }
}