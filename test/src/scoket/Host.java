package scoket;

import java.io.*;//BufferedReader
import java.net.*;
import java.text.*;
import java.util.*;
public class Host
{
	public static void main(String args[])
	{
		String reces=null;
		String ret=null;
		int len;
		Socket s;
		OutputStream os;
		InputStream is;
		byte[] rece = new byte[1000];
		try 
		{
			@SuppressWarnings("resource")
			ServerSocket ss = new ServerSocket(9527); //服务器的套接字，端口为9527
			while(true)
			{
				s = ss.accept();
				os = s.getOutputStream();
				is = s.getInputStream();
				len= is.read(rece);//接受客户端消息
				if(len!=0)
					reces=new String(rece, 0, len);
				System.out.println(reces);
				ret="I'am the host,I received you words at ("+new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss.SSSZ").format(new Date())+")";
				os.write(ret.getBytes());//返回给客户端的欢迎信息
				is.close();
				os.close();
				s.close();//记住一定要关闭这些输入，输出流和套接字
			}//end while
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
