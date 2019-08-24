package cn.lcools.dao;

import cn.lcools.bean.SecAuthorize;
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
public interface SecAuthorizeMapper {
    @Delete({
        "delete from SEC_AUTHORIZE",
        "where AUTHORIZE_ID = #{authorizeId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long authorizeId);

    @Insert({
        "insert into SEC_AUTHORIZE (AUTHORIZE_ID, USER_ID, ",
        "ROLE_CODE, MODIFIER_ID, ",
        "MODIFIER_NAME, MODIFIER_DATE)",
        "values (#{authorizeId,jdbcType=DECIMAL}, #{userId,jdbcType=DECIMAL}, ",
        "#{roleCode,jdbcType=VARCHAR}, #{modifierId,jdbcType=DECIMAL}, ",
        "#{modifierName,jdbcType=VARCHAR}, #{modifierDate,jdbcType=TIMESTAMP})"
    })
    int insert(SecAuthorize record);

    @InsertProvider(type=SecAuthorizeSqlProvider.class, method="insertSelective")
    int insertSelective(SecAuthorize record);

    @Select({
        "select",
        "AUTHORIZE_ID, USER_ID, ROLE_CODE, MODIFIER_ID, MODIFIER_NAME, MODIFIER_DATE",
        "from SEC_AUTHORIZE",
        "where AUTHORIZE_ID = #{authorizeId,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="AUTHORIZE_ID", property="authorizeId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.DECIMAL),
        @Result(column="ROLE_CODE", property="roleCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="MODIFIER_ID", property="modifierId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MODIFIER_NAME", property="modifierName", jdbcType=JdbcType.VARCHAR),
        @Result(column="MODIFIER_DATE", property="modifierDate", jdbcType=JdbcType.TIMESTAMP)
    })
    SecAuthorize selectByPrimaryKey(Long authorizeId);

    @UpdateProvider(type=SecAuthorizeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SecAuthorize record);

    @Update({
        "update SEC_AUTHORIZE",
        "set USER_ID = #{userId,jdbcType=DECIMAL},",
          "ROLE_CODE = #{roleCode,jdbcType=VARCHAR},",
          "MODIFIER_ID = #{modifierId,jdbcType=DECIMAL},",
          "MODIFIER_NAME = #{modifierName,jdbcType=VARCHAR},",
          "MODIFIER_DATE = #{modifierDate,jdbcType=TIMESTAMP}",
        "where AUTHORIZE_ID = #{authorizeId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(SecAuthorize record);

    @Select({
            "select",
            "AUTHORIZE_ID, USER_ID, ROLE_CODE, MODIFIER_ID, MODIFIER_NAME, MODIFIER_DATE",
            "from SEC_AUTHORIZE",
            "where USER_ID = #{userId,jdbcType=DECIMAL}"
    })
    @Results({
            @Result(column="AUTHORIZE_ID", property="authorizeId", jdbcType=JdbcType.DECIMAL, id=true),
            @Result(column="USER_ID", property="userId", jdbcType=JdbcType.DECIMAL),
            @Result(column="ROLE_CODE", property="roleCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="MODIFIER_ID", property="modifierId", jdbcType=JdbcType.DECIMAL),
            @Result(column="MODIFIER_NAME", property="modifierName", jdbcType=JdbcType.VARCHAR),
            @Result(column="MODIFIER_DATE", property="modifierDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SecAuthorize> selectByUserId(Long userId);

    @Select({
            "select",
            "ROLE_CODE",
            "from SEC_AUTHORIZE",
            "where USER_ID = #{userId,jdbcType=DECIMAL}"
    })
    @Results({
            @Result(column="ROLE_CODE", property="roleCode", jdbcType=JdbcType.VARCHAR),

    })
    Set<String> selectRoleCodesByUserId(Long userId);
}