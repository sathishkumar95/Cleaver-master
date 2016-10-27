package generator.cleaver;

import android.content.Context;
import android.widget.Toast;

import java.io.IOException;

import generator.cleaver.model.Model;

/**
 * Created by Sathish kumar on 4/2/2016.
 */
public class ModelSingleton {
    private static ModelSingleton ourInstance;

    private Model model;

    public static ModelSingleton getInstance(Context context) {
        if(ourInstance == null){
            ourInstance = new ModelSingleton();

            ModelSource modelSource = null;
            try {
                modelSource = new FileModelSource(context.getAssets().open("jsonInput.json") );
                ourInstance.model = modelSource.provideModel();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(context, "Unable to open the input file", Toast.LENGTH_SHORT).show();
            }
        }

        return ourInstance;
    }

    private ModelSingleton() {
    }

    public Model getModel() {
        return model;
    }
}
