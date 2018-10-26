package vn.edu.tto.domain;

public class SelfData {

    private Long cheResultId;
    
    private String firstName;
    
    private String lastName;
    
    private Integer month;
    
    private Integer selfPoint;
    
    private Integer principalPoint;
    
    private String resultType;
    
    private String status;

    public Long getCheResultId() {
        return cheResultId;
    }

    public void setCheResultId(Long cheResultId) {
        this.cheResultId = cheResultId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getSelfPoint() {
        return selfPoint;
    }

    public void setSelfPoint(Integer selfPoint) {
        this.selfPoint = selfPoint;
    }

    public Integer getPrincipalPoint() {
        return principalPoint;
    }

    public void setPrincipalPoint(Integer principalPoint) {
        this.principalPoint = principalPoint;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
