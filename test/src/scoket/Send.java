package scoket;

import java.io.*;//BufferedReader
import java.net.*;
import java.text.*;
import java.util.*;

import javax.swing.JOptionPane;
public class Send
{
	public static void main(String args[])
	{
		String toip="127.0.0.1";//对方的IP
		String words="Hello";//对方的话
		String temp=null;
		byte[] serverSay = new byte[1000];//读取<1KB
		//InputStreamReader read=new InputStreamReader(System.in);
		int len=0;
		Socket s;
		OutputStream os;
		InputStream is;
		//取得你给他的IP
		//System.out.println("请输入对方的IP(默认发给自己):");
		//try{

			//temp=new BufferedReader(read).readLine();
			temp=JOptionPane.showInputDialog("请输入ip:");
			if(!temp.equals(""))
				toip=temp;

		//}
		//catch(IOException e1){}
		//取得你各他的Message
		//System.out.println("请输入想对他(她)说的话(默认您好,要小于1KB，输入QUIT 退出):");
		while(true)
		{
			try{
				temp="Hello";
				//temp=new BufferedReader(read).readLine();
				temp=JOptionPane.showInputDialog("请输入您要说的话：");
				words=temp;
				if(words.equals("quit"))
					break;
				temp="user said:"+words+"  At ("+new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss.SSSZ").format(new Date())+")";
				//发起通信
				s = new Socket(InetAddress.getByName(toip), 9527);//套接字的IP地址和端口号
				os = s.getOutputStream();
				is = s.getInputStream();
				os.write(temp.getBytes("ISO-8859-1"));//向服务器发送消息
				len = is.read(serverSay);//接受服务器消息
				System.out.println(new String(serverSay, 0, len));//客户端控制台显示服务器返回的信息
				is.close();
				os.close();
				s.close();//记住一定要关闭这些输入，输出流和套接字
				break;
			} 
			catch (Exception e) {}
		}//end while
	}

}
