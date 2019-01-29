CREATE TABLE IF NOT EXISTS `naumenko`.`users` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `id_role` INT NOT NULL,
  PRIMARY KEY (`id_user`),
  INDEX `fk_users_roles_idx` (`id_role` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`id_role`)
    REFERENCES `naumenko`.`roles` (`id_role`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;