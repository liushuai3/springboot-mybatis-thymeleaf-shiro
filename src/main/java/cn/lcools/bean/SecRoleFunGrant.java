package cn.lcools.bean;

import java.io.Serializable;
import java.util.Date;

public class SecRoleFunGrant implements Serializable {
    private Long roleGrantId;

    private String roleCode;

    private Long funcId;

    private Long modifierId;

    private String modifierName;

    private Date modifierDate;

    public Long getRoleGrantId() {
        return roleGrantId;
    }

    public void setRoleGrantId(Long roleGrantId) {
        this.roleGrantId = roleGrantId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public Long getFuncId() {
        return funcId;
    }

    public void setFuncId(Long funcId) {
        this.funcId = funcId;
    }

    public Long getModifierId() {
        return modifierId;
    }

    public void setModifierId(Long modifierId) {
        this.modifierId = modifierId;
    }

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName == null ? null : modifierName.trim();
    }

    public Date getModifierDate() {
        return modifierDate;
    }

    public void setModifierDate(Date modifierDate) {
        this.modifierDate = modifierDate;
    }
}