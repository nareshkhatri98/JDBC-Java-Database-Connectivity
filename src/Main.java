import java.math.BigInteger;
import java.sql.*;
import java.util.Scanner;
import  java.sql.ResultSet;

public class Main{
    public  static  void  main(String [] args)
    {
        System.out.println("Welcome to the  first program of the JDBC......");
//
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "");
            System.out.println(con);
            Scanner sc  = new Scanner(System.in);
            System.out.println("Enter your id:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter your phone number");
            String phone = sc.nextLine();
            System.out.println("Enter your name:");
            String name = sc.nextLine();

          //  insert operation
            String insertdata = "insert into student (id, phone , name) values(?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(insertdata);
           stmt.setInt(1, 12);
           stmt.setString(2, phone);
           stmt.setString(3,name);

           int result = stmt.executeUpdate();

           if(result > 0)
           {
               System.out.println("The new student is added successfully...");
           }
            //disply operation
            Statement stmt1 = con.createStatement();
            String displyQuery = "select * from student";
            ResultSet rs = stmt1.executeQuery(displyQuery);
            while(rs.next()){
                System.out.println("id is:" +rs.getInt(1));
                System.out.println("phone is:" +rs.getString(2));
                System.out.println("name is: "+rs.getString(3));
            }
// delete operttion.
//            String deleteQuery = "delete from student where id= 12";
//
//            int r = stmt.executeUpdate(deleteQuery);
//            if(r>0)
//
//            {
//                System.out.println("deleted");
//            }
        } catch (Exception e)
        {
            System.out.println(e);
        }
        }


    }
