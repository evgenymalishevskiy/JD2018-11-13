package by.it.malishevskiy.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/", "root", "")) {
            {
                Statement statement = connection.createStatement();
                statement.executeUpdate("DROP SCHEMA IF EXISTS `malishevskiy`");
                statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `malishevskiy` DEFAULT CHARACTER SET utf8 ;");
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS `malishevskiy`.`roles` (\n" +
                        "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                        "  `Role` VARCHAR(45) NULL,\n" +
                        "  PRIMARY KEY (`ID`))\n" +
                        "ENGINE = InnoDB;");
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS `malishevskiy`.`users` (\n" +
                        "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                        "  `Login` VARCHAR(45) NULL,\n" +
                        "  `Password` VARCHAR(45) NULL,\n" +
                        "  `Email` VARCHAR(45) NULL,\n" +
                        "  `roles_ID` INT NOT NULL,\n" +
                        "  PRIMARY KEY (`ID`),\n" +
                        "  INDEX `fk_users_roles_idx` (`roles_ID` ASC) VISIBLE,\n" +
                        "  CONSTRAINT `fk_users_roles`\n" +
                        "    FOREIGN KEY (`roles_ID`)\n" +
                        "    REFERENCES `malishevskiy`.`roles` (`ID`)\n" +
                        "    ON DELETE RESTRICT\n" +
                        "    ON UPDATE RESTRICT)\n" +
                        "ENGINE = InnoDB;");
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS `malishevskiy`.`ads` (\n" +
                        "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                        "  `Animal` VARCHAR(45) NULL,\n" +
                        "  `Weight (kg)` VARCHAR(45) NULL,\n" +
                        "  `Color` VARCHAR(45) NULL,\n" +
                        "  `Price ($)` INT NULL,\n" +
                        "  `Description` VARCHAR(500) NULL,\n" +
                        "  `Adress` VARCHAR(45) NULL,\n" +
                        "  `users_ID` INT NOT NULL,\n" +
                        "  PRIMARY KEY (`ID`),\n" +
                        "  INDEX `fk_ads_users1_idx` (`users_ID` ASC) VISIBLE,\n" +
                        "  CONSTRAINT `fk_ads_users1`\n" +
                        "    FOREIGN KEY (`users_ID`)\n" +
                        "    REFERENCES `malishevskiy`.`users` (`ID`)\n" +
                        "    ON DELETE CASCADE\n" +
                        "    ON UPDATE CASCADE)\n" +
                        "ENGINE = InnoDB;");
                statement.executeUpdate("INSERT INTO `malishevskiy`.`roles` (`ID`, `Role`) VALUES (1, 'admin');");
                statement.executeUpdate("INSERT INTO `malishevskiy`.`roles` (`ID`, `Role`) VALUES (2, 'user');");
                statement.executeUpdate("INSERT INTO `malishevskiy`.`roles` (`ID`, `Role`) VALUES (3, 'guest');");
                statement.executeUpdate("INSERT INTO `malishevskiy`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'admin', 'padmin', 'admin@it.by', 1);");
                statement.executeUpdate("INSERT INTO `malishevskiy`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'user', 'puser', 'user@it.by', 2);");
                statement.executeUpdate("INSERT INTO `malishevskiy`.`ads` (`ID`, `Animal`, `Weight (kg)`, `Color`, `Price ($)`, `Description`, `Adress`, `users_ID`) VALUES (DEFAULT, 'Dog', '7', 'Black', 100, 'Добрая собака трех лет от роду ищет не менее добрую семью. Привитая, обожает играть со своим мячиком, кошками, и детьми)', 'ул. Западная 9-90', 2);");
                statement.executeUpdate("INSERT INTO `malishevskiy`.`ads` (`ID`, `Animal`, `Weight (kg)`, `Color`, `Price ($)`, `Description`, `Adress`, `users_ID`) VALUES (DEFAULT, 'Cat', '3', 'White', 75, 'Новорожденная русская голубая кошка. Документы - в наличии, как и очень добрый, ласковый характер. Когтедралка - в подарок.', 'ул. Сухаревская 12-74', 2);\n");
                statement.executeUpdate("INSERT INTO `malishevskiy`.`ads` (`ID`, `Animal`, `Weight (kg)`, `Color`, `Price ($)`, `Description`, `Adress`, `users_ID`) VALUES (DEFAULT, 'Parrot', '2', 'Red-White-Blue', 200, 'Годовалый (год от роду) разговаривающий попугай прямиком из Турции. Может запомнить до 500 слов, детишек особо радует. За лишние 30$ отдаем корм на месяц + стойку с клеткой', 'ул. Индустриальная 5-5', 2);\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}