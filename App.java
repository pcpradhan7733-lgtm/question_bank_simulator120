import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class App {
     public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/DATABASE_NAME";
        String user = "root";
        String pass = "PASSWORD";
        Scanner sc=new Scanner(System.in);
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection(url, user, pass);
        
            PreparedStatement ps = con.prepareStatement("SELECT sno,question,A,B,C,D  FROM QB_table");
            ResultSet rs = ps.executeQuery();

           
            while (rs.next()) {
                System.out.println(
                        rs.getInt("sno") + "  "+
                        rs.getString("question") + "\nA   "+
                        rs.getString("A")+"\nB   "+
                        rs.getString("B")+"\nC   "+
                        rs.getString("C")+"\nD   "+
                        rs.getString("D")

                );
            }
    }catch (Exception e) {
            e.printStackTrace();
        }
}
}
