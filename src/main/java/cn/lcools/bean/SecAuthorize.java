package cn.lcools.bean;

import java.io.Serializable;
import java.util.Date;

public class SecAuthorize implements Serializable {
    private Long authorizeId;

    private Long userId;

    private String roleCode;

    private Long modifierId;

    private String modifierName;

    private Date modifierDate;

    public Long getAuthorizeId() {
        return authorizeId;
    }

    public void setAuthorizeId(Long authorizeId) {
        this.authorizeId = authorizeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
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