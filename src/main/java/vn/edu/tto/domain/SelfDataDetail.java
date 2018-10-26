package vn.edu.tto.domain;

public class SelfDataDetail {

private Long id;
    
    private Integer index;
    
    private String indexStr;
    
    private String content;
    
    private Integer startPoint;
    
    private Integer maxPoint;
    
    private Boolean isIncrease;
    
    private String questionRole;
    
    private Integer selfPoint;
    
    private Integer principalPoint;
    
    private String issue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getIndexStr() {
        return indexStr;
    }

    public void setIndexStr(String indexStr) {
        this.indexStr = indexStr;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Integer startPoint) {
        this.startPoint = startPoint;
    }

    public Integer getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(Integer maxPoint) {
        this.maxPoint = maxPoint;
    }

    public Boolean getIsIncrease() {
        return isIncrease;
    }

    public void setIsIncrease(Boolean isIncrease) {
        this.isIncrease = isIncrease;
    }

    public String getQuestionRole() {
        return questionRole;
    }

    public void setQuestionRole(String questionRole) {
        this.questionRole = questionRole;
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

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }
}
