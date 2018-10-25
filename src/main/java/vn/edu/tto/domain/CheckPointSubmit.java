package vn.edu.tto.domain;

public class CheckPointSubmit {

    private Long id;
    
    private Long userId;
    
    private Long questionId;
    
    private String issue;
    
    private String selfPoint;
    
    private Integer leadPoint;
    
    private Integer principalPoint;
    
    private Integer finalPoint;
        
    private Integer month;

    public CheckPointSubmit() {
		setSelfPoint("-Chọn-");
	}

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

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getSelfPoint() {
		return selfPoint;
	}

	public void setSelfPoint(String selfPoint) {
		this.selfPoint = selfPoint;
	}

	public Integer getLeadPoint() {
		return leadPoint;
	}

	public void setLeadPoint(Integer leadPoint) {
		this.leadPoint = leadPoint;
	}

	public Integer getPrincipalPoint() {
		return principalPoint;
	}

	public void setPrincipalPoint(Integer principalPoint) {
		this.principalPoint = principalPoint;
	}

	public Integer getFinalPoint() {
		return finalPoint;
	}

	public void setFinalPoint(Integer finalPoint) {
		this.finalPoint = finalPoint;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "CheckPointSubmit [id=" + id + ", userId=" + userId + ", questionId=" + questionId + ", issue=" + issue
				+ ", selfPoint=" + selfPoint + ", leadPoint=" + leadPoint + ", principalPoint=" + principalPoint
				+ ", finalPoint=" + finalPoint + ", month=" + month + "]";
	}
}
