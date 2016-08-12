package generator.cleaver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import generator.cleaver.model.Model;

/**
 * Created by Prasanna Lakkur Subramanyam on 4/2/2016.
 */
public interface ModelSource {
    Model provideModel();
}
