-- Create table
create table AIQRY.SEC_AUTHORIZE
(
  AUTHORIZE_ID  NUMBER(14),
  USER_ID       NUMBER(14),
  ROLE_CODE     VARCHAR2(60),
  MODIFIER_ID   NUMBER(14),
  MODIFIER_NAME VARCHAR2(100),
  MODIFIER_DATE DATE
);
-- Add comments to the table 
comment on table AIQRY.SEC_AUTHORIZE
  is '角色授权表';
-- Add comments to the columns
comment on column AIQRY.SEC_AUTHORIZE.AUTHORIZE_ID
  is 'AUTHORIZE_ID';
comment on column AIQRY.SEC_AUTHORIZE.USER_ID
  is '用户id';
comment on column AIQRY.SEC_AUTHORIZE.ROLE_CODE
  is '角色CODE';
comment on column AIQRY.SEC_AUTHORIZE.MODIFIER_ID
  is '最后修改人员';
comment on column AIQRY.SEC_AUTHORIZE.MODIFIER_NAME
  is '最后修改人名字';
comment on column AIQRY.SEC_AUTHORIZE.MODIFIER_DATE
  is '最后修改日期';


