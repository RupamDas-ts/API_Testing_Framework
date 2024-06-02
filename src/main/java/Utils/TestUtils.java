package Utils;

import Constants.FrameworkConstants;
import Enums.Environment;
import TestConfigSetup.TestProperties;

import java.io.File;
import java.util.HashMap;

public class TestUtils extends TestHelper {
    APIHelper apiHelper = new APIHelper();
    private static String BEARER_TOKEN;
    public void getBearerTokenViaLogin(String envName){
        HashMap<String, String> property = (HashMap<String, String>) (TestProperties.getProperty(envName));
        String email = property.get("email");
        String password = property.get("password");
        HashMap<String, String> updatedValues = new HashMap<>();
        updatedValues.put("email", email);
        updatedValues.put("password", password);
        updatePayload(updatedValues,FrameworkConstants.LOGIN_API_PAYLOAD_JSON);
        File file = new File(FrameworkConstants.LOGIN_API_PAYLOAD_JSON);
        BEARER_TOKEN = apiHelper.makePostRequestAndFetchCookies(getURI("login",envName), file).get(envName.equalsIgnoreCase(String.valueOf(Environment.STAGE)) ? "stageAccessToken" : "accessToken");
    }
}
