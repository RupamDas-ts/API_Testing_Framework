package Constants;

public final class FrameworkConstants {
    private FrameworkConstants(){}
    public static final String CONFIG_FILE_PATH = "src/main/java/TestConfigSetup/Credentials.yaml";
    public static final String LOGIN_API_PAYLOAD_JSON = "src/test/RequestPayloads/LoginApiPayload.json";
    public static final String HTTPS = "https://";
    public static final String HTTP = "http://";
    public static final String STAGE_INITIALS = "stage-";
    public static final String STAGE_ENDPOINT = ".lambdatestinternal.com";
    public static final String PROD_ENDPOINT = ".lambdatest.com";
}
