package vn.edu.tto.domain;

public class CheckPointSubmit {

    private Long id;
    
    private Long chesId;
    
    private Long userId;
    
    private Long questionId;
    
    private String issue;
    
    private String selfPoint;
    
    private Integer leaderPoint;
    
    private Integer principalPoint;
    
    private Integer finalPoint;
        
    private Integer month;
    
    private String comment;
    
    private String point;

    public CheckPointSubmit() {
		setSelfPoint("-Chọn-");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getChesId() {
		return chesId;
	}

	public void setChesId(Long chesId) {
		this.chesId = chesId;
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

	public Integer getLeaderPoint() {
		return leaderPoint;
	}

	public void setLeaderPoint(Integer leaderPoint) {
		this.leaderPoint = leaderPoint;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "CheckPointSubmit [id=" + id + ", userId=" + userId + ", questionId=" + questionId + ", issue=" + issue
				+ ", selfPoint=" + selfPoint + ", leaderPoint=" + leaderPoint + ", principalPoint=" + principalPoint
				+ ", finalPoint=" + finalPoint + ", month=" + month + "]";
	}
}
