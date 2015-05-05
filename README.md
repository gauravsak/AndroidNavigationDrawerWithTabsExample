# AndroidNavigationDrawerWithTabsExample
Basic example of a native Android app with navigation drawer and tabs on home screen along with example unit tests in Robolectric and UI tests in expresso and Robotium

## Softwares and Libraries
1. Operating System: Ubuntu 14.04 LTS
2. Android SDK 5.0 Lollipop Level 22
3. Android Studio 1.1.0
4. Other dependencies mentioned in project build.gradle

## What the example offers
1. Integration of different libraries to create a templated app structure which is common to most of the native android apps.
2. Example unit tests with Robolectric. **NOTE:** These tests only run via gradle. Android Studio support for Unit testing is still experimental.
3. Example UI automation tests with Expresso and Robotium. (I find Robotium rich and easy compared to Expresso)
4. Integration of two existing famous Android examples [PageSlidingTabStrip](https://github.com/astuetz/PagerSlidingTabStrip) and [Official Android Navigation Drawer Example](https://developer.android.com/training/implementing-navigation/nav-drawer.html).
5. Thanks to [this](https://github.com/Balaji-K13/Navigation-drawer-page-sliding-tab-strip) existing example of the integration of these to libraries.

## Typical issues faced during this integration
1. Events on the tabs in PageSlidingTabStrip were not working. The major difference was that their official example uses FragmentActivity and mine uses ActionBarActivity. But, ultimately this issue boiled down to setting margin of the container that hosts fragments equal to the height of the action bar so that the actual tab object becomes event respondable.
2. Robolectric doesn't work with Android Studio. I had to run it through terminal. Btw, you can use the terminal window that Android studio provides.
3. Drawables din't work for me because of issue #1. But it started working once the issue was resolved. One thing to note is that I created the tab asset as a vertical strip filled with required colours for each state and then repeated it over the tab width using <bitmap> tag provided by Android. Refer [this doc](http://developer.android.com/guide/topics/resources/drawable-resource.html)
4. I have observed that Expresso is hard to read as compared to Robotium although they had created it to resolve problems with Robotium. However, I din't find the API very intuitive.
5. The name of the app that will be shown in the phone menu (list of apps) is actually the label-name in Android manifest. This is not very evident from the docs.
6. When you build an android app code with Gradle, there is a static analysis tool in Android called [Lint](https://developer.android.com/tools/help/lint.html) which runs with every build and stops the build if it sees any issues. It also redirects the output of code analysis to a log file. You may not want to lint to stop our build everytime.
