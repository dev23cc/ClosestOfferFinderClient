package gr.teicm.se.closestofferfinder.client.test;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.widget.Button;

import gr.teicm.se.closestofferfinder.client.presentation.R;
import gr.teicm.se.closestofferfinder.client.presentation.activities.MainActivity;

/**
 * Created by Mephisto on 15/1/2015.
 */
public class UITest extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity activity;
    Instrumentation instrumentation;

    public UITest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        instrumentation = getInstrumentation();
        activity = getActivity();


    }

    public void testButton() {

        final Button button = (Button) activity.findViewById(R.id.button3);

        activity.runOnUiThread(new Runnable() {
            public void run() {
                button.requestFocus();
            }


        });

        instrumentation.waitForIdleSync();

        this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);
    }
}
