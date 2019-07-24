CREATE TABLE aday (
   id INT NOT NULL AUTO_INCREMENT,
   ssm_id INT NOT NULL,
   tcno varchar(11) NOT NULL,
   ad varchar(32) NOT NULL,
   soyad varchar(32) NOT NULL,
   dogum_tarihi date NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE aday_dokuman (
   id INT NOT NULL AUTO_INCREMENT,
   aday_id INT NOT NULL,
   dokuman_ismi varchar(128),
   lokasyon varchar(256),
  CONSTRAINT fk_aday_dokuman_aday_id FOREIGN KEY (aday_id) REFERENCES aday (id) ON UPDATE RESTRICT ON DELETE RESTRICT,
  PRIMARY KEY (id),
  KEY aday_id (aday_id) 
) ENGINE = InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE sinav_sonucu (
   id INT NOT NULL AUTO_INCREMENT,
   aday_id INT NOT NULL,
   sinav_adi varchar(16),
   sinav_yili INT NOT NULL,
   sinav_puani INT NOT NULL,
  CONSTRAINT fk_sinav_sonucu_aday_id FOREIGN KEY (aday_id) REFERENCES aday (id) ON UPDATE RESTRICT ON DELETE RESTRICT,
  PRIMARY KEY (id),
  KEY aday_id (aday_id) 
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

