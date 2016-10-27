package generator.cleaver;

import android.content.Context;
import android.widget.Toast;

import generator.cleaver.model.RegistrationData;

/**
 * Created by Sathish kumar on 4/3/2016.
 */
public class ToastGenRegisterListener implements  OnRegisterListener {
    private Context context;

    public ToastGenRegisterListener(Context context){
        this.context = context;
    }

    @Override
    public String onRegister(RegistrationData data) {
        String toDisplay = "Event Name : " + data.getEvent().getName() + "\nName : " + data.getUserInfo("name")
                + "\nNumber : " + data.getUserInfo("mobileNumber");

        Toast.makeText(context, toDisplay, Toast.LENGTH_SHORT).show();
        return null;
    }
}
