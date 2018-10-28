package vn.edu.tto.domain;

public class WorkingDetail {

	private Long id;
	
	private Long questionId;

	private Integer index;

	private String indexStr;

	private String content;

	private Double startPoint;

	private Double maxPoint;

	private Boolean isIncrease;

	private String questionRole;

	private Double selfPoint;
	
	private Double leaderPoint;

	private Double principalPoint;

	private String issue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
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

	public Double getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Double startPoint) {
		this.startPoint = startPoint;
	}

	public Double getMaxPoint() {
		return maxPoint;
	}

	public void setMaxPoint(Double maxPoint) {
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

	public Double getSelfPoint() {
		return selfPoint;
	}

	public void setSelfPoint(Double selfPoint) {
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

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}
}
