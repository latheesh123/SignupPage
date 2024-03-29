package latheesh.com.prestosignup;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
@Rule
public ActivityTestRule<MainActivity>activityActivityTestRule=new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("latheesh.com.prestosignup", appContext.getPackageName());
    }
@Test
    public void Signuptest()
{
    onView(withId(R.id.signup)).perform(click());
    onView(withId(R.id.reg_firstName)).perform(typeText("John"));
    onView(withId(R.id.reg_lastName)).perform(typeText("doe"));
    onView(withId(R.id.reg_email)).perform(typeText("john.doe@gmail.com"));
    onView(withId(R.id.reg_phonenum)).perform(typeText("12345567899"));
    onView(withId(R.id.reg_register)).perform(click());
}
}
