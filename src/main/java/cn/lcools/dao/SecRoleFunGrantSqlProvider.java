package cn.lcools.dao;

import cn.lcools.bean.SecRoleFunGrant;
import org.apache.ibatis.jdbc.SQL;

public class SecRoleFunGrantSqlProvider {

    public String insertSelective(SecRoleFunGrant record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("SEC_ROLE_FUN_GRANT");
        
        if (record.getRoleGrantId() != null) {
            sql.VALUES("ROLE_GRANT_ID", "#{roleGrantId,jdbcType=DECIMAL}");
        }
        
        if (record.getRoleCode() != null) {
            sql.VALUES("ROLE_CODE", "#{roleCode,jdbcType=VARCHAR}");
        }
        
        if (record.getFuncId() != null) {
            sql.VALUES("FUNC_ID", "#{funcId,jdbcType=DECIMAL}");
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

    public String updateByPrimaryKeySelective(SecRoleFunGrant record) {
        SQL sql = new SQL();
        sql.UPDATE("SEC_ROLE_FUN_GRANT");
        
        if (record.getRoleCode() != null) {
            sql.SET("ROLE_CODE = #{roleCode,jdbcType=VARCHAR}");
        }
        
        if (record.getFuncId() != null) {
            sql.SET("FUNC_ID = #{funcId,jdbcType=DECIMAL}");
        }
        
        if (record.getModifierId() != null) {
            sql.SET("MODIFIER_ID = #{modifierId,jdbcType=DECIMAL}");
        }
        
        if (record.getModifierName() != null) {
            sql.SET("MODIFIER_NAME = #{modifierName,jdbcType=VARCHAR}");
        }
        
        if (record.getModifierDate() != null) {
            sql.SET("MODIFIER_DATE = #{modifierDate,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("ROLE_GRANT_ID = #{roleGrantId,jdbcType=DECIMAL}");
        
        return sql.toString();
    }
}