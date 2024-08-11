CREATE TABLE Partner (
  PartnerID VARCHAR(1024) NOT NULL AUTO_INCREMENT ,
  PartnerName VARCHAR(1024)  ,
  Latitude DOUBLE ,
  Longitude DOUBLE ,
  Amount  DOUBLE ,
  Weight DOUBLE ,
  volume FLOAT,
    PRIMARY KEY (PartnerID)
);
ALTER TABLE partner
    MODIFY PartnerID VARCHAR(1024) NOT NULL AUTO_INCREMENT;



ALTER TABLE partner DROP COLUMN partner_id;

 select * from partner;
DESCRIBE partner;

/*select PartnerName, Amount ,ROUND(Amount,3) from partner;
select PartnerName, Weight ,ROUND(Weight,3) from partner;
select PartnerName, volume ,ROUND(volume,3) from partner;*/

UPDATE  partner
SET Weight = ROUND(Weight, 3);

UPDATE  partner
SET Amount = ROUND(Amount, 3);

UPDATE  partner
SET volume = ROUND(volume, 3);

select count(PartnerID)  from partner;

/*ALTER TABLE partner DROP COLUMN partner_name;*/
