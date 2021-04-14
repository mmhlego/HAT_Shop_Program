package DataController;

import java.sql.*;

public class DBConnector {

    private static ResultSet Results;
    public static Connection Con;

    public static boolean Connect() {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://freedb.tech/freedbtech_hatshopsystem",
                    "freedbtech_hatusername", "hatpassword");

            if (Con != null) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public static ResultSet RunCommand(String Command) throws Exception {
        Results = null;

        Statement stmt = Con.createStatement();
        Results = stmt.executeQuery(Command);

        return Results;
    }

}
