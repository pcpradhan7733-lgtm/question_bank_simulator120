import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Create {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/question_bank";
        String user = "root";
        String pass = "Paritosh@123";

        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            String insertSql = "INSERT INTO QB_table(sno, question,A,B,C,D,answer) VALUES (?, ?,?,?,?,?,?)";
            System.out.print("Enter How many questions to insert: ");
            int n = sc.nextInt();
            

            PreparedStatement ps = con.prepareStatement(insertSql);

            for (int i = 0; i < n; i++) {
                System.out.print("sno: ");
                ps.setInt(1, sc.nextInt());
                System.out.print("question: ");
                String name= sc.next();
                ps.setString(2, name);
                System.out.print("A: ");
                ps.setString(3, sc.next());
                System.out.print("B: ");
                ps.setString(4, sc.next());
                System.out.print("C: ");
                ps.setString(5, sc.next());
                 System.out.print("D: ");
                ps.setString(6, sc.next());
                 System.out.print("Answer: ");
                ps.setString(7, sc.next());
                ps.executeUpdate();
                
            }
            System.out.println("Insert done...");
    }catch (Exception e) {
            e.printStackTrace();
        }
 }
}