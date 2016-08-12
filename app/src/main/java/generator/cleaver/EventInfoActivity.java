package generator.cleaver;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import generator.cleaver.view.EventInfoFragment;

public class EventInfoActivity extends AppCompatActivity {

    private static final String FRAG_TAG = "generator.cleaver_EVENT_INFO_FRAG_TAG";
    private int categoryNumber, eventNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);

        Bundle bundle = getIntent().getExtras();

        categoryNumber = bundle.getInt(MainActivity.CATEGORY_NUMBER, -1);
        eventNumber = bundle.getInt(MainActivity.EVENT_NUMBER, -1);

        if(categoryNumber != -1 && eventNumber != -1) {

            FragmentManager manager = getSupportFragmentManager();

            Fragment fragment = new EventInfoFragment();
            Bundle args = new Bundle();
            args.putInt(MainActivity.CATEGORY_NUMBER, categoryNumber);
            args.putInt(MainActivity.EVENT_NUMBER, eventNumber);
            fragment.setArguments(args);

            manager.beginTransaction().add(R.id.eventInfoFragmentContainer, fragment, FRAG_TAG).commit();

        }else{
            Toast.makeText(EventInfoActivity.this, "Wrong category or event number recieved", Toast.LENGTH_SHORT).show();
        }

    }

    public void onRegisterPressed(View view) {
        Intent intent = new Intent(this, RegistrationInfoActivity.class);
        intent.putExtra(MainActivity.CATEGORY_NUMBER, categoryNumber);
        intent.putExtra(MainActivity.EVENT_NUMBER, eventNumber);
        startActivity(intent);
    }
}
