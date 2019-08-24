package cn.lcools.dao;

import cn.lcools.bean.SecFunctions;
import cn.lcools.bean.SecRoleFunGrant;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Set;

@Mapper
public interface SecRoleFunGrantMapper {
    @Delete({
        "delete from SEC_ROLE_FUN_GRANT",
        "where ROLE_GRANT_ID = #{roleGrantId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long roleGrantId);

    @Insert({
        "insert into SEC_ROLE_FUN_GRANT (ROLE_GRANT_ID, ROLE_CODE, ",
        "FUNC_ID, MODIFIER_ID, ",
        "MODIFIER_NAME, MODIFIER_DATE)",
        "values (#{roleGrantId,jdbcType=DECIMAL}, #{roleCode,jdbcType=VARCHAR}, ",
        "#{funcId,jdbcType=DECIMAL}, #{modifierId,jdbcType=DECIMAL}, ",
        "#{modifierName,jdbcType=VARCHAR}, #{modifierDate,jdbcType=TIMESTAMP})"
    })
    int insert(SecRoleFunGrant record);

    @InsertProvider(type=SecRoleFunGrantSqlProvider.class, method="insertSelective")
    int insertSelective(SecRoleFunGrant record);

    @Select({
        "select",
        "ROLE_GRANT_ID, ROLE_CODE, FUNC_ID, MODIFIER_ID, MODIFIER_NAME, MODIFIER_DATE",
        "from SEC_ROLE_FUN_GRANT",
        "where ROLE_GRANT_ID = #{roleGrantId,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ROLE_GRANT_ID", property="roleGrantId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="ROLE_CODE", property="roleCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="FUNC_ID", property="funcId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MODIFIER_ID", property="modifierId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MODIFIER_NAME", property="modifierName", jdbcType=JdbcType.VARCHAR),
        @Result(column="MODIFIER_DATE", property="modifierDate", jdbcType=JdbcType.TIMESTAMP)
    })
    SecRoleFunGrant selectByPrimaryKey(Long roleGrantId);

    @UpdateProvider(type=SecRoleFunGrantSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SecRoleFunGrant record);

    @Update({
        "update SEC_ROLE_FUN_GRANT",
        "set ROLE_CODE = #{roleCode,jdbcType=VARCHAR},",
          "FUNC_ID = #{funcId,jdbcType=DECIMAL},",
          "MODIFIER_ID = #{modifierId,jdbcType=DECIMAL},",
          "MODIFIER_NAME = #{modifierName,jdbcType=VARCHAR},",
          "MODIFIER_DATE = #{modifierDate,jdbcType=TIMESTAMP}",
        "where ROLE_GRANT_ID = #{roleGrantId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(SecRoleFunGrant record);

    @Select({
            "select",
            "t.FUNC_ID",
            "from SEC_ROLE_FUN_GRANT t where t.ROLE_CODE in(",
            "select a.ROLE_CODE from SEC_AUTHORIZE a",
            "where a.USER_ID = #{userId,jdbcType=DECIMAL}",
            ")"
    })
    @Results({
            @Result(column="FUNC_ID", property="funcId", jdbcType=JdbcType.VARCHAR)
    })
    Set<String> selectFuncIdsByUserId(Long userId);

    @Select({
            "select",
            "FUNC_ID, PARENT_ID, FUNC_TYPE, FUNC_NAME, DESCRIPTION, FUNC_IMG, FUNC_URL, FUNC_LEVEL, ",
            "FUNC_INDEX, STATUS, MODIFIER_ID, MODIFIER_NAME, MODIFIER_DATE",
            "from SEC_FUNCTIONS",
            "where FUNC_ID in(",
            "select",
            "t.FUNC_ID",
            "from SEC_ROLE_FUN_GRANT t where t.ROLE_CODE in(",
            "select a.ROLE_CODE from SEC_AUTHORIZE a",
            "where a.USER_ID = #{userId,jdbcType=DECIMAL}",
            ")",
            ")"
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
    List<SecFunctions> selectFuncsByUserId(Long userId);
}