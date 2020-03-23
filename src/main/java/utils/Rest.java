package utils;

import constants.RequestMethod;
import entity.WeatherRequestObject;
import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.exceptions.IncorrectRequestMethod;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static utils.Conversion.getHashMap;


public class Rest {

    private RequestSpecification requestSpecification;


    public Rest() {
        RestAssured.baseURI = Dotenv.load().get("BASE_URI");
    }


    @SafeVarargs
    public final <TObject extends WeatherRequestObject> Response executeRequest(String route, RequestMethod method, TObject... object) {

        Response response = null;

        requestSpecification = given()
                .log().all()
                .accept(ContentType.JSON)
                .queryParam("access_key", Dotenv.load().get("ACCESS_KEY"));
        try {
            response = executeRequestMethod(route, method, object);
        } catch (IncorrectRequestMethod irmex) {
            irmex.printStackTrace();
        }
        return response;
    }


    @SafeVarargs
    private final <TObject extends WeatherRequestObject> Response executeRequestMethod(String route, RequestMethod method, TObject... object) throws IncorrectRequestMethod {

        assert(object.length <= 1);

        if (object.length == 0) {

            if (method.equals(RequestMethod.POST))          return requestSpecification.when().post(route);
            else if (method.equals(RequestMethod.GET))      return requestSpecification.when().get(route);
            else throw new IncorrectRequestMethod("Pay attention! You are trying to use incorrect Request Method");

        } else {

            HashMap<String, String> map = getHashMap(object[0]);
            for(Map.Entry<String, String> entry : map.entrySet()) {
                if(entry.getValue() != null)
                requestSpecification.queryParam(entry.getKey(), entry.getValue());
            }

            if (method.equals(RequestMethod.POST))          return requestSpecification.when().post(route);
            else if (method.equals(RequestMethod.PUT))      return requestSpecification.when().put(route);
            else if (method.equals(RequestMethod.PATCH))    return requestSpecification.when().patch(route);
            else if (method.equals(RequestMethod.DELETE))   return requestSpecification.when().delete(route);
            else if (method.equals(RequestMethod.GET))      return requestSpecification.when().get(route);
            else throw new IncorrectRequestMethod("Pay attention! You are trying to use incorrect Request Method");
        }
    }
}