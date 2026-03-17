import java.sql.*;
import java.util.Scanner;

public class Update {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/question_bank";
        String user = "root";
        String pass = "Paritosh@123";

        String sql = "UPDATE QB_table SET answer = ? WHERE sno = ?";

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter the sno. of the answer: ");
            int s_no = sc.nextInt();

            System.out.print("Enter answer: ");
            String ans = sc.next();

            ps.setString(1, ans);
            ps.setInt(2, s_no);
           

            ps.executeUpdate();
            System.out.println("Update done..");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
