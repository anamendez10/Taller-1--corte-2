package com.example.parcial_corte1;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;

import androidx.test.ext.junit.runners.AndroidJUnit4;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void test1(){
        onView(withId(R.id.txtUser))
                .perform(typeText("ana.mendezr"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.txtPassword))
                .perform(typeText("Prueba123"), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.btnContinuar))
                .perform(click());
    }
}
