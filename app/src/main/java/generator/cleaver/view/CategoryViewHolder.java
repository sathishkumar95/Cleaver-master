package generator.cleaver.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import generator.cleaver.EventListActivity;
import generator.cleaver.MainActivity;

/**
 * Created by Prasanna Lakkur Subramanyam on 4/2/2016.
 */
public class CategoryViewHolder extends ButtonViewHolder {

    public CategoryViewHolder(View itemView, Context context) {
        super(itemView, context);
    }

    @Override
    public void onClick(View v) {
        //send intent with Category number
        Intent intent = new Intent(context, EventListActivity.class);
        intent.putExtra(MainActivity.CATEGORY_NUMBER, getAdapterPosition());
        context.startActivity(intent);
    }

}
