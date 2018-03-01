/**
 * 
 */
package org.rta.coverfox.handler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import org.rta.coverfox.model.CustomerCfx;
import org.rta.coverfox.model.InsAddOn;
import org.rta.coverfox.model.PaymentCfxModel;
import org.rta.coverfox.model.VehicleCfx;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author arun.verma
 *
 */
public class CoverfoxAPIHandler {

    public static String getUTCDate() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        // Quoted "Z" to indicate, UTC, no timezone offset
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(tz);
        String DATE_VALUE = df.format(new Date());
        return DATE_VALUE;
    }

    public String getQuoteMdl(String vehicleId, VehicleCfx vehicle, InsAddOn addOn) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("addon_isDepreciationWaiver", addOn.getAddonIsDepreciationWaiver());
        jsonMap.put("extra_paPassenger", addOn.getExtraPaPassenger());
        jsonMap.put("cngKitValue", 0);
        jsonMap.put("addon_isAntiTheftFitted", addOn.getAddonIsAntiTheftFitted());
        jsonMap.put("isNewVehicle", 1);
        jsonMap.put("quoteId", "");
        jsonMap.put("idvNonElectrical", addOn.getIdvNonElectrical());
        jsonMap.put("isClaimedLastYear", 0);
        // String[] regNumber = new String[] {"MH", "01", "0", "0"};
        jsonMap.put("registrationNumber[]", vehicle.getRegistrationNumber());
        jsonMap.put("manufacturingDate", vehicle.getManufacturingDate());
        jsonMap.put("registrationDate", vehicle.getRegistrationDate());
        jsonMap.put("idvElectrical", addOn.getIdvElectrical());
        jsonMap.put("addon_is247RoadsideAssistance", addOn.getAddonIs247RoadsideAssistance());
        jsonMap.put("voluntaryDeductible", addOn.getVoluntaryDeductible());
        jsonMap.put("addon_isInvoiceCover", addOn.getAddonIsInvoiceCover());
        jsonMap.put("addon_isDriveThroughProtected", addOn.getAddonIsDriveThroughProtected());
        jsonMap.put("isCNGFitted", vehicle.getIsCNGOrLPGFitted());
        jsonMap.put("vehicleId", vehicleId);
        jsonMap.put("idv", 0);
        jsonMap.put("extra_isLegalLiability", addOn.getExtraIsLegalLiability());
        jsonMap.put("previousNCB", 0);
        jsonMap.put("addon_isEngineProtector", addOn.getAddonIsEngineProtector());
        jsonMap.put("addon_isNcbProtection", addOn.getAddonIsNcbProtection());
        jsonMap.put("addon_isKeyReplacement", addOn.getAddonIsKeyReplacement());
        jsonMap.put("newPolicyStartDate", vehicle.getNewPolicyStartDate());
        jsonMap.put("pastPolicyExpiryDate", vehicle.getPastPolicyExpiryDate());
        jsonMap.put("extra_isAntiTheftFitted", addOn.getExtraIsAntiTheftFitted());
        jsonMap.put("extra_isMemberOfAutoAssociation", addOn.getExtraIsMemberOfAutoAssociation());
        jsonMap.put("isUsedCar", 0);
        jsonMap.put("newNCB", 0);
        jsonMap.put("isNCBCertificate", addOn.getIsNCBCertificate());
        String json = "";
        try {
            json = mapper.writeValueAsString(jsonMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public String getBuyMdl(CustomerCfx customer, VehicleCfx vehicle) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("add_pincode", customer.getAddPinCode());
        jsonMap.put("nominee_relationship", customer.getNomineeRelationship());
        jsonMap.put("cust_email", customer.getCustEmail());
        jsonMap.put("cust_dob", customer.getCustDOB());
        jsonMap.put("is_car_financed", vehicle.getIsFinanced());
        jsonMap.put("cust_occupation", customer.getCustOccupation());
        jsonMap.put("nominee_name", customer.getNomineeName());
        jsonMap.put("past_policy_insurer_city", "");
        jsonMap.put("past_policy_insurer", "");
        jsonMap.put("add_state", customer.getAddStateCode());
        jsonMap.put("cust_pan", customer.getCustPan());
        jsonMap.put("nominee_age", customer.getNomineeAge());
        jsonMap.put("vehicle_reg_no", "");
        jsonMap.put("cust_marital_status", customer.getCustMarritalStatus());
        jsonMap.put("vehicle_chassis_no", vehicle.getChassisNo());
        jsonMap.put("accept_terms", "true");
        jsonMap.put("comp_pan", customer.getCompPan());
        jsonMap.put("add_consolidated_field", customer.getAddConsolidatedAddress());
        jsonMap.put("vehicle_engine_no", vehicle.getEngineNo());
        jsonMap.put("add-same", customer.getAddSame());
        jsonMap.put("past_policy_number", "");
        jsonMap.put("cust_gender", customer.getCustGender());
        jsonMap.put("cust_name", customer.getCustName());
        jsonMap.put("past_policy_cover_type", "");
        jsonMap.put("add_city", customer.getAddCityCode());
        jsonMap.put("cust_phone", customer.getCustPhone());
        jsonMap.put("add_district", customer.getAddDistrict());
        jsonMap.put("comp_name", customer.getCompName());
        jsonMap.put("is_company_car", customer.getIsCompanyCar());
        String json = "";
        try {
            json = mapper.writeValueAsString(jsonMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
    
    public String getPaymentModel(PaymentCfxModel pmtCfx){
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("payment_id", pmtCfx.getPaymentId());
        jsonMap.put("payment_token", pmtCfx.getPaymentId());
        jsonMap.put("datetime", pmtCfx.getDateTime());
        jsonMap.put("status", pmtCfx.getStatus());
        jsonMap.put("amount", pmtCfx.getAmount());
        jsonMap.put("transaction_id", pmtCfx.getTransactionId());
        String json = "";
        try {
            json = mapper.writeValueAsString(jsonMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
