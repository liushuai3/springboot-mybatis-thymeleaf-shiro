package cn.lcools.dao;

import cn.lcools.bean.SecRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecRoleMapper {
    @Insert({
        "insert into SEC_ROLE (ROLE_CODE, ROLE_NAME, ",
        "ROLE_TYPE, DESCRIPTION, ",
        "STATUS, MODIFIER_ID, ",
        "MODIFIER_NAME, MODIFIER_DATE)",
        "values (#{roleCode,jdbcType=VARCHAR}, #{roleName,jdbcType=VARCHAR}, ",
        "#{roleType,jdbcType=DECIMAL}, #{description,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=DECIMAL}, #{modifierId,jdbcType=DECIMAL}, ",
        "#{modifierName,jdbcType=VARCHAR}, #{modifierDate,jdbcType=TIMESTAMP})"
    })
    int insert(SecRole record);

    @InsertProvider(type=SecRoleSqlProvider.class, method="insertSelective")
    int insertSelective(SecRole record);
}