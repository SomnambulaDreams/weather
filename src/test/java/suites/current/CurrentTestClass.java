package suites.current;

import com.google.gson.Gson;
import constants.Language;
import constants.Unit;
import constants.current.Callback;
import constants.current.Query;
import entity.ErrorResponse;
import entity.current.Current;
import entity.current.CurrentRequest;
import entity.current.Location;
import entity.current.Request;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import suites.ApiSuite;

import java.util.LinkedList;
import java.util.List;

import static constants.Language.getCorrectUnavailableValues;

/**
 * <h1>API TestClass (testNG)</h1>
 * <p>Generates objects for testing 'Current' functionality.</p>
 * <p>Generate data-providers for tests.</p>
 * @since 2020-03-23
 * @see <a href="https://weatherstack.com/documentation#current_weather">Weatherstack Documentation | current</a>
 */
public class CurrentTestClass extends ApiSuite {

    protected CurrentRequest currentRequest;
    protected Current current;
    protected Location location;
    protected Request request;


    @BeforeClass
    public void setApiObjects() {
        currentRequest = new CurrentRequest();
        current = new Current();
        location = new Location();
        request = new Request();
    }


    // data providers ==================================================================================================

    @DataProvider
    protected Object[] getCorrectQueries() {
        return Query.getCorrectValues();
    }

    @DataProvider
    protected Object[] getIncorrectQueries() {
        return Query.getIncorrectValues();
    }

    @DataProvider
    protected Object[] getCorrectUnits() {
        return Unit.getCorrectValues();
    }

    @DataProvider
    protected Object[] getIncorrectUnits() {
        return Unit.getIncorrectValues();
    }

    @DataProvider
    protected Object[] getCorrectLanguages() {
        return Language.getCorrectValues();
    }

    @DataProvider
    protected Object[] getIncorrectLanguages() {
        return Language.getIncorrectValues();
    }

    @DataProvider
    protected Object[] getCorrectUnavailableLanguages() {
        return Language.getCorrectUnavailableValues();
    }

    @DataProvider
    protected Object[] getCorrectCallbacks() {
        return Callback.getCorrectValues();
    }

    @DataProvider
    protected Object[] getIncorrectCallbacks() {
        return Callback.getIncorrectValues();
    }

    @DataProvider
    protected Object[] getCorrectRequestData() {
        List<CurrentRequest> result = new LinkedList<>();
        for(Query query : Query.values()) {
            for(Unit unit : Unit.values()) {
//                for(Language language : Language.values()) {
//                    for(Callback callback : Callback.values()) {
                        if(query.isCorrect && unit.isCorrect)
                            result.add(new CurrentRequest(query.value, unit.value, null, null));
//                    }
//                }
            }
        }
        return result.toArray();
    }


    protected boolean isCountryCorrect(CurrentRequest currentRequest, Response response) {
        boolean result = false;

        Location location = response.jsonPath().getObject("location", Location.class);
        String country = location.getCountry();

        String queryDescription = "";
        for(Query item : Query.values()) {
            if(item.value.equals(currentRequest.getQuery())) {
                queryDescription = item.description;
            }
        }
        if(queryDescription.contains(country))
            result = true;
        return result;
    }


    protected <T> T parseCallback(Response response, String path, Class<T> clazz) {
        String value = response.asString();
        value = value.substring(value.indexOf("(") + 1, value.indexOf(")"));

        JsonPath jsonPath = JsonPath.from(value);
        T result = jsonPath.getObject(path, clazz);
        return result;
    }
}