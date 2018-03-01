/**
 * 
 */
package org.rta.coverfox.service.impl;

import org.apache.commons.codec.binary.Base64;
import org.rta.coverfox.cfxapi.APICaller;
import org.rta.coverfox.handler.CoverfoxAPIHandler;
import org.rta.coverfox.model.CustomerCfx;
import org.rta.coverfox.model.InsAddOn;
import org.rta.coverfox.model.PaymentCfxModel;
import org.rta.coverfox.model.VehicleCfx;
import org.rta.coverfox.service.CoverfoxAPIService;
import org.rta.coverfox.util.HMACSHA1Base64;
import org.springframework.http.ResponseEntity;

/**
 * @author arun.verma
 *
 */
public class CoverfoxAPIServiceImpl implements CoverfoxAPIService {

    private static final String AUTHENTICATIONID = "QO6xXCErdV1yDun95rXoesjI3gCkLuYiWyUfXjkX";
    private static final String AUTHENTICATIONKEY =
            "annyEbo38B2GfDfJqICDVexZI2mnMIAhx1AWpjopIaA5fEd7ctbYY1L7RolRjmrMzApjH95wAg8Hx1VpMOhFEQcpimqAocAyZxvgat6ksMitiUyVzE0YqNEDlonZtmxp";
    private static final String HOST = "http://apis.uat.coverfox.com";

    @Override
    public ResponseEntity<?> getVehicleModels(String vehicleType) {
        String data = "";
        String DATE_VALUE = CoverfoxAPIHandler.getUTCDate();
        String path = "/apis/motor/" + vehicleType + "/vehicles/";
        String signature = HMACSHA1Base64.getHMACSHA1Base64(AUTHENTICATIONKEY, path + " " + DATE_VALUE);
        String authorization = "CVFX " + AUTHENTICATIONID + ":" + signature;
        return APICaller.callAPIPost(HOST + path, data, authorization, DATE_VALUE, "application/x-www-form-urlencoded");
    }

    @Override
    public ResponseEntity<?> getVehicleModelVariants(String vehicleType, String modelId, String fuelType) {
        String data = "fuel_type=" + fuelType;
        String DATE_VALUE = CoverfoxAPIHandler.getUTCDate();
        String path = "/apis/motor/" + vehicleType + "/vehicles/" + modelId + "/variants/";
        String signature = HMACSHA1Base64.getHMACSHA1Base64(AUTHENTICATIONKEY, path + " " + DATE_VALUE);
        String authorization = "CVFX " + AUTHENTICATIONID + ":" + signature;
        return APICaller.callAPIPost(HOST + path, data, authorization, DATE_VALUE, "application/x-www-form-urlencoded");
    }

    @Override
    public ResponseEntity<?> getQuotes(String vehicleType, String vehicleId, VehicleCfx vehicle, InsAddOn addOn) {
        CoverfoxAPIHandler handler = new CoverfoxAPIHandler();
        String json = handler.getQuoteMdl(vehicleId, vehicle, addOn);

        String DATE_VALUE = CoverfoxAPIHandler.getUTCDate();
        String path = "/apis/motor/" + vehicleType + "/quotes/";
        String signature = HMACSHA1Base64.getHMACSHA1Base64(AUTHENTICATIONKEY, path + " " + DATE_VALUE);
        String authorization = "CVFX " + AUTHENTICATIONID + ":" + signature;
        return APICaller.callAPIPost(HOST + path, json, authorization, DATE_VALUE, "application/json");
    }

    @Override
    public ResponseEntity<?> refreshQuote(String vehicleType, String quoteId, String insurerSlug, String vehicleId,
            VehicleCfx vehicle, InsAddOn addOn) {
        CoverfoxAPIHandler handler = new CoverfoxAPIHandler();
        String json = handler.getQuoteMdl(vehicleId, vehicle, addOn);

        String DATE_VALUE = CoverfoxAPIHandler.getUTCDate();
        String path = "/apis/motor/" + vehicleType + "/quotes/" + quoteId + "/refresh/" + insurerSlug + "/";
        String signature = HMACSHA1Base64.getHMACSHA1Base64(AUTHENTICATIONKEY, path + " " + DATE_VALUE);
        String authorization = "CVFX " + AUTHENTICATIONID + ":" + signature;
        return APICaller.callAPIPost(HOST + path, json, authorization, DATE_VALUE, "application/json");
    }

    @Override
    public ResponseEntity<?> confirmQuote(String vehicleType, String quoteId, String insurerSlug, String vehicleId,
            VehicleCfx vehicle, InsAddOn addOn) {
        CoverfoxAPIHandler handler = new CoverfoxAPIHandler();
        String json = handler.getQuoteMdl(vehicleId, vehicle, addOn);

        String DATE_VALUE = CoverfoxAPIHandler.getUTCDate();
        String path = "/apis/motor/" + vehicleType + "/confirm/" + quoteId + "/" + insurerSlug + "/";
        String signature = HMACSHA1Base64.getHMACSHA1Base64(AUTHENTICATIONKEY, path + " " + DATE_VALUE);
        String authorization = "CVFX " + AUTHENTICATIONID + ":" + signature;
        return APICaller.callAPIPost(HOST + path, json, authorization, DATE_VALUE, "application/json");
    }

    @Override
    public ResponseEntity<?> retrieveConfirmedQuote(String vehicleType, String transactionId) {
        String path = "/apis/motor/" + vehicleType + "/transaction/" + transactionId + "/quote/";
        String DATE_VALUE = CoverfoxAPIHandler.getUTCDate();
        String signature = HMACSHA1Base64.getHMACSHA1Base64(AUTHENTICATIONKEY, path + " " + DATE_VALUE);
        String authorization = "CVFX " + AUTHENTICATIONID + ":" + signature;
        return APICaller.callAPIGet(HOST + path, authorization, DATE_VALUE);
    }


    @Override
    public ResponseEntity<?> buy(String vehicleType, String insurerSlug, String transactionId, VehicleCfx vehicle,
            CustomerCfx customer) {
        CoverfoxAPIHandler handler = new CoverfoxAPIHandler();
        String json = handler.getBuyMdl(customer, vehicle);

        String DATE_VALUE = CoverfoxAPIHandler.getUTCDate();
        String path = "/apis/motor/" + vehicleType + "/buy/" + insurerSlug + "/" + transactionId + "/";
        String signature = HMACSHA1Base64.getHMACSHA1Base64(AUTHENTICATIONKEY, path + " " + DATE_VALUE);
        String authorization = "CVFX " + AUTHENTICATIONID + ":" + signature;
        return APICaller.callAPIPost(HOST + path, json, authorization, DATE_VALUE, "application/json");
    }

    @Override
    public ResponseEntity<?> retrieveProposalForm(String vehicleType, String transactionId) {
        String DATE_VALUE = CoverfoxAPIHandler.getUTCDate();
        String path = "/apis/motor/" + vehicleType + "/transaction/" + transactionId + "/form/";
        String signature = HMACSHA1Base64.getHMACSHA1Base64(AUTHENTICATIONKEY, path + " " + DATE_VALUE);
        String authorization = "CVFX " + AUTHENTICATIONID + ":" + signature;
        return APICaller.callAPIGet(HOST + path, authorization, DATE_VALUE);
    }

    @Override
    public ResponseEntity<?> getAccessToken(String grantType, String username, String password) {
        String data = "grant_type=" + grantType + "&username=" + username + "&password=" + password;
        String DATE_VALUE = CoverfoxAPIHandler.getUTCDate();
        String path = "/apis/auth/coverfox/token/";
        String signature = new String(Base64.encodeBase64((AUTHENTICATIONID + ":" + AUTHENTICATIONKEY).getBytes()));
        String authorization = "Basic " + signature;
        return APICaller.callAPIPost(HOST + path, data, authorization, DATE_VALUE, "application/x-www-form-urlencoded");
    }

    @Override
    public ResponseEntity<?> retrieveStatusDetails(String vehicleType, String transactionId) {
        String path = "/apis/motor/" + vehicleType + "/transaction/" + transactionId + "/status/";
        String DATE_VALUE = CoverfoxAPIHandler.getUTCDate();
        String signature = HMACSHA1Base64.getHMACSHA1Base64(AUTHENTICATIONKEY, path + " " + DATE_VALUE);
        String authorization = "CVFX " + AUTHENTICATIONID + ":" + signature;
        return APICaller.callAPIGet(HOST + path, authorization, DATE_VALUE);
    }

    @Override
    public ResponseEntity<?> getStates(String vehicleType, String insurerSlug) {
        String path = "/api/motor/" + vehicleType + "/" + insurerSlug + "/states/";
        String DATE_VALUE = CoverfoxAPIHandler.getUTCDate();
        String signature = HMACSHA1Base64.getHMACSHA1Base64(AUTHENTICATIONKEY, path + " " + DATE_VALUE);
        String authorization = "CVFX " + AUTHENTICATIONID + ":" + signature;
        return APICaller.callAPIGet(HOST + path, authorization, DATE_VALUE);
    }

    @Override
    public ResponseEntity<?> getCities(String stateCode, String vehicleType, String insurerSlug) {
        String data = "state=" + stateCode;
        String path = "/apis/motor/" + vehicleType + "/cities/" + insurerSlug + "/";
        String DATE_VALUE = CoverfoxAPIHandler.getUTCDate();
        String signature = HMACSHA1Base64.getHMACSHA1Base64(AUTHENTICATIONKEY, path + " " + DATE_VALUE);
        String authorization = "CVFX " + AUTHENTICATIONID + ":" + signature;
        return APICaller.callAPIPost(HOST + path, data, authorization, DATE_VALUE, "application/x-www-form-urlencoded");
    }

    @Override
    public ResponseEntity<?> getLoanProviders(String vehicleType, String insurerSlug) {
        String path = "/api/motor/" + vehicleType + "/" + insurerSlug + "/loan-providers/";
        String DATE_VALUE = CoverfoxAPIHandler.getUTCDate();
        String signature = HMACSHA1Base64.getHMACSHA1Base64(AUTHENTICATIONKEY, path + " " + DATE_VALUE);
        String authorization = "CVFX " + AUTHENTICATIONID + ":" + signature;
        return APICaller.callAPIGet(HOST + path, authorization, DATE_VALUE);
    }

    @Override
    public ResponseEntity<?> prePayment(String transactionId) {
        String data = "";
        String path = "/apis/pg/coverfox/motor/" + transactionId + "/request/";
        String DATE_VALUE = CoverfoxAPIHandler.getUTCDate();
        String signature = HMACSHA1Base64.getHMACSHA1Base64(AUTHENTICATIONKEY, path + " " + DATE_VALUE);
        String authorization = "CVFX " + AUTHENTICATIONID + ":" + signature;
        return APICaller.callAPIPost(HOST + path, data, authorization, DATE_VALUE, "application/x-www-form-urlencoded");
    }

    @Override
    public ResponseEntity<?> postPayment(PaymentCfxModel paymentCfxModel) {
        CoverfoxAPIHandler handler = new CoverfoxAPIHandler();
        String data = handler.getPaymentModel(paymentCfxModel);
        String path = "/apis/pg/coverfox/response/";
        String DATE_VALUE = CoverfoxAPIHandler.getUTCDate();
        String signature = HMACSHA1Base64.getHMACSHA1Base64(AUTHENTICATIONKEY, path + " " + DATE_VALUE);
        String authorization = "CVFX " + AUTHENTICATIONID + ":" + signature;
        return APICaller.callAPIPost(HOST + path, data, authorization, DATE_VALUE, "application/json");
    }

    @Override
    public ResponseEntity<?> policyAPI(String transactionId) {
        String path = "/apis/v1/motor/policy/" + transactionId + "/";
        String DATE_VALUE = CoverfoxAPIHandler.getUTCDate();
        String signature = HMACSHA1Base64.getHMACSHA1Base64(AUTHENTICATIONKEY, path + " " + DATE_VALUE);
        String authorization = "CVFX " + AUTHENTICATIONID + ":" + signature;
        return APICaller.callAPIGet(HOST + path, authorization, DATE_VALUE);
    }

}
