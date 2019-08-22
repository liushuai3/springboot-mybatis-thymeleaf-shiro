package cn.lcools.dao;

import cn.lcools.bean.SecRole;
import org.apache.ibatis.jdbc.SQL;

public class SecRoleSqlProvider {

    public String insertSelective(SecRole record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("SEC_ROLE");
        
        if (record.getRoleCode() != null) {
            sql.VALUES("ROLE_CODE", "#{roleCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleName() != null) {
            sql.VALUES("ROLE_NAME", "#{roleName,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleType() != null) {
            sql.VALUES("ROLE_TYPE", "#{roleType,jdbcType=DECIMAL}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("DESCRIPTION", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("STATUS", "#{status,jdbcType=DECIMAL}");
        }
        
        if (record.getModifierId() != null) {
            sql.VALUES("MODIFIER_ID", "#{modifierId,jdbcType=DECIMAL}");
        }
        
        if (record.getModifierName() != null) {
            sql.VALUES("MODIFIER_NAME", "#{modifierName,jdbcType=VARCHAR}");
        }
        
        if (record.getModifierDate() != null) {
            sql.VALUES("MODIFIER_DATE", "#{modifierDate,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }
}