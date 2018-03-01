/**
 * 
 */
package org.rta.coverfox.model;

/**
 * @author arun.verma
 *
 */
public class CustomerCfx {
    private String custName;
    private String custPhone;
    private String custGender;
    private String custMarritalStatus;
    private String custPan;
    private String custOccupation;
    // dd-mm-yyyy
    private String custDOB;
    private String custEmail;
    private String addCityCode;
    private String addDistrict;
    private String addStateCode;
    private String addPinCode;
    private String addConsolidatedAddress;
    private String addSame;
    private String nomineeName;
    private String nomineeRelationship;
    private String nomineeAge;
    private String compPan;
    private String compName;
    private String isCompanyCar;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustGender() {
        return custGender;
    }

    public void setCustGender(String custGender) {
        this.custGender = custGender;
    }

    public String getCustMarritalStatus() {
        return custMarritalStatus;
    }

    public void setCustMarritalStatus(String custMarritalStatus) {
        this.custMarritalStatus = custMarritalStatus;
    }

    public String getCustPan() {
        return custPan;
    }

    public void setCustPan(String custPan) {
        this.custPan = custPan;
    }

    public String getCustOccupation() {
        return custOccupation;
    }

    public void setCustOccupation(String custOccupation) {
        this.custOccupation = custOccupation;
    }

    /**
     * dd-mm-yyyy
     * 
     * @return
     */
    public String getCustDOB() {
        return custDOB;
    }

    /**
     * dd-mm-yyyy
     * 
     * @param custDOB
     */
    public void setCustDOB(String custDOB) {
        this.custDOB = custDOB;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getAddConsolidatedAddress() {
        return addConsolidatedAddress;
    }

    public void setAddConsolidatedAddress(String addConsolidatedAddress) {
        this.addConsolidatedAddress = addConsolidatedAddress;
    }

    public String getAddSame() {
        return addSame;
    }

    public void setAddSame(String addSame) {
        this.addSame = addSame;
    }

    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public String getNomineeRelationship() {
        return nomineeRelationship;
    }

    public void setNomineeRelationship(String nomineeRelationship) {
        this.nomineeRelationship = nomineeRelationship;
    }

    public String getNomineeAge() {
        return nomineeAge;
    }

    public void setNomineeAge(String nomineeAge) {
        this.nomineeAge = nomineeAge;
    }

    public String getCompPan() {
        return compPan;
    }

    public void setCompPan(String compPan) {
        this.compPan = compPan;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getIsCompanyCar() {
        return isCompanyCar;
    }

    public void setIsCompanyCar(String isCompanyCar) {
        this.isCompanyCar = isCompanyCar;
    }

    public String getAddCityCode() {
        return addCityCode;
    }

    public void setAddCityCode(String addCityCode) {
        this.addCityCode = addCityCode;
    }

    public String getAddDistrict() {
        return addDistrict;
    }

    public void setAddDistrict(String addDistrict) {
        this.addDistrict = addDistrict;
    }

    public String getAddStateCode() {
        return addStateCode;
    }

    public void setAddStateCode(String addStateCode) {
        this.addStateCode = addStateCode;
    }

    public String getAddPinCode() {
        return addPinCode;
    }

    public void setAddPinCode(String addPinCode) {
        this.addPinCode = addPinCode;
    }

    @Override
    public String toString() {
        return "CustomerCfx [custName=" + custName + ", custPhone=" + custPhone + ", custGender=" + custGender
                + ", custMarritalStatus=" + custMarritalStatus + ", custPan=" + custPan + ", custOccupation="
                + custOccupation + ", custDOB=" + custDOB + ", custEmail=" + custEmail + ", addCityCode=" + addCityCode
                + ", addDistrict=" + addDistrict + ", addStateCode=" + addStateCode + ", addPinCode=" + addPinCode
                + ", addConsolidatedAddress=" + addConsolidatedAddress + ", addSame=" + addSame + ", nomineeName="
                + nomineeName + ", nomineeRelationship=" + nomineeRelationship + ", nomineeAge=" + nomineeAge
                + ", compPan=" + compPan + ", compName=" + compName + ", isCompanyCar=" + isCompanyCar + "]";
    }

}
