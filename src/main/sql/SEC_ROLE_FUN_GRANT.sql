-- Create table
create table AIQRY.SEC_ROLE_FUN_GRANT
(
  ROLE_GRANT_ID NUMBER(14),
  ROLE_CODE     VARCHAR2(60),
  FUNC_ID       NUMBER(14),
  MODIFIER_ID   NUMBER(14),
  MODIFIER_NAME VARCHAR2(100),
  MODIFIER_DATE DATE
);
-- Add comments to the table 
comment on table AIQRY.SEC_ROLE_FUN_GRANT
  is '角色与控件实体绑定表';
-- Add comments to the columns
comment on column AIQRY.SEC_ROLE_FUN_GRANT.FUNC_ID
  is '功能id';
comment on column AIQRY.SEC_ROLE_FUN_GRANT.MODIFIER_ID
  is '修改人员';
comment on column AIQRY.SEC_ROLE_FUN_GRANT.MODIFIER_NAME
  is '修改人名字';
comment on column AIQRY.SEC_ROLE_FUN_GRANT.MODIFIER_DATE
  is '修改日期';


