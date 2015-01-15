package gr.teicm.se.closestofferfinder.client.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;

import gr.teicm.se.closestofferfinder.client.presentation.R;
import gr.teicm.se.closestofferfinder.client.presentation.activities.MainActivity;

/**
 * Created by Mephisto on 15/1/2015.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity activity ;


    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity= getActivity() ;
    }

    public void testListViewNotNull(){

        ListView listView= (ListView) activity.findViewById(R.id.MyOffers) ;
        assertNotNull(listView) ;

    }
}
