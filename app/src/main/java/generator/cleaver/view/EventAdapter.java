package generator.cleaver.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import generator.cleaver.ModelSingleton;
import generator.cleaver.R;
import generator.cleaver.model.Event;

/**
 * Created by Prasanna Lakkur Subramanyam on 4/2/2016.
 */
public class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {
    private Context mContext;
    private int categoryNumber;
    private List<Event> eventList;

    public EventAdapter(Context context, int categoryNumber){
        mContext = context;
        this.categoryNumber = categoryNumber;
        eventList = ModelSingleton.getInstance(mContext).getModel().getCategory().get(categoryNumber).getEvents();
    }


    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        EventViewHolder eventViewHolder = new EventViewHolder(
                LayoutInflater.from(mContext).inflate(R.layout.event_view, parent, false), mContext,
                categoryNumber);

        return eventViewHolder;
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        holder.setText(eventList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
