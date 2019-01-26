package by.it.malishevskiy.jd03_02.crud.CRUD;


//public class Roles_CRUD {
//    boolean create (Roles roles) throws SQLException {
//        try (Connection connection = ConnectionCreator.getConnection();
//             Statement statemant = connection.createStatement()) {
//            String sql = String.format(
//                    "INSERT INTOv`roles` (`Role`) VALUES ('%s')", roles.getRole());
//            if (l == statemant.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS))
//            {
//                ResultSet keys = statemant.getGeneratedKeys();
//            }
//            return (l == statemant.executeUpdate(sql));
//        }
//    }
//}