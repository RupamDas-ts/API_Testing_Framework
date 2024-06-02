package Utils;

import Enums.Environment;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static Constants.FrameworkConstants.*;

public class TestHelper {
    protected void updatePayload(HashMap<String, String> payload, String payloadPath){
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(payloadPath);
        try {
            Map<String, Object> payloadMap = mapper.readValue(file, Map.class);
            payloadMap.putAll(payload);
            mapper.writeValue(file, payloadMap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected String getURI(String purpose, String env){
        String uri;
        switch(purpose){
            case "login":
                uri = createURI("auth","/api/login",env);
                break;
            default:
                uri = "";
                break;
        }
        System.out.println("uri: "+uri);
        return uri;
    }

    private String createURI(String start, String end, String env){
        if(env.equalsIgnoreCase(String.valueOf(Environment.PRODUCTION)))
            return HTTPS + start + PROD_ENDPOINT + end;
        else
            return HTTPS + STAGE_INITIALS + start + STAGE_ENDPOINT + end;
    }
}
