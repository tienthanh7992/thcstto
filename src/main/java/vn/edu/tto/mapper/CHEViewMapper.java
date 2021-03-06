package vn.edu.tto.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import vn.edu.tto.domain.Working;

@Mapper
public interface CHEViewMapper {

	@Select("select cher.id as che_result_id, u.id as user_id, u.first_name, u.last_name, u.team, u.position, u.is_team_leader,"
			+ " r.code as role_code, r.name as role_name, cher.month, cher.year, cher.self_created_at,"
			+ " cher.status, cher.principal_point, cher.result_type from \"user\" u" + " inner join \"role\" r on u.role_id = r.id"
			+ " inner join che_result cher on u.id = cher.user_id" + " where u.id <> #{userId}"
			+ " and cher.status = 'PRINCIPAL_APPROVED'"
			+ " order by cher.self_created_at desc" + " limit #{limit} offset #{offset}")
	@Results({ @Result(property = "cheResultId", column = "che_result_id"),
			@Result(property = "userId", column = "user_id"), @Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name"), @Result(property = "team", column = "team"),
			@Result(property = "position", column = "position"),
			@Result(property = "principalPoint", column = "principal_point"),
			@Result(property = "resultType", column = "result_type"),
			@Result(property = "isTeamLeader", column = "is_team_leader"),
			@Result(property = "roleCode", column = "role_code"), @Result(property = "roleName", column = "role_name"),
			@Result(property = "month", column = "month"), @Result(property = "year", column = "year"),
			@Result(property = "selfCreatedAt", column = "self_created_at"),
			@Result(property = "status", column = "status") })
	public List<Working> findWorkForPrincipal(@Param("userId") Long userId, @Param("limit") Integer limit,
			@Param("offset") Integer offset);

	@Select("select cher.id as che_result_id, u.id as user_id, u.first_name, u.last_name, u.team, u.position, u.is_team_leader,"
			+ " r.code as role_code, r.name as role_name, cher.month, cher.year, cher.self_created_at,"
			+ " cher.status, cher.principal_point, cher.result_type from \"user\" u" + " inner join \"role\" r on u.role_id = r.id"
			+ " inner join che_result cher on u.id = cher.user_id" + " where u.id <> #{userId}"
			+ " and (r.code = 'TEACHER' and cher.status = 'PRINCIPAL_APPROVED')"
			+ "     or (r.code = 'EMPLOYEE' and cher.status = 'PRINCIPAL_APPROVED')"
			+ " limit #{limit} offset #{offset}")
	@Results({ @Result(property = "cheResultId", column = "che_result_id"),
			@Result(property = "userId", column = "user_id"), @Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name"), @Result(property = "team", column = "team"),
			@Result(property = "position", column = "position"),
			@Result(property = "principalPoint", column = "principal_point"),
			@Result(property = "resultType", column = "result_type"),
			@Result(property = "isTeamLeader", column = "is_team_leader"),
			@Result(property = "roleCode", column = "role_code"), @Result(property = "roleName", column = "role_name"),
			@Result(property = "month", column = "month"),
			@Result(property = "year", column = "year"),
			@Result(property = "selfCreatedAt", column = "self_created_at"),
			@Result(property = "status", column = "status") })
	public List<Working> findWorkForVicePrincipal(@Param("userId") Long userId, @Param("limit") Integer limit,
			@Param("offset") Integer offset);

	@Select("select cher.id as che_result_id, u.id as user_id, u.first_name, u.last_name, u.team, u.position, u.is_team_leader,"
			+ " r.code as role_code, r.name as role_name, cher.month, cher.year, cher.self_created_at,"
			+ " cher.status, cher.principal_point, cher.result_type from \"user\" u" + " inner join \"role\" r on u.role_id = r.id"
			+ " inner join che_result cher on u.id = cher.user_id" + " where u.id <> 2"
			+ " and r.code = #{roleCode} and u.team = #{team} and cher.status = 'PRINCIPAL_APPROVED' and u.is_team_leader = false;")
	@Results({ @Result(property = "cheResultId", column = "che_result_id"),
			@Result(property = "userId", column = "user_id"), @Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name"), @Result(property = "team", column = "team"),
			@Result(property = "position", column = "position"),
			@Result(property = "principalPoint", column = "principal_point"),
			@Result(property = "resultType", column = "result_type"),
			@Result(property = "isTeamLeader", column = "is_team_leader"),
			@Result(property = "roleCode", column = "role_code"), @Result(property = "roleName", column = "role_name"),
			@Result(property = "month", column = "month"), @Result(property = "year", column = "year"),
			@Result(property = "selfCreatedAt", column = "self_created_at"),
			@Result(property = "status", column = "status") })
	public List<Working> findWorkForLeader(@Param("userId") Long userId, @Param("roleCode") String codeRole,
			@Param("team") String team, @Param("limit") Integer limit, @Param("offset") Integer offset);

}
