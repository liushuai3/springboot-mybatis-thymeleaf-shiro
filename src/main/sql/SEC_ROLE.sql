-- Create table
create table AIQRY.SEC_ROLE
(
  ROLE_CODE     VARCHAR2(60),
  ROLE_NAME     VARCHAR2(60),
  ROLE_TYPE     NUMBER(14),
  DESCRIPTION   VARCHAR2(400),
  STATUS        NUMBER(4),
  MODIFIER_ID   NUMBER(14),
  MODIFIER_NAME VARCHAR2(100),
  MODIFIER_DATE DATE
);
-- Add comments to the table 
comment on table AIQRY.SEC_ROLE
  is '角色表';
-- Add comments to the columns 
comment on column AIQRY.SEC_ROLE.ROLE_CODE
  is '角色CODE';
comment on column AIQRY.SEC_ROLE.ROLE_NAME
  is '角色名字';
comment on column AIQRY.SEC_ROLE.ROLE_TYPE
  is '角色类型';
comment on column AIQRY.SEC_ROLE.DESCRIPTION
  is '描述';
comment on column AIQRY.SEC_ROLE.STATUS
  is '0: 失效
1: 正常';
comment on column AIQRY.SEC_ROLE.MODIFIER_ID
  is '最后修改人员';
comment on column AIQRY.SEC_ROLE.MODIFIER_NAME
  is '最后修改人名字';
comment on column AIQRY.SEC_ROLE.MODIFIER_DATE
  is '最后修改日期';
