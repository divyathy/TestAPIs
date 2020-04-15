package RestAssuredAPIs;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.response.Response;


import java.util.Map;

import static Common.BaseURI.sampleURI;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class RestAPIs {
    @BeforeClass

    public static void setBaseUri() {
        RestAssured.baseURI = sampleURI.getBaseURI();
    }

    @Test
    public void testSeleniumScripts(){

        Response response=
                given().log().everything().
                        when().
                        get(baseURI).
                        then().assertThat().statusCode(SC_OK).extract().response();
        Map<String, Object> actualResult = response.jsonPath().get("$");
        System.out.println(actualResult);

    }
}
