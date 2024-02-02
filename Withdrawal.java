import java.sql.*;

public class BankAccount{
       public static final String url="";
       public static final String user="user name";
       public static final String password="password";
       public static connection con;
       public static statement stmt;
       public static Resultset rs;
       public void withdrawal(int account_number,double amount){
          try{
               connection con =DriverManager.getconnection(url,user,password);
               statement stmt=con.createstatement();
               Resultset rs=stmt.executeQuery("SELECT balance FROM account WHERE account_number="+account_number);
               if(rs.next()){
                 double balance=rs.getdouble(1);
                 if(balance>=amount){
                   double newbalance=balance-amount;
                   rs=stmt.executeQuery("UPDATE account  SET balance ="+newbalance "WHERE account_number="+account_number);
                 System.out.println("Withdrawal successful balance="+newbalance);
               }
               else{
                 System.out.println("Insufficient funds");
               }
             }
           }
           catch(SQL Exception se)
           {
             seEX.printstack Trace[];
           }
           finally{
             try{
               con.close();
             }
             catch(SQL Exception se){
             }
           try{
             stmt.close();
           }
           catch(SQL Exception se){
               }
               try{
                 rs.close();
               }
               catch(SQL Exception se){
                 }
               }
               }
               public Static void main(String[] args) {
               withdrawal(1234,123);
  }
}
