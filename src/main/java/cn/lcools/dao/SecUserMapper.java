package cn.lcools.dao;

import cn.lcools.bean.SecUser;
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

@Mapper
public interface SecUserMapper {
    @Delete({
        "delete from SEC_USER",
        "where USER_ID = #{userId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long userId);

    @Insert({
        "insert into SEC_USER (USER_ID, USER_CODE, ",
        "PLAINTEXT_PASSWORD, PASSWORD, ",
        "USERNAME, PHONE, ",
        "EMAIL, DESCRIPTION, ",
        "IS_ADMIN, STATUS, ",
        "CREATE_DATE, CREATOR_ID, ",
        "CREATOR_NAME, MODIFIER_ID, ",
        "MODIFIER_NAME, MODIFIER_DATE)",
        "values (#{userId,jdbcType=DECIMAL}, #{userCode,jdbcType=VARCHAR}, ",
        "#{plaintextPassword,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{username,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{isAdmin,jdbcType=DECIMAL}, #{status,jdbcType=DECIMAL}, ",
        "#{createDate,jdbcType=TIMESTAMP}, #{creatorId,jdbcType=DECIMAL}, ",
        "#{creatorName,jdbcType=VARCHAR}, #{modifierId,jdbcType=DECIMAL}, ",
        "#{modifierName,jdbcType=VARCHAR}, #{modifierDate,jdbcType=TIMESTAMP})"
    })
    int insert(SecUser record);

    @InsertProvider(type=SecUserSqlProvider.class, method="insertSelective")
    int insertSelective(SecUser record);

    @Select({
        "select",
        "USER_ID, USER_CODE, PLAINTEXT_PASSWORD, PASSWORD, USERNAME, PHONE, EMAIL, DESCRIPTION, ",
        "IS_ADMIN, STATUS, CREATE_DATE, CREATOR_ID, CREATOR_NAME, MODIFIER_ID, MODIFIER_NAME, ",
        "MODIFIER_DATE",
        "from SEC_USER",
        "where USER_ID = #{userId,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="USER_CODE", property="userCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="PLAINTEXT_PASSWORD", property="plaintextPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="PASSWORD", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="USERNAME", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="PHONE", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="EMAIL", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="DESCRIPTION", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_ADMIN", property="isAdmin", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_DATE", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATOR_ID", property="creatorId", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATOR_NAME", property="creatorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="MODIFIER_ID", property="modifierId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MODIFIER_NAME", property="modifierName", jdbcType=JdbcType.VARCHAR),
        @Result(column="MODIFIER_DATE", property="modifierDate", jdbcType=JdbcType.TIMESTAMP)
    })
    SecUser selectByPrimaryKey(Long userId);

    @UpdateProvider(type=SecUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SecUser record);

    @Update({
        "update SEC_USER",
        "set USER_CODE = #{userCode,jdbcType=VARCHAR},",
          "PLAINTEXT_PASSWORD = #{plaintextPassword,jdbcType=VARCHAR},",
          "PASSWORD = #{password,jdbcType=VARCHAR},",
          "USERNAME = #{username,jdbcType=VARCHAR},",
          "PHONE = #{phone,jdbcType=VARCHAR},",
          "EMAIL = #{email,jdbcType=VARCHAR},",
          "DESCRIPTION = #{description,jdbcType=VARCHAR},",
          "IS_ADMIN = #{isAdmin,jdbcType=DECIMAL},",
          "STATUS = #{status,jdbcType=DECIMAL},",
          "CREATE_DATE = #{createDate,jdbcType=TIMESTAMP},",
          "CREATOR_ID = #{creatorId,jdbcType=DECIMAL},",
          "CREATOR_NAME = #{creatorName,jdbcType=VARCHAR},",
          "MODIFIER_ID = #{modifierId,jdbcType=DECIMAL},",
          "MODIFIER_NAME = #{modifierName,jdbcType=VARCHAR},",
          "MODIFIER_DATE = #{modifierDate,jdbcType=TIMESTAMP}",
        "where USER_ID = #{userId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(SecUser record);

    @Select({
            "select",
            "USER_ID, USER_CODE, PLAINTEXT_PASSWORD, PASSWORD, USERNAME, PHONE, EMAIL, DESCRIPTION, ",
            "IS_ADMIN, STATUS, CREATE_DATE, CREATOR_ID, CREATOR_NAME, MODIFIER_ID, MODIFIER_NAME, ",
            "MODIFIER_DATE",
            "from SEC_USER",
            "where USER_CODE = #{userCode,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="USER_ID", property="userId", jdbcType=JdbcType.DECIMAL, id=true),
            @Result(column="USER_CODE", property="userCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="PLAINTEXT_PASSWORD", property="plaintextPassword", jdbcType=JdbcType.VARCHAR),
            @Result(column="PASSWORD", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="USERNAME", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="PHONE", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="EMAIL", property="email", jdbcType=JdbcType.VARCHAR),
            @Result(column="DESCRIPTION", property="description", jdbcType=JdbcType.VARCHAR),
            @Result(column="IS_ADMIN", property="isAdmin", jdbcType=JdbcType.DECIMAL),
            @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
            @Result(column="CREATE_DATE", property="createDate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="CREATOR_ID", property="creatorId", jdbcType=JdbcType.DECIMAL),
            @Result(column="CREATOR_NAME", property="creatorName", jdbcType=JdbcType.VARCHAR),
            @Result(column="MODIFIER_ID", property="modifierId", jdbcType=JdbcType.DECIMAL),
            @Result(column="MODIFIER_NAME", property="modifierName", jdbcType=JdbcType.VARCHAR),
            @Result(column="MODIFIER_DATE", property="modifierDate", jdbcType=JdbcType.TIMESTAMP)
    })
    SecUser selectByUserCode(String userCode);
}