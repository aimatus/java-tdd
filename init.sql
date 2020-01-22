CREATE TABLE IF NOT EXISTS `java-tdd`.`user`
(
    `id`        INT          NOT NULL AUTO_INCREMENT,
    `full_name` VARCHAR(45)  NULL,
    `username`  VARCHAR(45)  NULL,
    `email`     VARCHAR(100) NULL,
    `password`  VARCHAR(32)  NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
