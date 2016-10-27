package generator.cleaver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import generator.cleaver.model.Model;

/**
 * Created by Sathish kumar on 4/2/2016.
 */
public class FileModelSource extends AbstractModelSource {

    private InputStream inputStream;

    public FileModelSource(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    protected String getJsonString() {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str;
            StringBuilder builder = new StringBuilder();
            while((str = bufferedReader.readLine()) != null){
                builder.append(str);
            }

            return builder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}
