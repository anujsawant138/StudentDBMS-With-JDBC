import java.sql.*;
import java.util.Scanner;
class UpdateDetails {
    static void UpdateName(Scanner sc,PreparedStatement p) throws SQLException {
        char choice=0;
        do {
            System.out.print("Enter Your ID:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Your Name:");
            String name = sc.nextLine();
            p.setString(1, name);
            p.setInt(2, id);
            int r = p.executeUpdate();
            if (r > 0) {
                System.out.println("Name Updated Successfully...");
            } else {
                System.out.println("Unable to Update Name...");
            }
            System.out.print("\nDo you want to continue? (y/n): ");
            choice = sc.next().charAt(0);
            sc.nextLine();
        } while (choice == 'y' || choice == 'Y');
    }
    static void UpdateAge(Scanner sc,PreparedStatement p) throws SQLException {
        char choice=0;
        do {
            System.out.print("Enter Your ID:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Your Age:");
            int age = sc.nextInt();
            sc.nextLine();
            p.setInt(1, age);
            p.setInt(2, id);
            int r = p.executeUpdate();
            if (r > 0) {
                System.out.println("Age Updated Successfully...");
            } else {
                System.out.println("Unable to Update Age...");
            }
            System.out.print("\nDo you want to continue? (y/n): ");
            choice = sc.next().charAt(0);
            sc.nextLine();
        } while (choice == 'y' || choice == 'Y');
    }
    static void UpdateBoth(Scanner sc,PreparedStatement p) throws SQLException{
        char choice=0;
        do{
        System.out.print("Enter Your ID:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Your Name:");
        String name = sc.nextLine();
        System.out.print("Enter Your Age:");
        int age = sc.nextInt();
        sc.nextLine();
        p.setString(1,name);
        p.setInt(2,age);
        p.setInt(3,id);
        int r=p.executeUpdate();
        if(r>0){
            System.out.println("Data Updated Successfully...");
        }
        else{
            System.out.println("Unable to Update Data...");
        }
        System.out.print("\nDo you want to continue? (y/n): ");
        choice = sc.next().charAt(0);
        sc.nextLine();
    }while (choice == 'y' || choice == 'Y');}
}
public class StudentDBMS {
    static void AddStudent(Scanner sc,PreparedStatement p) throws SQLException {
        char choice=0;
        do {
        System.out.print("Enter Your ID:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Your Name:");
        String name = sc.nextLine();
        System.out.print("Enter Your Age:");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Your Department:");
        String dept=sc.nextLine();
        p.setInt(1,id);
        p.setString(2,name);
        p.setInt(3,age);
        p.setString(4,dept);
        int r=p.executeUpdate();
        if(r>0){
            System.out.println("Data Added Successfully...");
        }
        else{
            System.out.println("Unable to Add Data...");
        }
            System.out.print("\nDo you want to Add Another Student? (y/n): ");
            choice = sc.next().charAt(0);
            sc.nextLine();
    }while (choice == 'y' || choice == 'Y');
    }

    static void Display(PreparedStatement pt) throws SQLException {
        ResultSet r = pt.executeQuery();
        boolean flag = false;
        while (r.next()){
            flag=true;
            System.out.println("=================================");
            var id=r.getInt("id");
            String name=r.getString("name");
            var age=r.getInt("age");
            String branch = r.getString("branch");
            System.out.println("ID: "+id+"\nName: "+name+"\nAge: "+age+"\nBranch:"+branch);
        }
        if(!flag){
            System.out.println("No Data Found...");
        }

    }

    static void DeleteStudent(Scanner sc,PreparedStatement p) throws SQLException {
        char choice = 0;
        do {
            System.out.print("Enter Your ID:");
            int id = sc.nextInt();
            sc.nextLine();
            p.setInt(1, id);
            int r = p.executeUpdate();
            if (r > 0) {
                System.out.println("Student Data Deleted Successfully...");
            } else {
                System.out.println("Unable to delete Student Data...");
            }
            System.out.print("\nDo you want to Delete data of Another Student? (y/n): ");
            choice = sc.next().charAt(0);
            sc.nextLine();
        } while (choice == 'y' || choice == 'Y');
    }

    static void SearchID(Scanner sc,PreparedStatement p) throws SQLException {
        char choice = 0;
        do {
            System.out.print("Enter Your ID:");
            int id = sc.nextInt();
            sc.nextLine();
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                String name = r.getString("name");
                System.out.println("Student Found...");
                System.out.println("Name:" + name);
            } else
                System.out.println("Student Not Found....");
            System.out.print("\nDo you want to Search another Student? (y/n): ");
            choice = sc.next().charAt(0);
            sc.nextLine();
        } while (choice == 'y' || choice == 'Y');
    }

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/First";
        String user = "postgres";
        String pass = "root";
        char choice = 0;
        UpdateDetails ud = new UpdateDetails();
        try (Connection con = DriverManager.getConnection(url, user, pass);
             Scanner sc = new Scanner(System.in)) {
            do{
            System.out.println("\n=================================");
            System.out.println(">---WELCOME TO STUDENT DBMS---<");
            System.out.println("=================================");
            System.out.println("--Your Choice--\n" +
                    "1. Add Student\n2. Display Student\n3. Update Details\n4. Delete Student\n5. Search Student\n6. Exit");
            System.out.println("\n=================================");
            System.out.print("Enter Your Choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: {
                    String query = "INSERT INTO StudentDBMS values(?,?,?,?);";
                    PreparedStatement pt = con.prepareStatement(query);
                    AddStudent(sc,pt);
                    pt.close();
                    break;
                }
                case 2: {
                    String query = "SELECT * FROM StudentDBMS;";
                    PreparedStatement pt = con.prepareStatement(query);
                    Display(pt);
                    pt.close();
                    break;
                }
                case 3: {
                    System.out.println("What Do You Want Change:\n1.Name\n2.Age\n3.Both");
                    int n = sc.nextInt();
                    if (n == 1) {
                        String query = "UPDATE StudentDBMS SET name=? where id =?";
                        PreparedStatement pt = con.prepareStatement(query);
                        ud.UpdateName(sc,pt);
                    pt.close();
                    } else if (n == 2) {
                        String query = "UPDATE StudentDBMS SET age=? where id =?";
                        PreparedStatement pt = con.prepareStatement(query);
                        ud.UpdateAge(sc,pt);
                    pt.close();
                    } else if (n == 3) {
                        String query = "UPDATE StudentDBMS SET name=?, age=? where id =?";
                        PreparedStatement pt = con.prepareStatement(query);
                        ud.UpdateBoth(sc,pt);
                    pt.close();
                    } else {
                        System.out.println(">-Enter Valid Choice-<");
                    }
                    break;
                }
                case 4:{
                    String query = "DELETE from StudentDBMS where id =?";
                    PreparedStatement pt = con.prepareStatement(query);
                    DeleteStudent(sc,pt);
                    pt.close();
                    break;
                }
                case 5:{
                    String query = "SELECT name FROM StudentDBMS where id =?";
                    PreparedStatement pt = con.prepareStatement(query);
                    SearchID(sc,pt);
                    pt.close();
                    break;
                }
                case 6:
                    System.out.println("Exiting Student DBMS...");
                    return;
                default:{
                    System.out.println("Enter Valid Choice....");
                }
            } System.out.print("\nDo you want to continue? (y/n): ");
                choice = sc.next().charAt(0);
                sc.nextLine();}
            while (choice == 'y' || choice == 'Y');
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}