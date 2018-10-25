package vn.edu.tto.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import vn.edu.tto.domain.Question;

@Mapper
public interface QuestionMapper {

    @Select("select * from question where role_id = #{roleId} order by index asc")
    @Results({
        @Result(property = "indexStr", column = "index_str"),
        @Result(property = "startPoint", column = "start_point"),
        @Result(property = "maxPoint", column = "max_point"),
        @Result(property = "isIncrease", column = "is_increase"),
        @Result(property = "questionRole", column = "question_role"),
        @Result(property = "roleId", column = "role_id")
    })
    public List<Question> findQuestionByRole(@Param("roleId") Long roleId);
}
