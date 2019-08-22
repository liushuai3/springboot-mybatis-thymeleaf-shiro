-- Create table
create table AIQRY.SEC_FUNCTIONS
(
  FUNC_ID       NUMBER(14),
  PARENT_ID     NUMBER(14),
  FUNC_TYPE     NUMBER(4),
  FUNC_NAME     VARCHAR2(80),
  DESCRIPTION   VARCHAR2(400),
  FUNC_IMG      VARCHAR2(1000),
  FUNC_URL      VARCHAR2(1000),
  FUNC_LEVEL    NUMBER(8),
  FUNC_INDEX    NUMBER(8),
  STATUS        NUMBER(4),
  MODIFIER_ID   NUMBER(14),
  MODIFIER_NAME VARCHAR2(100),
  MODIFIER_DATE DATE
);
-- Add comments to the table 
comment on table AIQRY.SEC_FUNCTIONS
  is '功能表, 最顶上的父id，为-1';
-- Add comments to the columns
comment on column AIQRY.SEC_FUNCTIONS.FUNC_TYPE
  is '1：
2：
3：';
comment on column AIQRY.SEC_FUNCTIONS.STATUS
  is '0: 失效
1: 正常';
comment on column AIQRY.SEC_FUNCTIONS.MODIFIER_ID
  is '修改人员';
comment on column AIQRY.SEC_FUNCTIONS.MODIFIER_NAME
  is '修改人名字';
comment on column AIQRY.SEC_FUNCTIONS.MODIFIER_DATE
  is '修改日期';
