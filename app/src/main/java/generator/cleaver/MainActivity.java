package generator.cleaver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.io.IOException;

import generator.cleaver.model.Model;
import generator.cleaver.view.CategoryAdapter;

public class MainActivity extends AppCompatActivity {
    private Model model;
    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;

    public static final String CATEGORY_NUMBER = "generator.cleaver_CATEGORY_NUMBER";
    public static final String EVENT_NUMBER = "generator.cleaver_EVENT_NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        model = ModelSingleton.getInstance(this).getModel();

        recyclerView = (RecyclerView) findViewById(R.id.categoryRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        categoryAdapter = new CategoryAdapter(this, model.getCategory());
        recyclerView.setAdapter(categoryAdapter);

    }
}
