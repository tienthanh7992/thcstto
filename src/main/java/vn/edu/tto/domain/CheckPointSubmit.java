package vn.edu.tto.domain;

public class CheckPointSubmit {

    private Long id;
    
    private Long chesId;
    
    private Long userId;
    
    private Long questionId;
    
    private String issue;
    
    private String selfPoint;
    
    private Double leaderPoint;
    
    private Double principalPoint;
    
    private Double finalPoint;
        
    private Integer month;
    
    private Integer year;
    
    private String comment;
    
    private String point;

    public CheckPointSubmit() {
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


	public Double getLeaderPoint() {
		return leaderPoint;
	}

	public void setLeaderPoint(Double leaderPoint) {
		this.leaderPoint = leaderPoint;
	}

	public Double getPrincipalPoint() {
		return principalPoint;
	}

	public void setPrincipalPoint(Double principalPoint) {
		this.principalPoint = principalPoint;
	}

	public Double getFinalPoint() {
		return finalPoint;
	}

	public void setFinalPoint(Double finalPoint) {
		this.finalPoint = finalPoint;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
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
