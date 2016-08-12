package generator.cleaver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import generator.cleaver.view.EventAdapter;

public class EventListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        int categoryNumber = getIntent().getExtras().getInt(MainActivity.CATEGORY_NUMBER, -1);

        if(categoryNumber != -1) {
            recyclerView = (RecyclerView) findViewById(R.id.eventListRecyclerView);
            eventAdapter = new EventAdapter(this, categoryNumber);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(eventAdapter);
        }else{
            Toast.makeText(EventListActivity.this, "Wrong category number obtained.", Toast.LENGTH_SHORT).show();
        }
    }
}
