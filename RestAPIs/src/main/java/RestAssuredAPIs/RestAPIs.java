package RestAssuredAPIs;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.response.Response;


import java.util.Map;

import static Common.BaseURI.*;
import static Common.Endpoints.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;

public class RestAPIs {
    @BeforeClass

    public static void setBaseUri() {
        RestAssured.baseURI = baseURL.getBaseURI();
    }
    @Test
    public void testEmployeeAPI(){
               Response response=
                given().log().everything().
                when().
                get(employeesAPI.getEndpointURI()).
                then().assertThat().statusCode(SC_OK).extract().response();
        Map<String, Object> actualResult = response.jsonPath().get("$");
        System.out.println(actualResult);
        Assert.assertEquals(response.getStatusCode(), SC_OK);

    }
    @Test
    public void testEmployeeIdAPI(){

        Response response =
                given().log().everything().
                when().
                get(employeeID.getEndpointURI()).
                then().assertThat().statusCode(SC_BAD_REQUEST).extract().response();
        Map<String, Object> actualResult= response.jsonPath().get("$");
        System.out.println(actualResult);
        Assert.assertEquals(response.getStatusCode(), SC_BAD_REQUEST);
    }

    @Test
    public void testCreateEmpID(){

        Response response=
                given().log().everything().
                when().
                post(createEmpID.getEndpointURI()).
                then().assertThat().extract().response();
        Map<String, Object> actualResult= response.jsonPath().get("$");
        System.out.println(actualResult);
        Assert.assertEquals(response.getStatusCode(), SC_OK);
    }

    @Test
    public void testUpdateEmpID(){

        Response response=
                given().log().everything().
                when().
                put(updateEmpID.getEndpointURI()).
                then().assertThat().extract().response();
        Map<String, Object> actualResult= response.jsonPath().get("$");
        System.out.println(actualResult);
        Assert.assertEquals(response.getStatusCode(), SC_OK);
    }

    @Test
    public void testDeleteEmpID(){
        Response response=
                given().log().everything().
                when().
                delete(deleteEmpID.getEndpointURI()).
                then().assertThat().extract().response();
        Map<String, Object> actualResult= response.jsonPath().get("$");
        System.out.println(actualResult);
        Assert.assertEquals(response.getStatusCode(), SC_OK);
    }
}
