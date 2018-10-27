package vn.edu.tto.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import vn.edu.tto.domain.User;
import vn.edu.tto.domain.UserInfo;

@Mapper
public interface UserMapper {

	@Select("select * from test where user_name = #{userName}")
	public User findUserByUserName(@Param("userName") String userName);
	
	@Select("select * from test where id = #{userId}")
    public User findUserByUserId(@Param("userId") Long userId);
	
	
	@Select("select u.*, r.id as role_id, r.code as roleCode, r.name as roleName from \"user\" u" + 
	        " inner join \"role\" r on u.role_id = r.id" + 
	        " where u.id = #{userId}")
    public UserInfo findUserInfoByUserId(@Param("userId") Long userId);
	
}
