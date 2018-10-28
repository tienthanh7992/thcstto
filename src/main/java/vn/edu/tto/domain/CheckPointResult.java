package vn.edu.tto.domain;

import java.sql.Timestamp;

public class CheckPointResult {

    private Long id;
    
    private Long userId;
    
    private Integer selfPoint;
    
    private Integer leaderPoint;
    
    private Integer principalPoint;
    
    private String resultType;
    
    private String status;
    
    private Integer month;
    
    private Boolean isTeamLeader;
    
    private String roleCode;
    
    private String roleName;
    
    private String team;
    
    private String leaderComment;
    
    private String principalComment;
    
    private Timestamp updatedAt;
    
    private Timestamp leaderUpdatedAt;
    
    private Timestamp principalUpdateAt;
    
    private Long leaderId;
    
    private Long principalId;

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

    public Integer getSelfPoint() {
        return selfPoint;
    }

    public void setSelfPoint(Integer selfPoint) {
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

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Boolean getIsTeamLeader() {
		return isTeamLeader;
	}

	public void setIsTeamLeader(Boolean isTeamLeader) {
		this.isTeamLeader = isTeamLeader;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getLeaderComment() {
        return leaderComment;
    }

    public void setLeaderComment(String leaderComment) {
        this.leaderComment = leaderComment;
    }

    public String getPrincipalComment() {
        return principalComment;
    }

    public void setPrincipalComment(String principalComment) {
        this.principalComment = principalComment;
    }

    public Timestamp getLeaderUpdatedAt() {
        return leaderUpdatedAt;
    }

    public void setLeaderUpdatedAt(Timestamp leaderUpdatedAt) {
        this.leaderUpdatedAt = leaderUpdatedAt;
    }

    public Timestamp getPrincipalUpdateAt() {
        return principalUpdateAt;
    }

    public void setPrincipalUpdateAt(Timestamp principalUpdateAt) {
        this.principalUpdateAt = principalUpdateAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

	public Long getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(Long leaderId) {
		this.leaderId = leaderId;
	}

	public Long getPrincipalId() {
		return principalId;
	}

	public void setPrincipalId(Long principalId) {
		this.principalId = principalId;
	}

}
