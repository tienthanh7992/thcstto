package vn.edu.tto.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import vn.edu.tto.domain.User;

@Mapper
public interface UserMapper {

	@Select("select * from test where user_name = #{userName}")
	public User findByUserName(@Param("userName") String userName);
}
