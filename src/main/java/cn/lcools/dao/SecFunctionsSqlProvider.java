package cn.lcools.dao;

import cn.lcools.bean.SecFunctions;
import org.apache.ibatis.jdbc.SQL;

public class SecFunctionsSqlProvider {

    public String insertSelective(SecFunctions record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("SEC_FUNCTIONS");
        
        if (record.getFuncId() != null) {
            sql.VALUES("FUNC_ID", "#{funcId,jdbcType=DECIMAL}");
        }
        
        if (record.getParentId() != null) {
            sql.VALUES("PARENT_ID", "#{parentId,jdbcType=DECIMAL}");
        }
        
        if (record.getFuncType() != null) {
            sql.VALUES("FUNC_TYPE", "#{funcType,jdbcType=DECIMAL}");
        }
        
        if (record.getFuncName() != null) {
            sql.VALUES("FUNC_NAME", "#{funcName,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("DESCRIPTION", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getFuncImg() != null) {
            sql.VALUES("FUNC_IMG", "#{funcImg,jdbcType=VARCHAR}");
        }
        
        if (record.getFuncUrl() != null) {
            sql.VALUES("FUNC_URL", "#{funcUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getFuncLevel() != null) {
            sql.VALUES("FUNC_LEVEL", "#{funcLevel,jdbcType=DECIMAL}");
        }
        
        if (record.getFuncIndex() != null) {
            sql.VALUES("FUNC_INDEX", "#{funcIndex,jdbcType=DECIMAL}");
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

    public String updateByPrimaryKeySelective(SecFunctions record) {
        SQL sql = new SQL();
        sql.UPDATE("SEC_FUNCTIONS");
        
        if (record.getParentId() != null) {
            sql.SET("PARENT_ID = #{parentId,jdbcType=DECIMAL}");
        }
        
        if (record.getFuncType() != null) {
            sql.SET("FUNC_TYPE = #{funcType,jdbcType=DECIMAL}");
        }
        
        if (record.getFuncName() != null) {
            sql.SET("FUNC_NAME = #{funcName,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("DESCRIPTION = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getFuncImg() != null) {
            sql.SET("FUNC_IMG = #{funcImg,jdbcType=VARCHAR}");
        }
        
        if (record.getFuncUrl() != null) {
            sql.SET("FUNC_URL = #{funcUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getFuncLevel() != null) {
            sql.SET("FUNC_LEVEL = #{funcLevel,jdbcType=DECIMAL}");
        }
        
        if (record.getFuncIndex() != null) {
            sql.SET("FUNC_INDEX = #{funcIndex,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("STATUS = #{status,jdbcType=DECIMAL}");
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
        
        sql.WHERE("FUNC_ID = #{funcId,jdbcType=DECIMAL}");
        
        return sql.toString();
    }
}