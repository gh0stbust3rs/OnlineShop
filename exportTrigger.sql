--------------------------------------------------------
--  Datei erstellt -Montag-April-16-2012   
--------------------------------------------------------
  DROP TRIGGER "USER"."AFTER_DELETE_WARENKORB";
  DROP TRIGGER "USER"."AFTER_INSERT_BESTELLUNG";
  DROP TRIGGER "USER"."AFTER_INSERT_WARENKORB";
--------------------------------------------------------
--  DDL for Table PRODUKT
--------------------------------------------------------

  CREATE TABLE "USER"."PRODUKT" 
   (	"PR_ID" NUMBER(*,0), 
	"BEZEICHNUNG" VARCHAR2(50 BYTE), 
	"PREIS" NUMBER(*,2), 
	"BESCHREIBUNG" CLOB, 
	"BESTAND" NUMBER(*,0), 
	"BILD" VARCHAR2(100 BYTE), 
	"KAT" VARCHAR2(30 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" 
 LOB ("BESCHREIBUNG") STORE AS (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192 PCTVERSION 10
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)) ;
--------------------------------------------------------
--  DDL for Table WARENKORB
--------------------------------------------------------

  CREATE TABLE "USER"."WARENKORB" 
   (	"WK_ID" NUMBER(*,0), 
	"QUANTITY" NUMBER(*,0), 
	"PR_ID" NUMBER(*,0), 
	"P_ID" NUMBER(*,0), 
	"ACTIVE" NUMBER(*,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table BESTELLUNG
--------------------------------------------------------

  CREATE TABLE "USER"."BESTELLUNG" 
   (	"B_ID" NUMBER(*,0), 
	"DATUM" DATE, 
	"KREDITKARTE" VARCHAR2(16 BYTE), 
	"CVC" VARCHAR2(5 BYTE), 
	"VALID_MONTH" VARCHAR2(2 BYTE), 
	"VALID_YEAR" VARCHAR2(2 BYTE), 
	"P_ID" NUMBER(*,0), 
	"PR_ID" NUMBER(*,0), 
	"SHIPPED" DATE, 
	"QUANTITY" NUMBER(*,0), 
	"WK_ID" NUMBER(*,0), 
	"R_ID" NUMBER(*,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger AFTER_DELETE_WARENKORB
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "USER"."AFTER_DELETE_WARENKORB" 
after delete on warenkorb for each row
declare
  produkt_id int;
  quantity int;
begin
  produkt_id := :old.pr_id;
  quantity := :old.quantity;
  update produkt set bestand=bestand+quantity where pr_id=produkt_id;
end;
/
ALTER TRIGGER "USER"."AFTER_DELETE_WARENKORB" ENABLE;
--------------------------------------------------------
--  DDL for Trigger AFTER_INSERT_BESTELLUNG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "USER"."AFTER_INSERT_BESTELLUNG" 
after insert on bestellung for each row
declare
  type t_wk is record (
    wk_quantity warenkorb.quantity%type,
    wk_pr_id warenkorb.pr_id%type,
    wk_p_id warenkorb.p_id%type
  );

  warenkorb_id int;
  v_quantity int;
  v_wk t_wk;
begin
  warenkorb_id := :new.wk_id;
  /*update warenkorb set active=0 where wk_id=warenkorb_id;*/
  delete from warenkorb where wk_id=warenkorb_id;
  select quantity,pr_id,p_id into v_wk from warenkorb where wk_id=warenkorb_id;
end;
/
ALTER TRIGGER "USER"."AFTER_INSERT_BESTELLUNG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger AFTER_INSERT_WARENKORB
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "USER"."AFTER_INSERT_WARENKORB" 
after insert on warenkorb for each row
declare
  produkt_id int;
  anzahl int;
begin
  produkt_id := :new.pr_id;
  anzahl := :new.quantity;
  update produkt set bestand=bestand-anzahl where pr_id = produkt_id;
end;
/
ALTER TRIGGER "USER"."AFTER_INSERT_WARENKORB" ENABLE;
