package vn.edu.tto.domain;

import java.sql.Timestamp;

public class Working {
    
    private long cheResultId;

    private Long userId;

    private String firstName;

    private String lastName;

    private String team;

    private String position;

    private Boolean isTeamLeader;
    
    private String roleCode;
    
    private String roleName;
    
    private Integer month;
    
    private Integer year;
    
    private Timestamp selfCreatedAt;
    
    private String status;

    public long getCheResultId() {
        return cheResultId;
    }

    public void setCheResultId(long cheResultId) {
        this.cheResultId = cheResultId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public Timestamp getSelfCreatedAt() {
        return selfCreatedAt;
    }

    public void setSelfCreatedAt(Timestamp selfCreatedAt) {
        this.selfCreatedAt = selfCreatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
