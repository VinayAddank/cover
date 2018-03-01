/**
 * 
 */
package org.rta.coverfox.service;

import org.rta.coverfox.model.CustomerCfx;
import org.rta.coverfox.model.InsAddOn;
import org.rta.coverfox.model.PaymentCfxModel;
import org.rta.coverfox.model.VehicleCfx;
import org.springframework.http.ResponseEntity;

/**
 * @author arun.verma
 *
 */
public interface CoverfoxAPIService {

    /**
     * Get list of Vehicle Models
     * 
     * @param vehicleType
     * @return ResponseEntity
     */
    public ResponseEntity<?> getVehicleModels(String vehicleType);

    /**
     * Get list of Vehicle Model Variants
     * 
     * @param vehicleType
     * @param modelId
     * @param fuelType
     * @return ResponseEntity
     */
    public ResponseEntity<?> getVehicleModelVariants(String vehicleType, String modelId, String fuelType);

    /**
     * Get list of quotes(policies)
     * 
     * @param vehicleType
     * @param vehicleId
     * @param vehicle
     * @param addOn
     * @return ResponseEntity
     */
    public ResponseEntity<?> getQuotes(String vehicleType, String vehicleId, VehicleCfx vehicle, InsAddOn addOn);

    /**
     * refreshQuote
     * 
     * @param vehicleType
     * @param quoteId
     * @param insurerSlug
     * @param vehicleId
     * @param vehicle
     * @param addOn
     * @return ResponseEntity
     */
    public ResponseEntity<?> refreshQuote(String vehicleType, String quoteId, String insurerSlug, String vehicleId, VehicleCfx vehicle, InsAddOn addOn);

    /**
     * confirmQuote
     * 
     * @param vehicleType
     * @param quoteId
     * @param insurerSlug
     * @param vehicleId
     * @param vehicle
     * @param addOn
     * @return ResponseEntity
     */
    public ResponseEntity<?> confirmQuote(String vehicleType, String quoteId, String insurerSlug, String vehicleId, VehicleCfx vehicle, InsAddOn addOn);

    /**
     * getAccessToken
     * 
     * @param grantType
     * @param username
     * @param password
     * @return ResponseEntity
     */
    public ResponseEntity<?> getAccessToken(String grantType, String username, String password);
    
    /**
     * Get getStates
     * 
     * @param vehicleType
     * @param insurerSlug
     * @return ResponseEntity
     */
    public ResponseEntity<?> getStates(String vehicleType, String insurerSlug);
    
    /**
     * Get getCities
     * 
     * @param stateCode
     * @param vehicleType
     * @param insurerSlug
     * @return ResponseEntity
     */
    public ResponseEntity<?> getCities(String stateCode, String vehicleType, String insurerSlug);
    
    /**
     * Get getLoanProviders
     * 
     * @param vehicleType
     * @param insurerSlug
     * @return ResponseEntity
     */
    public ResponseEntity<?> getLoanProviders(String vehicleType, String insurerSlug);

    /**
     * buy insurance
     * 
     * @param vehicleType
     * @param insurerSlug
     * @param transactionId
     * @param vehicle
     * @param customer
     * @return ResponseEntity
     */
    public ResponseEntity<?> buy(String vehicleType, String insurerSlug, String transactionId, VehicleCfx vehicle, CustomerCfx customer);


    /**
     * retrieveConfirmedQuote
     * 
     * @param vehicleType
     * @param transactionId
     * @return ResponseEntity
     */
    public ResponseEntity<?> retrieveConfirmedQuote(String vehicleType, String transactionId);

    /**
     * retrieveProposalForm
     * 
     * @param vehicleType
     * @param transactionId
     * @return returns Json String
     */
    public ResponseEntity<?> retrieveProposalForm(String vehicleType, String transactionId);

    /**
     * retrieveStatusDetails
     * 
     * @param vehicleType
     * @param transactionId
     * @return ResponseEntity
     */
    public ResponseEntity<?> retrieveStatusDetails(String vehicleType, String transactionId);
    
    /**
     * PrePayment
     * 
     * @param transactionId
     * @return ResponseEntity
     */
    public ResponseEntity<?> prePayment(String transactionId);
    
    /**
     * Post Payment
     * @param PaymentCfxModel
     * @return ResponseEntity
     */
    public ResponseEntity<?> postPayment(PaymentCfxModel paymentCfxModel);
    
    /**
     * Get policyAPI Details
     * 
     * @param transactionId
     * @return ResponseEntity
     */
    public ResponseEntity<?> policyAPI(String transactionId);
    
}
