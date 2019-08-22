package cn.lcools.dao;

import cn.lcools.bean.SecUser;
import org.apache.ibatis.jdbc.SQL;

public class SecUserSqlProvider {

    public String insertSelective(SecUser record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("SEC_USER");
        
        if (record.getUserId() != null) {
            sql.VALUES("USER_ID", "#{userId,jdbcType=DECIMAL}");
        }
        
        if (record.getUserCode() != null) {
            sql.VALUES("USER_CODE", "#{userCode,jdbcType=VARCHAR}");
        }
        
        if (record.getPlaintextPassword() != null) {
            sql.VALUES("PLAINTEXT_PASSWORD", "#{plaintextPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("PASSWORD", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            sql.VALUES("USERNAME", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("PHONE", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("EMAIL", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("DESCRIPTION", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getIsAdmin() != null) {
            sql.VALUES("IS_ADMIN", "#{isAdmin,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("STATUS", "#{status,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateDate() != null) {
            sql.VALUES("CREATE_DATE", "#{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreatorId() != null) {
            sql.VALUES("CREATOR_ID", "#{creatorId,jdbcType=DECIMAL}");
        }
        
        if (record.getCreatorName() != null) {
            sql.VALUES("CREATOR_NAME", "#{creatorName,jdbcType=VARCHAR}");
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

    public String updateByPrimaryKeySelective(SecUser record) {
        SQL sql = new SQL();
        sql.UPDATE("SEC_USER");
        
        if (record.getUserCode() != null) {
            sql.SET("USER_CODE = #{userCode,jdbcType=VARCHAR}");
        }
        
        if (record.getPlaintextPassword() != null) {
            sql.SET("PLAINTEXT_PASSWORD = #{plaintextPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("PASSWORD = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            sql.SET("USERNAME = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("PHONE = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("EMAIL = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("DESCRIPTION = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getIsAdmin() != null) {
            sql.SET("IS_ADMIN = #{isAdmin,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("STATUS = #{status,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateDate() != null) {
            sql.SET("CREATE_DATE = #{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreatorId() != null) {
            sql.SET("CREATOR_ID = #{creatorId,jdbcType=DECIMAL}");
        }
        
        if (record.getCreatorName() != null) {
            sql.SET("CREATOR_NAME = #{creatorName,jdbcType=VARCHAR}");
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
        
        sql.WHERE("USER_ID = #{userId,jdbcType=DECIMAL}");
        
        return sql.toString();
    }
}