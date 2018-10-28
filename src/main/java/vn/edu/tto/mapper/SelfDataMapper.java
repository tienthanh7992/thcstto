package vn.edu.tto.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import vn.edu.tto.domain.SelfData;
import vn.edu.tto.domain.SelfDataDetail;

@Mapper
public interface SelfDataMapper {

    @Select("select ches.id as che_result_id, first_name, last_name, \"month\", self_point, principal_point, result_type, status from che_result ches inner join \"user\" u on ches.user_id = u.id and u.user_name = #{userName} order by self_created_at desc")
    @Results({
        @Result(property = "cheResultId", column = "che_result_id"),
        @Result(property = "firstName", column = "first_name"),
        @Result(property = "lastName", column = "last_name"),
        @Result(property = "month", column = "month"),
        @Result(property = "selfPoint", column = "self_point"),
        @Result(property = "principalPoint", column = "principal_point"),
        @Result(property = "resultType", column = "result_type"),
        @Result(property = "status", column = "status")
    })
    public List<SelfData> findSelfDataByUserName(@Param("userName") String userName);
    
    
    @Select("select q.*, ches.self_point as self_point, ches.principal_point as principal_point, ches.issue from question q" + 
            " left join che_submit ches on q.id = ches.question_id and ches.\"month\" = #{month} and ches.user_id = #{userId}" + 
            " order by q.index asc")
    @Results({
        @Result(property = "indexStr", column = "index_str"),
        @Result(property = "startPoint", column = "start_point"),
        @Result(property = "maxPoint", column = "max_point"),
        @Result(property = "isIncrease", column = "is_increase"),
        @Result(property = "questionRole", column = "question_role"),
        @Result(property = "selfPoint", column = "self_point"),
        @Result(property = "principalPoint", column = "principal_point"),
        @Result(property = "issue", column = "issue")
    })
    public List<SelfDataDetail> findSelfDataDetailByUserId(@Param("userId") Long userId, @Param("month") Integer month);
}
