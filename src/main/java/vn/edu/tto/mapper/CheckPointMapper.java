package vn.edu.tto.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import vn.edu.tto.domain.CheckPointResult;
import vn.edu.tto.domain.CheckPointSubmit;

@Mapper
public interface CheckPointMapper {

	public Integer insertSelfCheckPointList(List<CheckPointSubmit> checkPointSubmits) throws SQLException;

	public Integer insertCheckPointResult(CheckPointResult checkPointResult);

	public Integer updateCheckPointSubmitLeader(List<CheckPointSubmit> checkPointSubmits) throws SQLException;

	public Integer updateCheckPointResultLeader(CheckPointResult checkPointResult);
	
	public Integer updateCheckPointSubmitPrincipal(List<CheckPointSubmit> checkPointSubmits) throws SQLException;

	public Integer updateCheckPointResultPrincipal(CheckPointResult checkPointResult);

	@Select("select * from che_result where user_id = #{userId} order by updated_at desc limit 1")
	@Results({ @Result(property = "id", column = "id"), @Result(property = "userId", column = "user_id"),
			@Result(property = "selfPoint", column = "self_point"),
			@Result(property = "resultType", column = "result_type"), @Result(property = "status", column = "status"),
			@Result(property = "month", column = "month"), @Result(property = "leaderPoint", column = "leader_point"),
			@Result(property = "principalPoint", column = "principal_point"),
			@Result(property = "leaderComment", column = "leader_comment"),
			@Result(property = "principalComment", column = "principal_comment"),
			@Result(property = "leaderUpdateAt", column = "leader_update_at"),
			@Result(property = "principalUpdateAt", column = "principal_update_at"),
			@Result(property = "updateAt", column = "update_at") })
	public CheckPointResult findLastCheResult(@Param("userId") Long userId);

	@Select("select * from che_result where id = #{id} and user_id = #{userId}")
	@Results({ @Result(property = "id", column = "id"), @Result(property = "userId", column = "user_id"),
			@Result(property = "selfPoint", column = "self_point"),
			@Result(property = "resultType", column = "result_type"), @Result(property = "status", column = "status"),
			@Result(property = "month", column = "month"), @Result(property = "leaderPoint", column = "leader_point"),
			@Result(property = "principalPoint", column = "principal_point"),
			@Result(property = "leaderComment", column = "leader_comment"),
			@Result(property = "principalComment", column = "principal_comment"),
			@Result(property = "leaderUpdateAt", column = "leader_update_at"),
			@Result(property = "principalUpdateAt", column = "principal_update_at"),
			@Result(property = "updateAt", column = "update_at") })
	public CheckPointResult findCheResultByIdAndUserId(@Param("id") Long id, @Param("userId") Long userId);

	@Select("select cher.*, u.first_name, u.last_name, u.is_team_leader, u.team, u.position, r.code as role_code, r.name as role_name from che_result cher"
			+ " inner join \"user\" u on cher.user_id = u.id" + " inner join \"role\" r on u.role_id = r.id"
			+ " where cher.id = #{id}")
	@Results({ @Result(property = "id", column = "id"), @Result(property = "userId", column = "user_id"),
			@Result(property = "selfPoint", column = "self_point"),
			@Result(property = "resultType", column = "result_type"), @Result(property = "status", column = "status"),
			@Result(property = "month", column = "month"),
			@Result(property = "team", column = "team"),
			@Result(property = "position", column = "position"),
			@Result(property = "year", column = "year"),
			@Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name"),
			@Result(property = "isTeamLeader", column = "is_team_leader"), @Result(property = "team", column = "team"),
			@Result(property = "roleCode", column = "role_code"), @Result(property = "roleName", column = "role_name"),
			@Result(property = "leaderPoint", column = "leader_point"),
			@Result(property = "principalPoint", column = "principal_point"),
			@Result(property = "leaderComment", column = "leader_comment"),
			@Result(property = "principalComment", column = "principal_comment"),
			@Result(property = "leaderId", column = "leader_id"),
			@Result(property = "principalId", column = "principal_id"),
			@Result(property = "leaderUpdateAt", column = "leader_update_at"),
			@Result(property = "principalUpdatedAt", column = "principal_updated_at"),
			@Result(property = "selfCreatedAt", column = "self_created_at") })
	public CheckPointResult findCheResultById(@Param("id") Long id);
	
	@Select("select cher.*, u.is_team_leader, u.team, r.code as role_code, r.name as role_name from che_result cher"
			+ " inner join \"user\" u on cher.user_id = u.id" + " inner join \"role\" r on u.role_id = r.id"
			+ " where cher.id = #{id} and cher.user_id = #{userId}")
	@Results({ @Result(property = "id", column = "id"), @Result(property = "userId", column = "user_id"),
			@Result(property = "selfPoint", column = "self_point"),
			@Result(property = "resultType", column = "result_type"), @Result(property = "status", column = "status"),
			@Result(property = "month", column = "month"),
			@Result(property = "year", column = "year"),
			@Result(property = "isTeamLeader", column = "is_team_leader"), @Result(property = "team", column = "team"),
			@Result(property = "roleCode", column = "role_code"), @Result(property = "roleName", column = "role_name"),
			@Result(property = "leaderPoint", column = "leader_point"),
			@Result(property = "principalPoint", column = "principal_point"),
			@Result(property = "leaderComment", column = "leader_comment"),
			@Result(property = "principalComment", column = "principal_comment"),
			@Result(property = "leaderUpdateAt", column = "leader_update_at"),
			@Result(property = "principalUpdateAt", column = "principal_update_at"),
			@Result(property = "updateAt", column = "update_at") })
	public CheckPointResult findCheResultByIdAndUserIdMoreInfo(@Param("id") Long id, @Param("userId") Long userId);
	
	@Select("select * from che_submit where user_id = #{userId} and month = #{month} and year = #{year}")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "selfPoint", column = "self_point"),
        @Result(property = "leaderPoint", column = "leader_point"),
        @Result(property = "principal_point", column = "principal_point"),
    })
    @MapKey("id") 
    public Map<Long,CheckPointSubmit> findCheckPointSubmitByUserIdAndMonthYear(@Param("userId") Long userId, @Param("month") Integer month, @Param("year") Integer year);
	
	
}
