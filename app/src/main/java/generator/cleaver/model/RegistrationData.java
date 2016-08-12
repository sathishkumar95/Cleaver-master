package generator.cleaver.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Prasanna Lakkur Subramnayam on 4/3/2016.
 */
public class RegistrationData {
    private Event event;
    private Map<String, String> userInfo;

    public RegistrationData(){
        userInfo = new HashMap<>();
    }


    public void setEvent(Event event) {
        this.event = event;
    }

    public void addUserInfo(String key, String value){
        userInfo.put(key, value);
    }

    public Event getEvent() {
        return event;
    }

    public String getUserInfo(String key) {
        return userInfo.get(key);
    }
}
