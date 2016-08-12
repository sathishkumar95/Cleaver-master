package generator.cleaver.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import generator.cleaver.MainActivity;
import generator.cleaver.ModelSingleton;
import generator.cleaver.R;
import generator.cleaver.model.Event;

/**
 * Created by Prasanna Lakkur Subramanyam on 4/3/2016.
 */
public class EventInfoFragment extends Fragment {
    private Event event;
    private final String generalInfoPrefix = "Description\n";
    private final String rulesPrefix = "Rules\n";
    private final String additionalInfoPrefix = "Additional Info\n";



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //find the event number and category number
        Bundle args = getArguments();
        int categoryNumber = args.getInt(MainActivity.CATEGORY_NUMBER, -1);
        int eventNumber = args.getInt(MainActivity.EVENT_NUMBER, -1);
        event = ModelSingleton.getInstance(getContext()).getModel().getCategory().get(categoryNumber).getEvents().get(eventNumber);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_event_info, container, false);

        ((TextView)v.findViewById(R.id.eventNameTextView)).setText(event.getName());
        //TODO change this to use string with placeholders
        ((TextView)v.findViewById(R.id.eventGeneralInfoTextView)).setText(generalInfoPrefix + event.getDescription());
        ((TextView)v.findViewById(R.id.eventRulesTextView)).setText(rulesPrefix + event.getRules());
        ((TextView)v.findViewById(R.id.eventAdditionalInfoTextView)).setText(additionalInfoPrefix + event.getAdditionalInfo());

        return v;
    }

}
