package scoket;

import java.io.*;//BufferedReader
import java.net.*;
import java.text.*;
import java.util.*;

import javax.swing.JOptionPane;
public class Send
{

	public void send(String toip,String words){
		String ip="127.0.0.1";//对方的IP
		String temp=null;
		byte[] serverSay = new byte[1000];//读取<1KB
		int len=0;
		Socket s;
		OutputStream os;
		InputStream is;
			if(!toip.equals(""))
				ip=toip;
		while(true)
		{
			try{
				if(words.equals("quit"))
					break;
				temp="user said:"+words+"  At ("+new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss.SSSZ").format(new Date())+")";
				//发起通信
				s = new Socket(InetAddress.getByName(ip), 9527);//套接字的IP地址和端口号
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
		}
	}

}
