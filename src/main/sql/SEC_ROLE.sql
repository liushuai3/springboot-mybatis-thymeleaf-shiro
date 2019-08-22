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
  is '��ɫ��';
-- Add comments to the columns 
comment on column AIQRY.SEC_ROLE.ROLE_CODE
  is '��ɫCODE';
comment on column AIQRY.SEC_ROLE.ROLE_NAME
  is '��ɫ����';
comment on column AIQRY.SEC_ROLE.ROLE_TYPE
  is '��ɫ����';
comment on column AIQRY.SEC_ROLE.DESCRIPTION
  is '����';
comment on column AIQRY.SEC_ROLE.STATUS
  is '0: ʧЧ
1: ����';
comment on column AIQRY.SEC_ROLE.MODIFIER_ID
  is '����޸���Ա';
comment on column AIQRY.SEC_ROLE.MODIFIER_NAME
  is '����޸�������';
comment on column AIQRY.SEC_ROLE.MODIFIER_DATE
  is '����޸�����';
