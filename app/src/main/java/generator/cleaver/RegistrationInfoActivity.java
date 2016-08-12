package generator.cleaver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import generator.cleaver.model.RegistrationData;

public class RegistrationInfoActivity extends AppCompatActivity {
    private int categoryNumber, eventNumber;
    private OnRegisterListener onRegisterListener;
    private EditText nameEditText, mobileNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_info);

        onRegisterListener = new ToastGenRegisterListener(this);


        nameEditText = (EditText)findViewById(R.id.registrationNameEditText);
        mobileNumberEditText = (EditText)findViewById(R.id.registrationMobileNumberEditText);

        Bundle bundle = getIntent().getExtras();

        categoryNumber = bundle.getInt(MainActivity.CATEGORY_NUMBER, -1);
        eventNumber = bundle.getInt(MainActivity.EVENT_NUMBER, -1);


    }


    public void submitInfo(View view) {
        if(categoryNumber != -1 && eventNumber != -1) {
            RegistrationData data = new RegistrationData();
            data.setEvent(ModelSingleton.getInstance(this).getModel().getCategory().get(categoryNumber).getEvents().get(eventNumber));
            //TODO replace this with whatever is passed in by the user in the file (after the update)
            data.addUserInfo("name", nameEditText.getText().toString());
            data.addUserInfo("mobileNumber", mobileNumberEditText.getText().toString());
            onRegisterListener.onRegister(data);
        }
    }
}
