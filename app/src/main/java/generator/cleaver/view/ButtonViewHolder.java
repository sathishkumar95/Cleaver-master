package generator.cleaver.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

/**
 * Created by Prasanna Lakkur Subramanyam on 4/3/2016.
 */
public abstract class ButtonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    protected Context context;
    public ButtonViewHolder(View itemView, Context context) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.context = context;
    }

    public void setText(String str){
        ((Button)itemView).setText(str);
    }
}
