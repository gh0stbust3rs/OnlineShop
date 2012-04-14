--------------------------------------------------------
--  Datei erstellt -Samstag-April-14-2012   
--------------------------------------------------------
  DROP TABLE "USER"."BESTELLUNG" cascade constraints;
  DROP TABLE "USER"."KATEGORIE" cascade constraints;
  DROP TABLE "USER"."PERSON" cascade constraints;
  DROP TABLE "USER"."PRODUKT" cascade constraints;
  DROP TABLE "USER"."RECHNUNG" cascade constraints;
  DROP TABLE "USER"."WARENKORB" cascade constraints;
  DROP SEQUENCE "USER"."SEQ_BESTELLUNG";
  DROP SEQUENCE "USER"."SEQ_KATEGORIE";
  DROP SEQUENCE "USER"."SEQ_PERSON";
  DROP SEQUENCE "USER"."SEQ_PRODUKT";
  DROP SEQUENCE "USER"."SEQ_RECHNUNG";
  DROP SEQUENCE "USER"."SEQ_WARENKORB";
--------------------------------------------------------
--  DDL for Sequence SEQ_BESTELLUNG
--------------------------------------------------------

   CREATE SEQUENCE  "USER"."SEQ_BESTELLUNG"  MINVALUE 0 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 20 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_KATEGORIE
--------------------------------------------------------

   CREATE SEQUENCE  "USER"."SEQ_KATEGORIE"  MINVALUE 0 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 40 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_PERSON
--------------------------------------------------------

   CREATE SEQUENCE  "USER"."SEQ_PERSON"  MINVALUE 0 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 60 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_PRODUKT
--------------------------------------------------------

   CREATE SEQUENCE  "USER"."SEQ_PRODUKT"  MINVALUE 0 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 60 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_RECHNUNG
--------------------------------------------------------

   CREATE SEQUENCE  "USER"."SEQ_RECHNUNG"  MINVALUE 0 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 20 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_WARENKORB
--------------------------------------------------------

   CREATE SEQUENCE  "USER"."SEQ_WARENKORB"  MINVALUE 0 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 20 CACHE 20 NOORDER  NOCYCLE ;
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
--  DDL for Table KATEGORIE
--------------------------------------------------------

  CREATE TABLE "USER"."KATEGORIE" 
   (	"KAT_ID" NUMBER(*,0), 
	"KAT_BEZEICHNUNG" VARCHAR2(50 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PERSON
--------------------------------------------------------

  CREATE TABLE "USER"."PERSON" 
   (	"P_ID" NUMBER(*,0), 
	"VORNAME" VARCHAR2(50 BYTE), 
	"NACHNAME" VARCHAR2(50 BYTE), 
	"STRASSE" VARCHAR2(20 BYTE), 
	"HAUSNR" VARCHAR2(10 BYTE), 
	"PLZ" VARCHAR2(10 BYTE), 
	"ORT" VARCHAR2(50 BYTE), 
	"LAND" VARCHAR2(50 BYTE), 
	"EMAIL" VARCHAR2(100 BYTE), 
	"PASS" VARCHAR2(200 BYTE), 
	"ANBIETER" NUMBER(*,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
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
--  DDL for Table RECHNUNG
--------------------------------------------------------

  CREATE TABLE "USER"."RECHNUNG" 
   (	"R_ID" NUMBER(*,0), 
	"R_DATUM" DATE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
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
REM INSERTING into "USER".BESTELLUNG
SET DEFINE OFF;
Insert into "USER".BESTELLUNG (B_ID,DATUM,KREDITKARTE,CVC,VALID_MONTH,VALID_YEAR,P_ID,PR_ID,SHIPPED,QUANTITY,WK_ID,R_ID) values ('2',to_date('14.04.12','DD.MM.RR'),'1234567890123456','123','10','13','47','1',null,'5','8','0');
Insert into "USER".BESTELLUNG (B_ID,DATUM,KREDITKARTE,CVC,VALID_MONTH,VALID_YEAR,P_ID,PR_ID,SHIPPED,QUANTITY,WK_ID,R_ID) values ('3',to_date('14.04.12','DD.MM.RR'),'1234567890123456','123','10','13','47','2',null,'10','9','0');
REM INSERTING into "USER".KATEGORIE
SET DEFINE OFF;
Insert into "USER".KATEGORIE (KAT_ID,KAT_BEZEICHNUNG) values ('0','PC');
Insert into "USER".KATEGORIE (KAT_ID,KAT_BEZEICHNUNG) values ('1','RAM');
Insert into "USER".KATEGORIE (KAT_ID,KAT_BEZEICHNUNG) values ('2','Festplatten');
Insert into "USER".KATEGORIE (KAT_ID,KAT_BEZEICHNUNG) values ('3','Prozessoren');
Insert into "USER".KATEGORIE (KAT_ID,KAT_BEZEICHNUNG) values ('4','Smartphones');
Insert into "USER".KATEGORIE (KAT_ID,KAT_BEZEICHNUNG) values ('5','Tablets');
Insert into "USER".KATEGORIE (KAT_ID,KAT_BEZEICHNUNG) values ('6','Zubehör');
REM INSERTING into "USER".PERSON
SET DEFINE OFF;
Insert into "USER".PERSON (P_ID,VORNAME,NACHNAME,STRASSE,HAUSNR,PLZ,ORT,LAND,EMAIL,PASS,ANBIETER) values ('0','Matthias','Webhofer','Dorfstraße','27','9905','Gaimberg','Österreich','webhofer.m@gmx.at','admin','1');
Insert into "USER".PERSON (P_ID,VORNAME,NACHNAME,STRASSE,HAUSNR,PLZ,ORT,LAND,EMAIL,PASS,ANBIETER) values ('1','Andreas','Lackner','St. Peter','29','9863','Rennweg','Österreich','alackner@geomix.at','admin','1');
Insert into "USER".PERSON (P_ID,VORNAME,NACHNAME,STRASSE,HAUSNR,PLZ,ORT,LAND,EMAIL,PASS,ANBIETER) values ('2','Milan','Kollmann','asdf','1','9999','asdf','Österreich','milan@kollmann.org','admin','1');
Insert into "USER".PERSON (P_ID,VORNAME,NACHNAME,STRASSE,HAUSNR,PLZ,ORT,LAND,EMAIL,PASS,ANBIETER) values ('23','Testi','Testmann','Teststrasse','123','1337','Testort','Deutschland','testi.testmann@test.de','test','0');
Insert into "USER".PERSON (P_ID,VORNAME,NACHNAME,STRASSE,HAUSNR,PLZ,ORT,LAND,EMAIL,PASS,ANBIETER) values ('47','Tom','Bremen','Koenigsstrase','1','214','Aachen','Deutschland','user','user','0');
REM INSERTING into "USER".PRODUKT
SET DEFINE OFF;
Insert into "USER".PRODUKT (PR_ID,BEZEICHNUNG,PREIS,BESTAND,BILD,KAT) values ('1','iPad 3rd Generation, 16gb, wifi+3g, white','599',null,null,null);
Insert into "USER".PRODUKT (PR_ID,BEZEICHNUNG,PREIS,BESTAND,BILD,KAT) values ('2','Samsung Galaxy SII, 16gb, 4.3" screen','399',null,null,null);
Insert into "USER".PRODUKT (PR_ID,BEZEICHNUNG,PREIS,BESTAND,BILD,KAT) values ('3','ortner pc ;)','5',null,null,null);
Insert into "USER".PRODUKT (PR_ID,BEZEICHNUNG,PREIS,BESTAND,BILD,KAT) values ('4','Kingston 1234, 1gb, 766 mhz, ddr3','50',null,null,null);
Insert into "USER".PRODUKT (PR_ID,BEZEICHNUNG,PREIS,BESTAND,BILD,KAT) values ('5','Western Digital 0998cf, 1tb, 2,5", intern','99',null,null,null);
Insert into "USER".PRODUKT (PR_ID,BEZEICHNUNG,PREIS,BESTAND,BILD,KAT) values ('6','Intel Core i7, Quad-Core, 1,4ghz','249',null,null,null);
Insert into "USER".PRODUKT (PR_ID,BEZEICHNUNG,PREIS,BESTAND,BILD,KAT) values ('7','SmartCover für iPad, schwarz','39',null,null,null);
Insert into "USER".PRODUKT (PR_ID,BEZEICHNUNG,PREIS,BESTAND,BILD,KAT) values ('33','Produkt 1','235','45','default.png','PC');
Insert into "USER".PRODUKT (PR_ID,BEZEICHNUNG,PREIS,BESTAND,BILD,KAT) values ('34','Produkt 2','253','4','default.png','Tablets');
Insert into "USER".PRODUKT (PR_ID,BEZEICHNUNG,PREIS,BESTAND,BILD,KAT) values ('40','Produkt 3','2345','32','e96f0717-c8c9-4a03-b2c5-559ca78dd79e.jpg','Prozessoren');
REM INSERTING into "USER".RECHNUNG
SET DEFINE OFF;
Insert into "USER".RECHNUNG (R_ID,R_DATUM) values ('0',to_date('14.04.12','DD.MM.RR'));
REM INSERTING into "USER".WARENKORB
SET DEFINE OFF;
Insert into "USER".WARENKORB (WK_ID,QUANTITY,PR_ID,P_ID,ACTIVE) values ('6','1','33','47','1');
Insert into "USER".WARENKORB (WK_ID,QUANTITY,PR_ID,P_ID,ACTIVE) values ('7','0','33','47','1');
Insert into "USER".WARENKORB (WK_ID,QUANTITY,PR_ID,P_ID,ACTIVE) values ('8','5','1','47','0');
Insert into "USER".WARENKORB (WK_ID,QUANTITY,PR_ID,P_ID,ACTIVE) values ('9','10','2','47','0');
--------------------------------------------------------
--  DDL for Index MAILUNIQUE
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."MAILUNIQUE" ON "USER"."PERSON" ("EMAIL") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C004073
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."SYS_C004073" ON "USER"."PERSON" ("P_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C004074
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."SYS_C004074" ON "USER"."PRODUKT" ("PR_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C004075
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."SYS_C004075" ON "USER"."KATEGORIE" ("KAT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C004076
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."SYS_C004076" ON "USER"."BESTELLUNG" ("B_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C004080
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."SYS_C004080" ON "USER"."WARENKORB" ("WK_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C004109
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."SYS_C004109" ON "USER"."RECHNUNG" ("R_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UNIQUECONTRAINTKATEGORIE
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER"."UNIQUECONTRAINTKATEGORIE" ON "USER"."KATEGORIE" ("KAT_BEZEICHNUNG") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table BESTELLUNG
--------------------------------------------------------

  ALTER TABLE "USER"."BESTELLUNG" ADD PRIMARY KEY ("B_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table KATEGORIE
--------------------------------------------------------

  ALTER TABLE "USER"."KATEGORIE" ADD PRIMARY KEY ("KAT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "USER"."KATEGORIE" ADD CONSTRAINT "UNIQUECONTRAINTKATEGORIE" UNIQUE ("KAT_BEZEICHNUNG")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PERSON
--------------------------------------------------------

  ALTER TABLE "USER"."PERSON" ADD CONSTRAINT "MAILUNIQUE" UNIQUE ("EMAIL")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "USER"."PERSON" ADD PRIMARY KEY ("P_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PRODUKT
--------------------------------------------------------

  ALTER TABLE "USER"."PRODUKT" ADD PRIMARY KEY ("PR_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table RECHNUNG
--------------------------------------------------------

  ALTER TABLE "USER"."RECHNUNG" ADD PRIMARY KEY ("R_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table WARENKORB
--------------------------------------------------------

  ALTER TABLE "USER"."WARENKORB" ADD PRIMARY KEY ("WK_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BESTELLUNG
--------------------------------------------------------

  ALTER TABLE "USER"."BESTELLUNG" ADD FOREIGN KEY ("P_ID")
	  REFERENCES "USER"."PERSON" ("P_ID") ENABLE;
 
  ALTER TABLE "USER"."BESTELLUNG" ADD FOREIGN KEY ("PR_ID")
	  REFERENCES "USER"."PRODUKT" ("PR_ID") ENABLE;
 
  ALTER TABLE "USER"."BESTELLUNG" ADD FOREIGN KEY ("WK_ID")
	  REFERENCES "USER"."WARENKORB" ("WK_ID") ENABLE;
 
  ALTER TABLE "USER"."BESTELLUNG" ADD FOREIGN KEY ("R_ID")
	  REFERENCES "USER"."RECHNUNG" ("R_ID") ENABLE;


--------------------------------------------------------
--  Ref Constraints for Table PRODUKT
--------------------------------------------------------

  ALTER TABLE "USER"."PRODUKT" ADD FOREIGN KEY ("KAT")
	  REFERENCES "USER"."KATEGORIE" ("KAT_BEZEICHNUNG") ENABLE;

--------------------------------------------------------
--  Ref Constraints for Table WARENKORB
--------------------------------------------------------

  ALTER TABLE "USER"."WARENKORB" ADD FOREIGN KEY ("PR_ID")
	  REFERENCES "USER"."PRODUKT" ("PR_ID") ENABLE;
 
  ALTER TABLE "USER"."WARENKORB" ADD FOREIGN KEY ("P_ID")
	  REFERENCES "USER"."PERSON" ("P_ID") ENABLE;
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
  update warenkorb set active=0 where wk_id=warenkorb_id;
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
