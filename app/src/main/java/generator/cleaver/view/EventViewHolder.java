package generator.cleaver.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import generator.cleaver.EventInfoActivity;
import generator.cleaver.MainActivity;

/**
 * Created by Prasanna Lakkur Subramanyam on 4/2/2016.
 */
public class EventViewHolder extends ButtonViewHolder{
    private int categoryNumber;

    public EventViewHolder(View itemView, Context context, int categoryNumber) {
        super(itemView, context);
        this.categoryNumber = categoryNumber;
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, EventInfoActivity.class);
        intent.putExtra(MainActivity.CATEGORY_NUMBER, categoryNumber);
        intent.putExtra(MainActivity.EVENT_NUMBER, getAdapterPosition());
        context.startActivity(intent);
    }
}
