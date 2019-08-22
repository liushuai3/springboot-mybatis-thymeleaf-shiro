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
  is '�û���Ϣ��';
-- Add comments to the columns 
comment on column AIQRY.SEC_USER.USER_ID
  is 'Ψһ��ʶ';
comment on column AIQRY.SEC_USER.USER_CODE
  is '�û���';
comment on column AIQRY.SEC_USER.PLAINTEXT_PASSWORD
  is '��������';
comment on column AIQRY.SEC_USER.PASSWORD
  is '��������';
comment on column AIQRY.SEC_USER.USERNAME
  is '�û���ʵ����';
comment on column AIQRY.SEC_USER.PHONE
  is '�ֻ�����';
comment on column AIQRY.SEC_USER.EMAIL
  is 'EMAIL';
comment on column AIQRY.SEC_USER.DESCRIPTION
  is '����';
comment on column AIQRY.SEC_USER.IS_ADMIN
  is '�Ƿ��ǳ�������Ա(1���ǳ�������Ա
  0�����ǳ�������Ա)';
comment on column AIQRY.SEC_USER.STATUS
  is '0: ʧЧ
  1: ����';
comment on column AIQRY.SEC_USER.CREATE_DATE
  is '����ʱ��';
comment on column AIQRY.SEC_USER.CREATOR_ID
  is '������ID';
comment on column AIQRY.SEC_USER.CREATOR_NAME
  is '����������';
comment on column AIQRY.SEC_USER.MODIFIER_ID
  is '�޸���Ա';
comment on column AIQRY.SEC_USER.MODIFIER_NAME
  is '�޸�������';
comment on column AIQRY.SEC_USER.MODIFIER_DATE
  is '�޸�����';
