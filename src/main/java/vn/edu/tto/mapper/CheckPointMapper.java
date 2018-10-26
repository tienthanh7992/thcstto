package vn.edu.tto.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import vn.edu.tto.domain.CheckPointResult;
import vn.edu.tto.domain.CheckPointSubmit;

@Mapper
public interface CheckPointMapper {

    public Integer insertSelfCheckPointList(List<CheckPointSubmit> checkPointSubmits) throws SQLException;
    
    public Integer insertCheckPointResult(CheckPointResult checkPointResult);
    
    
    @Select("select * from che_result order by updated_at desc limit 1")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "userId", column = "user_id"),
        @Result(property = "totalPoint", column = "total_point"),
        @Result(property = "resultType", column = "result_type"),
        @Result(property = "status", column = "status"),
        @Result(property = "month", column = "month")
    })
    public CheckPointResult findLastCheResult();
}
