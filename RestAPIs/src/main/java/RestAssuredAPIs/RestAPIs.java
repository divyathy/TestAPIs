package RestAssuredAPIs;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.response.Response;


import java.util.Map;

import static Common.BaseURI.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;

public class RestAPIs {
    @BeforeClass

    public static void setBaseUri() {
        RestAssured.baseURI = sampleURI.getBaseURI();
    }
    @Test
    public void testEmployeeAPI(){
        RestAssured.baseURI = sampleURI.getBaseURI();
        Response response=
                given().log().everything().
                        when().
                        get(baseURI).
                        then().assertThat().statusCode(SC_OK).extract().response();
        Map<String, Object> actualResult = response.jsonPath().get("$");
        System.out.println(actualResult);

    }
    @Test
    public void testEmployeeIdAPI(){
        RestAssured.baseURI = employeeURI.getBaseURI();
        Response response =
                given().log().everything().
                        when().
                        get(baseURI).
                        then().assertThat().statusCode(SC_BAD_REQUEST).extract().response();
        Map<String, Object> actualResult= response.jsonPath().get("$");
        System.out.println(actualResult);
    }

    @Test
    public void testCreateEmpID(){
        baseURI= createEmployeeID.getBaseURI();
        Response response=
                given().log().everything().
                        when().
                        post(baseURI).
                        then().assertThat().extract().response();
        Map<String, Object> actualResult= response.jsonPath().get("$");
        System.out.println(actualResult);
    }

    @Test
    public void testUpdateEmpID(){
        baseURI=updateEmployeeID.getBaseURI();
        Response response=
                given().log().everything().
                        when()
                .put(baseURI)
                .then().assertThat().extract().response();
        Map<String, Object> actualResult= response.jsonPath().get("$");
        System.out.println(actualResult);
    }

    @Test
    public void testDeleteEmpID(){
        baseURI=deleteEmployeeID.getBaseURI();
        Response response=
                given().log().everything()
                .when()
                .delete(baseURI)
                .then().assertThat().extract().response();
        Map<String, Object> actualResult= response.jsonPath().get("$");
        System.out.println(actualResult);
    }
}
