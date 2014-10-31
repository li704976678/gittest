package dbtest;


import java.sql.*;

import javax.swing.JOptionPane;



public class DbTest {
	
	public void add(UserEntity user){
		
		PreparedStatement ps=null;
        Connection conn=null;
        //ResultSet rs=null;
        conn= DBManager.getCon();
        String sql="insert into user_tb values (?,?,?)";
        try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(JOptionPane.showInputDialog("输入ID："));
		String username=JOptionPane.showInputDialog("请输入姓名：");
		String password=JOptionPane.showInputDialog("请输入密码：");
		UserEntity user=new UserEntity();
		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		new DbTest().add(user);
		System.out.println("添加成功！");

	}

}
