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
  is '��ɫ��ؼ�ʵ��󶨱�';
-- Add comments to the columns 
comment on column AIQRY.SEC_ROLE_FUN_GRANT.FUNC_ID
  is '����id';
comment on column AIQRY.SEC_ROLE_FUN_GRANT.MODIFIER_ID
  is '�޸���Ա';
comment on column AIQRY.SEC_ROLE_FUN_GRANT.MODIFIER_NAME
  is '�޸�������';
comment on column AIQRY.SEC_ROLE_FUN_GRANT.MODIFIER_DATE
  is '�޸�����';


