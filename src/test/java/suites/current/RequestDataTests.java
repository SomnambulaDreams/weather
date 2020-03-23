package suites.current;

import constants.Language;
import constants.RequestMethod;
import constants.Route;
import constants.Unit;
import constants.current.Callback;
import constants.current.Query;
import entity.ErrorResponse;
import entity.current.CurrentRequest;
import entity.current.Request;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * <h1>RequestData Tests class</h1>
 * <p>Implements tests for data of 'Current' requests.</p>
 * @since 2020-03-23
 * @see <a href="https://weatherstack.com/documentation#current_weather">Weatherstack Documentation | current</a>
 */
public class RequestDataTests extends CurrentTestClass {


    /**
     * <h2>'Current' functionality: Check Correct Request Data</h2>
     * <p>Test for getting relevant responses for correct requests.</p>
     *
     * <table style="width:100%; border-collapse: collapse; color: #dddddd;">
     *     <tr style="background-color: #333333; border-collapse: collapse; color: white; background-color: #222426;">
     *         <th style="width:30%; padding: 2px;">Test Case Field</th>
     *         <th style="padding: 2px;">Description</th>
     *     </tr>
     *     <tr style="background-color: #3b3d3f;">
     *         <td style="padding: 2px;">Test case ID</td>
     *         <td style="padding: 2px;">
     *             1
     *         </td>
     *     </tr>
     *     <tr style="background-color: #46484a;">
     *         <td style="padding: 2px;">Test Priority</td>
     *         <td style="padding: 2px;">
     *             High
     *         </td>
     *     </tr>
     *     <tr style="background-color: #46484a;">
     *         <td style="padding: 2px;">Title</td>
     *         <td style="padding: 2px;">
     *             'Current' functionality: correct request data (positive test)
     *         </td>
     *     </tr>
     *     <tr style="background-color: #46484a;">
     *         <td style="padding: 2px;">Description / Summary</td>
     *         <td style="padding: 2px;">
     *             Check if relevant responses are received to the requests with correct data
     *         </td>
     *     </tr>
     *     <tr style="background-color: #46484a;">
     *         <td style="padding: 2px;">Test Data</td>
     *         <td style="padding: 2px;">
     *             <ul>
     *                 <li> <b>Query:</b> constants/current/Query.java </li>
     *                 <li> <b>Units:</b> constants/Unit.java</li>
     *                 <li> <b>Language:</b> constants/Language.java</li>
     *                 <li> <b>Callback:</b> constants/current/Callback.java</li>
     *             </ul>
     *         </td>
     *     </tr>
     *     <tr style="background-color: #46484a;">
     *         <td style="padding: 2px;">Pre-condition</td>
     *         <td style="padding: 2px;">
     *             -
     *         </td>
     *     </tr>
     *     <tr style="background-color: #46484a;">
     *         <td style="padding: 2px;">Test Steps</td>
     *         <td style="padding: 2px;">
     *             -
     *         </td>
     *     </tr>
     *     <tr style="background-color: #46484a;">
     *         <td style="padding: 2px;">Expected Results</td>
     *         <td style="padding: 2px;">
     *             Location from response is equals to location pointed in data description.
     *         </td>
     *     </tr>
     *     <tr style="background-color: #46484a;">
     *         <td style="padding: 2px;">Post-condition</td>
     *         <td style="padding: 2px;">
     *             -
     *         </td>
     *     </tr>
     *     <tr style="background-color: #46484a;">
     *         <td style="padding: 2px;">Status<br>(Pass or Fail)</td>
     *         <td style="padding: 2px;">
     *             Pass
     *         </td>
     *     </tr>
     *     <tr style="background-color: #46484a;">
     *         <td style="padding: 2px;">Notes</td>
     *         <td style="padding: 2px;">
     *             Think about test criteria stronger than current one
     *         </td>
     *     </tr>
     *     <tr style="background-color: #46484a;">
     *         <td style="padding: 2px;">Attachments / References</td>
     *         <td style="padding: 2px;">
     *             <a href="https://weatherstack.com/documentation#current_weather">API Documentation</a>
     *         </td>
     *     </tr>
     *     <tr style="background-color: #46484a;">
     *         <td style="padding: 2px;">Is Automated (yes / no)</td>
     *         <td style="padding: 2px;">
     *             yes                              <!-- todo: change here the description -->
     *         </td>
     *     </tr>
     *     <tr style="background-color: #3b3d3f;">
     *         <td style="padding: 2px;">Test Designed by</td>
     *         <td style="padding: 2px;">
     *             Maksym Ivanov                    <!-- todo: change here the description -->
     *         </td>
     *     </tr>
     *     <tr style="background-color: #3b3d3f;">
     *         <td style="padding: 2px;">Date of test designed</td>
     *         <td style="padding: 2px;">
     *             22.03.2020                       <!-- todo: change here the description -->
     *         </td>
     *     </tr>
     *     <tr style="background-color: #3b3d3f;">
     *         <td style="padding: 2px;">Test Executed by</td>
     *         <td style="padding: 2px;">
     *             Maksym Ivanov                    <!-- todo: change here the description -->
     *         </td>
     *     </tr>
     *     <tr style="background-color: #3b3d3f;">
     *         <td style="padding: 2px;">Date of the Test Execution</td>
     *         <td style="padding: 2px;">
     *             22.03.2020                       <!-- todo: change here the description -->
     *         </td>
     *     </tr>
     * </table>
     *
     * @param currentRequest request of 'Current' object
     * @see <a href="https://weatherstack.com/documentation#current_weather">Weatherstack Documentation | current</a>
     */
    @Test(dataProvider = "getCorrectRequestData")
    public void checkCorrectRequestData(CurrentRequest currentRequest) {

        Response response = api.executeRequest(Route.CURRENT.value, RequestMethod.GET, currentRequest);

        Assert.assertTrue(isCountryCorrect(currentRequest, response));
    }


    /**
     * <h2>'Current' functionality: Check access restricted when using Language values</h2>
     * <p>Test for check of getting error-response with 'access restricted' text using any language value accept NULL</p>
     *     <body>
     *         <table style="width:100%; border-collapse: collapse; color: #dddddd;">
     *             <tr style="background-color: #333333; border-collapse: collapse; color: white; background-color: #222426;">
     *                 <th style="width:30%; padding: 2px;">Test Case Field</th>
     *                 <th style="padding: 2px;">Description</th>
     *             </tr>
     *             <tr style="background-color: #3b3d3f;">
     *                 <td style="padding: 2px;">Test case ID</td>
     *                 <td style="padding: 2px;">
     *                     2
     *                 </td>
     *             </tr>
     *             <tr style="background-color: #46484a;">
     *                 <td style="padding: 2px;">Test Priority</td>
     *                 <td style="padding: 2px;">
     *                     Medium
     *                 </td>
     *             </tr>
     *             <tr style="background-color: #46484a;">
     *                 <td style="padding: 2px;">Title</td>
     *                 <td style="padding: 2px;">
     *                     'Current' functionality: Current: access restricted when using Language values
     *                 </td>
     *             </tr>
     *             <tr style="background-color: #46484a;">
     *                 <td style="padding: 2px;">Description / Summary</td>
     *                 <td style="padding: 2px;">
     *                     Check if access restricted when using any language value except NULL
     *                 </td>
     *             </tr>
     *             <tr style="background-color: #46484a;">
     *                 <td style="padding: 2px;">Test Data</td>
     *                 <td style="padding: 2px;">
     *                     <ul>
     *                         <li> <b>Query:</b> constants/current/Query.java (correct value)</li>
     *                         <li> <b>Units:</b> constants/Unit.java (correct value)</li>
     *                         <li> <b>Language:</b> constants/Language.java (all values except NULL)</li>
     *                         <li> <b>Callback:</b> constants/current/Callback.java (correct value)</li>
     *                     </ul>
     *                 </td>
     *             </tr>
     *             <tr style="background-color: #46484a;">
     *                 <td style="padding: 2px;">Pre-condition</td>
     *                 <td style="padding: 2px;">
     *                     -
     *                 </td>
     *             </tr>
     *             <tr style="background-color: #46484a;">
     *                 <td style="padding: 2px;">Test Steps</td>
     *                 <td style="padding: 2px;">
     *                     -
     *                 </td>
     *             </tr>
     *             <tr style="background-color: #46484a;">
     *                 <td style="padding: 2px;">Expected Results</td>
     *                 <td style="padding: 2px;">
     *                     Error Response with info field contains 'access restriction' text is received
     *                 </td>
     *             </tr>
     *             <tr style="background-color: #46484a;">
     *                 <td style="padding: 2px;">Post-condition</td>
     *                 <td style="padding: 2px;">
     *                     -
     *                 </td>
     *             </tr>
     *             <tr style="background-color: #46484a;">
     *                 <td style="padding: 2px;">Status<br>(Pass or Fail)</td>
     *                 <td style="padding: 2px;">
     *                     Pass
     *                 </td>
     *             </tr>
     *             <tr style="background-color: #46484a;">
     *                 <td style="padding: 2px;">Notes</td>
     *                 <td style="padding: 2px;">
     *                     Response message text check change to Response status code check
     *                 </td>
     *             </tr>
     *             <tr style="background-color: #46484a;">
     *                 <td style="padding: 2px;">Attachments / References</td>
     *                 <td style="padding: 2px;">
     *                     <a href="https://weatherstack.com/documentation#current_weather">API Documentation</a>
     *                 </td>
     *             </tr>
     *             <tr style="background-color: #46484a;">
     *                 <td style="padding: 2px;">Is Automated (yes / no)</td>
     *                 <td style="padding: 2px;">
     *                     yes                              <!-- todo: change here the description -->
     *                 </td>
     *             </tr>
     *             <tr style="background-color: #3b3d3f;">
     *                 <td style="padding: 2px;">Test Designed by</td>
     *                 <td style="padding: 2px;">
     *                     Maksym Ivanov                    <!-- todo: change here the description -->
     *                 </td>
     *             </tr>
     *             <tr style="background-color: #3b3d3f;">
     *                 <td style="padding: 2px;">Date of test designed</td>
     *                 <td style="padding: 2px;">
     *                     22.03.2020                       <!-- todo: change here the description -->
     *                 </td>
     *             </tr>
     *             <tr style="background-color: #3b3d3f;">
     *                 <td style="padding: 2px;">Test Executed by</td>
     *                 <td style="padding: 2px;">
     *                     Maksym Ivanov                    <!-- todo: change here the description -->
     *                 </td>
     *             </tr>
     *             <tr style="background-color: #3b3d3f;">
     *                 <td style="padding: 2px;">Date of the Test Execution</td>
     *                 <td style="padding: 2px;">
     *                     22.03.2020                       <!-- todo: change here the description -->
     *                 </td>
     *             </tr>
     *         </table>
     * @param language any Language value (enum) except NULL
     */
    @Test(dataProvider = "getCorrectUnavailableLanguages")
    public void checkAccessRestricted(Language language) {

        CurrentRequest currentRequest = new CurrentRequest(
                Query.CITY_CORRECT_VALUE.value,
                Unit.METRIC.value,
                language.value,
                Callback.CORRECT_VALUE.value);

        Response response = api.executeRequest(Route.CURRENT.value, RequestMethod.GET, currentRequest);

        ErrorResponse errorResponse = null;
        try {
            errorResponse = parseCallback(response, "error",  ErrorResponse.class);
        } catch (Exception ex) {
            Assert.fail();
        }
        Assert.assertTrue(errorResponse.getInfo().contains("Access Restricted"));
    }



    @Test(dataProvider = "getIncorrectCallbacks", enabled = false)
    public void checkIncorrectCallbacks(Callback callback) {

        CurrentRequest currentRequest = new CurrentRequest(
                Query.CITY_CORRECT_VALUE.value,
                Unit.METRIC.value,
                Language.NULL.value,
                callback.value);

        Response response = api.executeRequest(Route.CURRENT.value, RequestMethod.GET, currentRequest);
        System.out.println(response.asString());
        try {
            parseCallback(response, "request", Request.class);
            Assert.fail();
        } catch (NullPointerException npex) {
            Assert.assertTrue(true);
        }
    }


    @Test(dataProvider = "getIncorrectUnits")
    public void checkIncorrectUnits(Unit unit) {

        CurrentRequest currentRequest = new CurrentRequest(
                Query.CITY_CORRECT_VALUE.value,
                unit.value,
                Language.NULL.value,
                Callback.CORRECT_VALUE.value);

        Response response = api.executeRequest(Route.CURRENT.value, RequestMethod.GET, currentRequest);
        System.out.println(response.asString());

        ErrorResponse errorResponse = null;
        try {
            errorResponse = parseCallback(response, "error",  ErrorResponse.class);
        } catch (Exception ex) {
            Assert.fail();
        }
        Assert.assertTrue(errorResponse.getInfo().contains("invalid unit"));
    }


    @Test(dataProvider = "getIncorrectQueries")
    public void checkIncorrectQueries(Query query) {

        CurrentRequest currentRequest = new CurrentRequest(
                query.value,
                Unit.METRIC.value,
                Language.NULL.value,
                Callback.NULL.value);

        Response response = api.executeRequest(Route.CURRENT.value, RequestMethod.GET, currentRequest);
        System.out.println(response.asString());

        ErrorResponse errorResponse = null;
        try {
            errorResponse = response.jsonPath().getObject("error",  ErrorResponse.class);
        } catch (Exception ex) {
            Assert.fail();
        }
        Assert.assertTrue(errorResponse.getCode() == 601 || errorResponse.getCode() == 615);
    }


    @Test
    public void checkIncorrectRoute() {

        CurrentRequest currentRequest = new CurrentRequest(
                Query.CITY_CORRECT_VALUE.value,
                Unit.METRIC.value,
                Language.NULL.value,
                Callback.NULL.value);

        Response response = api.executeRequest("ifYouWannaPartyMoveYourBody", RequestMethod.GET, currentRequest);
        System.out.println(response.asString());

        ErrorResponse errorResponse = null;
        try {
            errorResponse = response.jsonPath().getObject("error",  ErrorResponse.class);
        } catch (Exception ex) {
            Assert.fail();
        }
        Assert.assertTrue(errorResponse.getInfo().contains("API Function does not exist"));
    }
}