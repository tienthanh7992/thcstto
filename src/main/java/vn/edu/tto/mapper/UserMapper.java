package vn.edu.tto.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import vn.edu.tto.domain.User;
import vn.edu.tto.domain.UserInfo;

@Mapper
public interface UserMapper {

	@Select("select * from \"user\" where user_name = #{userName}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "password", column = "password"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "team", column = "team"),
            @Result(property = "position", column = "position"),
            @Result(property = "isTeamLeader", column = "is_team_leader"),
            @Result(property = "roleId", column = "role_id"),
        })
	public User findUserByUserName(@Param("userName") String userName);
	
	@Select("select * from \"user\" where id = #{userId}")
	 @Results({
         @Result(property = "id", column = "id"),
         @Result(property = "userName", column = "user_name"),
         @Result(property = "password", column = "password"),
         @Result(property = "firstName", column = "first_name"),
         @Result(property = "lastName", column = "last_name"),
         @Result(property = "team", column = "team"),
         @Result(property = "position", column = "position"),
         @Result(property = "isTeamLeader", column = "is_team_leader"),
         @Result(property = "roleId", column = "role_id"),
     })
    public User findUserByUserId(@Param("userId") Long userId);
	
	
	@Select("select u.*, r.id as role_id, r.code as role_code, r.name as role_name from \"user\" u" + 
	        " inner join \"role\" r on u.role_id = r.id" + 
	        " where u.user_name = #{userName}")
	@Results({
        @Result(property = "id", column = "id"),
        @Result(property = "userName", column = "user_name"),
        @Result(property = "password", column = "password"),
        @Result(property = "firstName", column = "first_name"),
        @Result(property = "lastName", column = "last_name"),
        @Result(property = "team", column = "team"),
        @Result(property = "position", column = "position"),
        @Result(property = "isTeamLeader", column = "is_team_leader"),
        @Result(property = "roleId", column = "role_id"),
        @Result(property = "roleCode", column = "role_code"),
        @Result(property = "roleName", column = "role_name"),
    })
    public UserInfo findUserInfoByUserName(@Param("userName") String userName);
	
}
