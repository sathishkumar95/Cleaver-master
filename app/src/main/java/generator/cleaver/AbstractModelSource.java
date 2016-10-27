package generator.cleaver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import generator.cleaver.model.Model;

/**
 * Created by Sathish kumar on 4/2/2016.
 */
public abstract class AbstractModelSource implements ModelSource {


    protected abstract String getJsonString();

    @Override
    public Model provideModel() {
        Gson gson = new GsonBuilder().create();

        String jsonInput = getJsonString();

        return gson.fromJson(jsonInput, Model.class);
    }
}
