/**
 * 
 */
package org.rta.coverfox.model;

import java.util.Arrays;

/**
 * @author arun.verma
 *
 */
public class VehicleCfx {
    private String isFinanced;
    private String chassisNo;
    private String engineNo;
    private String isCompanyCar;
    private Integer isCNGOrLPGFitted;
    private String[] registrationNumber;
    // dd-mm-yyyy
    private String manufacturingDate;
    // dd-mm-yyyy
    private String registrationDate;
    // dd-mm-yyyy new policy start date for new vehicle
    private String newPolicyStartDate;
    // dd-mm-yyyy new policy start date for new vehicle
    private String pastPolicyExpiryDate;

    public String getIsFinanced() {
        return isFinanced;
    }

    public void setIsFinanced(String isFinanced) {
        this.isFinanced = isFinanced;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getIsCompanyCar() {
        return isCompanyCar;
    }

    public void setIsCompanyCar(String isCompanyCar) {
        this.isCompanyCar = isCompanyCar;
    }

    public Integer getIsCNGOrLPGFitted() {
        return isCNGOrLPGFitted;
    }

    public void setIsCNGOrLPGFitted(Integer isCNGOrLPGFitted) {
        this.isCNGOrLPGFitted = isCNGOrLPGFitted;
    }

    /**
     * Pass the rto code value as ['MH', '01', '0', '0'] for rto MH-01
     * 
     * @return
     */
    public String[] getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Pass the rto code value as ['MH', '01', '0', '0'] for rto MH-01
     * 
     * @param registrationNumber
     */
    public void setRegistrationNumber(String[] registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /**
     * dd-mm-yyyy
     * 
     * @return
     */
    public String getManufacturingDate() {
        return manufacturingDate;
    }

    /**
     * dd-mm-yyyy
     * 
     * @param manufacturingDate
     */
    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    /**
     * dd-mm-yyyy
     * 
     * @return
     */
    public String getRegistrationDate() {
        return registrationDate;
    }

    /**
     * dd-mm-yyyy
     * 
     * @param registrationDate
     */
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * dd-mm-yyyy
     * 
     * @return
     */
    public String getNewPolicyStartDate() {
        return newPolicyStartDate;
    }

    /**
     * dd-mm-yyyy
     * 
     * @param newPolicyStartDate
     */
    public void setNewPolicyStartDate(String newPolicyStartDate) {
        this.newPolicyStartDate = newPolicyStartDate;
    }

    /**
     * dd-mm-yyyy
     * 
     * @return
     */
    public String getPastPolicyExpiryDate() {
        return pastPolicyExpiryDate;
    }

    /**
     * dd-mm-yyyy
     * 
     * @param pastPolicyExpiryDate
     */
    public void setPastPolicyExpiryDate(String pastPolicyExpiryDate) {
        this.pastPolicyExpiryDate = pastPolicyExpiryDate;
    }

    @Override
    public String toString() {
        return "VehicleCfx [isFinanced=" + isFinanced + ", chassisNo=" + chassisNo + ", engineNo=" + engineNo
                + ", isCompanyCar=" + isCompanyCar + ", isCNGOrLPGFitted=" + isCNGOrLPGFitted + ", registrationNumber="
                + Arrays.toString(registrationNumber) + ", manufacturingDate=" + manufacturingDate
                + ", registrationDate=" + registrationDate + ", newPolicyStartDate=" + newPolicyStartDate
                + ", pastPolicyExpiryDate=" + pastPolicyExpiryDate + "]";
    }

}
