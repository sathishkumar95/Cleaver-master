package generator.cleaver.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import generator.cleaver.R;
import generator.cleaver.model.Category;

/**
 * Created by Prasanna Lakkur Subramanyam on 4/2/2016.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    private Context mContext;
    private List<Category> mCategoryList;

    public CategoryAdapter(Context context, List<Category> categoryList){
        mContext = context;
        mCategoryList = categoryList;

    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CategoryViewHolder viewHolder = new CategoryViewHolder(LayoutInflater.from(mContext).inflate(
                R.layout.category_view, parent, false), mContext);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.setText(mCategoryList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }
}
