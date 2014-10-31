package dbtest;

import java.sql.*;

public class DBManager {
	private static final String DRIVER_PATH="com.mysql.jdbc.Driver";       //��oracle.jdbc.driver.OracleDriver��
	private static final String URL="jdbc:mysql://localhost:3306/mydb";
       // (jdbc:oracle://localhost:1521/ORCL)
	private static final String USERNAME="root";
	private static final String PASSWORD="123456";
	
	//��������
	static {
		try{
			Class.forName(DRIVER_PATH);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	//�������ݿ�
	public static Connection getCon(){
		Connection con=null;
		try{
			con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
		
	}
	
	//�ر����ݿ�
	public static void close(ResultSet rs,Statement s,Connection con){
		try{
			if(rs!=null){
				rs.close();
			}
			if(s!=null){
				s.close();
			}
			if(con!=null){
				con.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}