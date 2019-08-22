-- Create table
create table AIQRY.SEC_USER
(
  USER_ID            NUMBER(14),
  USER_CODE          VARCHAR2(60),
  PLAINTEXT_PASSWORD VARCHAR2(1000),
  PASSWORD           VARCHAR2(1000),
  USERNAME           VARCHAR2(100),
  PHONE              VARCHAR2(50),
  EMAIL              VARCHAR2(400),
  DESCRIPTION        VARCHAR2(400),
  IS_ADMIN           NUMBER(4),
  STATUS             NUMBER(4),
  CREATE_DATE        DATE,
  CREATOR_ID         NUMBER(14),
  CREATOR_NAME       VARCHAR2(200),
  MODIFIER_ID        NUMBER(14),
  MODIFIER_NAME      VARCHAR2(100),
  MODIFIER_DATE      DATE
);
-- Add comments to the table 
comment on table AIQRY.SEC_USER
  is '用户信息表';
-- Add comments to the columns 
comment on column AIQRY.SEC_USER.USER_ID
  is '唯一标识';
comment on column AIQRY.SEC_USER.USER_CODE
  is '用户名';
comment on column AIQRY.SEC_USER.PLAINTEXT_PASSWORD
  is '明文密码';
comment on column AIQRY.SEC_USER.PASSWORD
  is '密文密码';
comment on column AIQRY.SEC_USER.USERNAME
  is '用户真实姓名';
comment on column AIQRY.SEC_USER.PHONE
  is '手机号码';
comment on column AIQRY.SEC_USER.EMAIL
  is 'EMAIL';
comment on column AIQRY.SEC_USER.DESCRIPTION
  is '描述';
comment on column AIQRY.SEC_USER.IS_ADMIN
  is '是否是超级管理员(1：是超级管理员
  0：不是超级管理员)';
comment on column AIQRY.SEC_USER.STATUS
  is '0: 失效
  1: 正常';
comment on column AIQRY.SEC_USER.CREATE_DATE
  is '创建时间';
comment on column AIQRY.SEC_USER.CREATOR_ID
  is '创建人ID';
comment on column AIQRY.SEC_USER.CREATOR_NAME
  is '创建人名字';
comment on column AIQRY.SEC_USER.MODIFIER_ID
  is '修改人员';
comment on column AIQRY.SEC_USER.MODIFIER_NAME
  is '修改人名字';
comment on column AIQRY.SEC_USER.MODIFIER_DATE
  is '修改日期';
