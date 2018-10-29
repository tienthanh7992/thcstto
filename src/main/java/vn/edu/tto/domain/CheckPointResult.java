package vn.edu.tto.domain;

import java.sql.Timestamp;

public class CheckPointResult {

    private Long id;
    
    private Long userId;
    
    private Double selfPoint;
    
    private Double leaderPoint;
    
    private Double principalPoint;
    
    private String resultType;
    
    private String status;
    
    private Integer month;
    
    private Integer year;
    
    private Boolean isTeamLeader;
    
    private String roleCode;
    
    private String roleName;
    
    private String team;
    
    private String leaderComment;
    
    private String principalComment;
    
    private Timestamp updatedAt;
    
    private Timestamp selfCreatedAt;
    
    private Timestamp leaderUpdatedAt;
    
    private Timestamp principalUpdatedAt;
    
    private Long leaderId;
    
    private Long principalId;
    
    private String position;
    
    private String firstName;
    
    private String lastName;
    
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


    public Timestamp getPrincipalUpdatedAt() {
		return principalUpdatedAt;
	}

	public void setPrincipalUpdatedAt(Timestamp principalUpdatedAt) {
		this.principalUpdatedAt = principalUpdatedAt;
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Timestamp getSelfCreatedAt() {
		return selfCreatedAt;
	}

	public void setSelfCreatedAt(Timestamp selfCreatedAt) {
		this.selfCreatedAt = selfCreatedAt;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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
}
