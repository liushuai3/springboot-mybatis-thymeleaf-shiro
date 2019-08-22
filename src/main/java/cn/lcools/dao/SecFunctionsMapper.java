package cn.lcools.dao;

import cn.lcools.bean.SecFunctions;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SecFunctionsMapper {
    @Delete({
        "delete from SEC_FUNCTIONS",
        "where FUNC_ID = #{funcId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long funcId);

    @Insert({
        "insert into SEC_FUNCTIONS (FUNC_ID, PARENT_ID, ",
        "FUNC_TYPE, FUNC_NAME, ",
        "DESCRIPTION, FUNC_IMG, ",
        "FUNC_URL, FUNC_LEVEL, ",
        "FUNC_INDEX, STATUS, ",
        "MODIFIER_ID, MODIFIER_NAME, ",
        "MODIFIER_DATE)",
        "values (#{funcId,jdbcType=DECIMAL}, #{parentId,jdbcType=DECIMAL}, ",
        "#{funcType,jdbcType=DECIMAL}, #{funcName,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{funcImg,jdbcType=VARCHAR}, ",
        "#{funcUrl,jdbcType=VARCHAR}, #{funcLevel,jdbcType=DECIMAL}, ",
        "#{funcIndex,jdbcType=DECIMAL}, #{status,jdbcType=DECIMAL}, ",
        "#{modifierId,jdbcType=DECIMAL}, #{modifierName,jdbcType=VARCHAR}, ",
        "#{modifierDate,jdbcType=TIMESTAMP})"
    })
    int insert(SecFunctions record);

    @InsertProvider(type=SecFunctionsSqlProvider.class, method="insertSelective")
    int insertSelective(SecFunctions record);

    @Select({
        "select",
        "FUNC_ID, PARENT_ID, FUNC_TYPE, FUNC_NAME, DESCRIPTION, FUNC_IMG, FUNC_URL, FUNC_LEVEL, ",
        "FUNC_INDEX, STATUS, MODIFIER_ID, MODIFIER_NAME, MODIFIER_DATE",
        "from SEC_FUNCTIONS",
        "where FUNC_ID = #{funcId,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="FUNC_ID", property="funcId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="PARENT_ID", property="parentId", jdbcType=JdbcType.DECIMAL),
        @Result(column="FUNC_TYPE", property="funcType", jdbcType=JdbcType.DECIMAL),
        @Result(column="FUNC_NAME", property="funcName", jdbcType=JdbcType.VARCHAR),
        @Result(column="DESCRIPTION", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="FUNC_IMG", property="funcImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="FUNC_URL", property="funcUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="FUNC_LEVEL", property="funcLevel", jdbcType=JdbcType.DECIMAL),
        @Result(column="FUNC_INDEX", property="funcIndex", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="MODIFIER_ID", property="modifierId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MODIFIER_NAME", property="modifierName", jdbcType=JdbcType.VARCHAR),
        @Result(column="MODIFIER_DATE", property="modifierDate", jdbcType=JdbcType.TIMESTAMP)
    })
    SecFunctions selectByPrimaryKey(Long funcId);

    @UpdateProvider(type=SecFunctionsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SecFunctions record);

    @Update({
        "update SEC_FUNCTIONS",
        "set PARENT_ID = #{parentId,jdbcType=DECIMAL},",
          "FUNC_TYPE = #{funcType,jdbcType=DECIMAL},",
          "FUNC_NAME = #{funcName,jdbcType=VARCHAR},",
          "DESCRIPTION = #{description,jdbcType=VARCHAR},",
          "FUNC_IMG = #{funcImg,jdbcType=VARCHAR},",
          "FUNC_URL = #{funcUrl,jdbcType=VARCHAR},",
          "FUNC_LEVEL = #{funcLevel,jdbcType=DECIMAL},",
          "FUNC_INDEX = #{funcIndex,jdbcType=DECIMAL},",
          "STATUS = #{status,jdbcType=DECIMAL},",
          "MODIFIER_ID = #{modifierId,jdbcType=DECIMAL},",
          "MODIFIER_NAME = #{modifierName,jdbcType=VARCHAR},",
          "MODIFIER_DATE = #{modifierDate,jdbcType=TIMESTAMP}",
        "where FUNC_ID = #{funcId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(SecFunctions record);
}