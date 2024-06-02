package Utils;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import com.github.dzieciou.testing.curl.CurlLoggingRestAssuredConfigFactory;

import java.io.File;
import java.util.Map;

public class APIHelper {
    RestAssuredConfig config = CurlLoggingRestAssuredConfigFactory.createConfig();
    public Map<String, String> makePostRequestAndFetchCookies(String url, File body) {
        Map<String, String> cookies = RestAssured
                .given()
                    .config(config)
                    .header("Content-Type", "application/json")
                    .body(body)
                .when()
                    .post(url)
                .then()
                    .assertThat().statusCode(200)
                    .extract()
                    .cookies();
        System.out.println(cookies);
        return cookies;
    }
}
