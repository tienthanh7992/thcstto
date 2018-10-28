package vn.edu.tto.domain;

public class Question {

    private Long id;
    
    private Integer index;
    
    private String indexStr;
    
    private String content;
    
    private Double startPoint;
    
    private Double maxPoint;
    
    private Boolean isIncrease;
    
    private String questionRole;
    
    private String group;
    
    private Long roleId;

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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Question [id=" + id + ", index=" + index + ", indexStr=" + indexStr + ", content=" + content
                + ", startPoint=" + startPoint + ", maxPoint=" + maxPoint + ", isIncrease=" + isIncrease
                + ", questionRole=" + questionRole + ", group=" + group + ", roleId=" + roleId + ", getId()=" + getId()
                + ", getIndex()=" + getIndex() + ", getIndexStr()=" + getIndexStr() + ", getContent()=" + getContent()
                + ", getStartPoint()=" + getStartPoint() + ", getMaxPoint()=" + getMaxPoint() + ", getIsIncrease()="
                + getIsIncrease() + ", getQuestionRole()=" + getQuestionRole() + ", getGroup()=" + getGroup()
                + ", getRoleId()=" + getRoleId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }
}
