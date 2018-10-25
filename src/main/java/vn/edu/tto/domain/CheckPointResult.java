package vn.edu.tto.domain;

public class CheckPointResult {

    private Long id;
    
    private Long userId;
    
    private Long totalPoint;
    
    private Long resultType;
    
    private String status;
    
    private String month;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(Long totalPoint) {
        this.totalPoint = totalPoint;
    }

    public Long getResultType() {
        return resultType;
    }

    public void setResultType(Long resultType) {
        this.resultType = resultType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
