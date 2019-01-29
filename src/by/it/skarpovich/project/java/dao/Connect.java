package by.it.skarpovich.project.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Connect {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static volatile Connection connection;

    static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (Connect.class) {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(CONFIG.DB_URL, CONFIG.USER, CONFIG.PASSWORD);  // CONFIG.DB_URL - коннектимся к нужной базе
                }
            }
        }
        return connection;
    }

    static void reset() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try (Connection connection = DriverManager.getConnection(CONFIG.URL, CONFIG.USER, CONFIG.PASSWORD))  // CONFIG.URL - нужная база еще не создана
        {
            Statement statement = connection.createStatement();

            statement.executeUpdate("DROP SCHEMA IF EXISTS `skarpovich`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `skarpovich` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `skarpovich`.`roles` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `role` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  UNIQUE INDEX `role_UNIQUE` (`role` ASC))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `skarpovich`.`users` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `username` VARCHAR(45) NULL," +
                    "  `password` VARCHAR(45) NULL," +
                    "  `email` VARCHAR(45) NULL," +
                    "  `fullname` VARCHAR(45) NULL," +
                    "  `phone` VARCHAR(45) NULL," +
                    "  `address` VARCHAR(100) NULL," +
                    "  `roles_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  UNIQUE INDEX `username_UNIQUE` (`username` ASC)," +
                    "  UNIQUE INDEX `email_UNIQUE` (`email` ASC)," +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC)," +
                    "  CONSTRAINT `fk_users_roles`" +
                    "    FOREIGN KEY (`roles_id`)" +
                    "    REFERENCES `skarpovich`.`roles` (`id`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `skarpovich`.`items` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `title` VARCHAR(45) NULL," +
                    "  `floors` INT NULL," +
                    "  `square` INT NULL," +
                    "  `materials` VARCHAR(300) NULL," +
                    "  `price` DOUBLE NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  UNIQUE INDEX `title_UNIQUE` (`title` ASC))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `skarpovich`.`orders` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `date` DATE NULL," +
                    "  `time` TIME NULL," +
                    "  `users_id` INT NOT NULL," +
                    "  `items_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_orders_users1_idx` (`users_id` ASC)," +
                    "  INDEX `fk_orders_items1_idx` (`items_id` ASC)," +
                    "  CONSTRAINT `fk_orders_users1`" +
                    "    FOREIGN KEY (`users_id`)" +
                    "    REFERENCES `skarpovich`.`users` (`id`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE," +
                    "  CONSTRAINT `fk_orders_items1`" +
                    "    FOREIGN KEY (`items_id`)" +
                    "    REFERENCES `skarpovich`.`items` (`id`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE)" +
                    "ENGINE = InnoDB;");


            statement.executeUpdate("INSERT INTO `skarpovich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `skarpovich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `skarpovich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");

            statement.executeUpdate("INSERT INTO `skarpovich`.`users` (`id`, `username`, `password`, `email`, `fullname`, `phone`, `address`, `roles_id`) " +
                    "VALUES (DEFAULT, 'admin', 'admin', 'admin@admin.com', 'John Black', '911-911-9111', 'Kremlin, Russia', 1);");
            statement.executeUpdate("INSERT INTO `skarpovich`.`users` (`id`, `username`, `password`, `email`, `fullname`, `phone`, `address`, `roles_id`) " +
                    "VALUES (DEFAULT, 'john', 'john1', 'johndoe@yahoo.com', 'John Doe', '212-564-5555', '444 W. 27th Street, 4th Floor, New York, NY 10001', 2);");
            //added user
            statement.executeUpdate("INSERT INTO `skarpovich`.`users` (`id`, `username`, `password`, `email`, `fullname`, `phone`, `address`, `roles_id`) " +
                    "VALUES (DEFAULT, 'billy', 'john1', 'billgates@yahoo.com', 'Bill Gates', '111-555-7777', 'Best street 10, 4th Floor, Los Angeles, LA 23001', 2);");

            //added item
            statement.executeUpdate("INSERT INTO `skarpovich`.`items` (`id`, `title`, `floors`, `square`, `materials`, `price`) " +
                    "VALUES (DEFAULT, 'Zx87', 1, 133, 'aerated concrete, ceramic blocks', 510);");
            statement.executeUpdate("INSERT INTO `skarpovich`.`items` (`id`, `title`, `floors`, `square`, `materials`, `price`) " +
                    "VALUES (DEFAULT, 'Zx152', 2, 299, 'ceramic blocks', 640);");

            statement.executeUpdate("INSERT INTO `skarpovich`.`items` (`id`, `title`, `floors`, `square`, `materials`, `price`) " +
                    "VALUES (DEFAULT, 'Zx170', 2, 400, 'wood and stone', 790);");


            statement.executeUpdate("INSERT INTO `skarpovich`.`orders` (`id`, `date`, `time`, `users_id`, `items_id`) " +
                    "VALUES (DEFAULT, '2019-01-19', '10:59:59', 2, 1);");
            statement.executeUpdate("INSERT INTO `skarpovich`.`orders` (`id`, `date`, `time`, `users_id`, `items_id`) " +
                    "VALUES (DEFAULT, '2019-01-20', '11:00:00', 2, 2);");
            // added order
            statement.executeUpdate("INSERT INTO `skarpovich`.`orders` (`id`, `date`, `time`, `users_id`, `items_id`) " +
                    "VALUES (DEFAULT, '2019-01-20', '05:04:04', 2, 3);");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}