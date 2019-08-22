package cn.lcools.dao;

import cn.lcools.bean.SecAuthorize;
import org.apache.ibatis.jdbc.SQL;

public class SecAuthorizeSqlProvider {

    public String insertSelective(SecAuthorize record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("SEC_AUTHORIZE");
        
        if (record.getAuthorizeId() != null) {
            sql.VALUES("AUTHORIZE_ID", "#{authorizeId,jdbcType=DECIMAL}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("USER_ID", "#{userId,jdbcType=DECIMAL}");
        }
        
        if (record.getRoleCode() != null) {
            sql.VALUES("ROLE_CODE", "#{roleCode,jdbcType=VARCHAR}");
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

    public String updateByPrimaryKeySelective(SecAuthorize record) {
        SQL sql = new SQL();
        sql.UPDATE("SEC_AUTHORIZE");
        
        if (record.getUserId() != null) {
            sql.SET("USER_ID = #{userId,jdbcType=DECIMAL}");
        }
        
        if (record.getRoleCode() != null) {
            sql.SET("ROLE_CODE = #{roleCode,jdbcType=VARCHAR}");
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
        
        sql.WHERE("AUTHORIZE_ID = #{authorizeId,jdbcType=DECIMAL}");
        
        return sql.toString();
    }
}