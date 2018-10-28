package vn.edu.tto.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import vn.edu.tto.domain.SelfDataDetail;
import vn.edu.tto.domain.Working;
import vn.edu.tto.domain.WorkingDetail;

@Mapper
public interface WorkMapper {

    @Select("select cher.id as che_result_id, u.id as user_id, u.first_name, u.last_name, u.team, u.position, u.is_team_leader," + 
            " r.code as role_code, r.name as role_name, cher.month, cher.year, cher.self_created_at," + 
            " cher.status from \"user\" u" + 
            " inner join \"role\" r on u.role_id = r.id" + 
            " inner join che_result cher on u.id = cher.user_id" + 
            " where u.id <> #{userId}" + 
            " and ((r.code = 'VICE_PRINCIPAL' and cher.status = 'PENDING')" + 
            "     or (r.code = 'TEACHER' and (u.is_team_leader or cher.status = 'LEADER_APPROVED'))" + 
            "     or (r.code = 'EMPLOYEE' and (u.is_team_leader or cher.status = 'LEADER_APPROVED'))" + 
            "    )" + 
            " order by cher.self_created_at asc" +
            " limit #{limit} offset #{offset}")
    @Results({
        @Result(property = "cheResultId", column = "che_result_id"),
        @Result(property = "userId", column = "user_id"),
        @Result(property = "firstName", column = "first_name"),
        @Result(property = "lastName", column = "last_name"),
        @Result(property = "team", column = "team"),
        @Result(property = "position", column = "position"),
        @Result(property = "isTeamLeader", column = "is_team_leader"),
        @Result(property = "roleCode", column = "role_code"),
        @Result(property = "roleName", column = "role_name"),
        @Result(property = "month", column = "month"),
        @Result(property = "year", column = "year"),
        @Result(property = "selfCreatedAt", column = "self_created_at"),
        @Result(property = "status", column = "status")
    })
    public List<Working> findWorkForPrincipal(@Param("userId") Long userId, @Param("limit") Integer limit, @Param("offset") Integer offset);
    
    
    @Select("select cher.id as che_result_id, u.id as user_id, u.first_name, u.last_name, u.team, u.position, u.is_team_leader," + 
            " r.code as role_code, r.name as role_name, cher.month, cher.year, cher.self_created_at," + 
            " cher.status from \"user\" u" + 
            " inner join \"role\" r on u.role_id = r.id" + 
            " inner join che_result cher on u.id = cher.user_id" + 
            " where u.id <> #{userId}" + 
            " and (r.code = 'TEACHER' and ((u.is_team_leader and cher.status = 'PENDING') or cher.status = 'LEADER_APPROVED'))" + 
            "     or (r.code = 'EMPLOYEE' and ((u.is_team_leader and cher.status = 'PENDING') or cher.status = 'LEADER_APPROVED'))" + 
            " limit #{limit} offset #{offset}")
    @Results({
        @Result(property = "cheResultId", column = "che_result_id"),
        @Result(property = "userId", column = "user_id"),
        @Result(property = "firstName", column = "first_name"),
        @Result(property = "lastName", column = "last_name"),
        @Result(property = "team", column = "team"),
        @Result(property = "position", column = "position"),
        @Result(property = "isTeamLeader", column = "is_team_leader"),
        @Result(property = "roleCode", column = "role_code"),
        @Result(property = "roleName", column = "role_name"),
        @Result(property = "month", column = "month"),
        @Result(property = "year", column = "year"),
        @Result(property = "selfCreatedAt", column = "self_created_at"),
        @Result(property = "status", column = "status")
    })
    public List<Working> findWorkForVicePrincipal(@Param("userId") Long userId, @Param("limit") Integer limit, @Param("offset") Integer offset);
    
    @Select("select cher.id as che_result_id, u.id as user_id, u.first_name, u.last_name, u.team, u.position, u.is_team_leader," + 
            " r.code as role_code, r.name as role_name, cher.month, cher.year, cher.self_created_at," + 
            " cher.status from \"user\" u" + 
            " inner join \"role\" r on u.role_id = r.id" + 
            " inner join che_result cher on u.id = cher.user_id" + 
            " where u.id <> 2" + 
            " and r.code = #{roleCode} and u.team = #{team} and cher.status = 'PENDING' and u.is_team_leader = false;")
    @Results({
        @Result(property = "cheResultId", column = "che_result_id"),
        @Result(property = "userId", column = "user_id"),
        @Result(property = "firstName", column = "first_name"),
        @Result(property = "lastName", column = "last_name"),
        @Result(property = "team", column = "team"),
        @Result(property = "position", column = "position"),
        @Result(property = "isTeamLeader", column = "is_team_leader"),
        @Result(property = "roleCode", column = "role_code"),
        @Result(property = "roleName", column = "role_name"),
        @Result(property = "month", column = "month"),
        @Result(property = "year", column = "year"),
        @Result(property = "selfCreatedAt", column = "self_created_at"),
        @Result(property = "status", column = "status")
    })
    public List<Working> findWorkForLeader(@Param("userId") Long userId, @Param("roleCode") String codeRole, @Param("team") String team, @Param("limit") Integer limit, @Param("offset") Integer offset);

    @Select("select q.*, ches.self_point, ches.leader_point, ches.principal_point, ches.issue from question q" + 
            " left join che_submit ches on q.id = ches.question_id and ches.\"month\" = #{month} and ches.user_id = #{userId}" + 
            " order by q.index asc")
    @Results({
        @Result(property = "indexStr", column = "index_str"),
        @Result(property = "startPoint", column = "start_point"),
        @Result(property = "maxPoint", column = "max_point"),
        @Result(property = "isIncrease", column = "is_increase"),
        @Result(property = "questionRole", column = "question_role"),
        @Result(property = "selfPoint", column = "self_point"),
        @Result(property = "leaderPoint", column = "leader_point"),
        @Result(property = "principalPoint", column = "principal_point"),
        @Result(property = "issue", column = "issue")
    })
    public List<WorkingDetail> findWorkingDetailByUserId(@Param("userId") Long userId, @Param("month") Integer month);
}
