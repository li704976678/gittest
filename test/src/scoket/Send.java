package scoket;

import java.io.*;//BufferedReader
import java.net.*;
import java.text.*;
import java.util.*;

import javax.swing.JOptionPane;
public class Send
{

	public void send(String toip,String words){
		String ip="127.0.0.1";//�Է���IP
		String temp=null;
		byte[] serverSay = new byte[1000];//��ȡ<1KB
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
				//����ͨ��
				s = new Socket(InetAddress.getByName(ip), 9527);//�׽��ֵ�IP��ַ�Ͷ˿ں�
				os = s.getOutputStream();
				is = s.getInputStream();
				os.write(temp.getBytes("ISO-8859-1"));//�������������Ϣ
				len = is.read(serverSay);//���ܷ�������Ϣ
				System.out.println(new String(serverSay, 0, len));//�ͻ��˿���̨��ʾ���������ص���Ϣ
				is.close();
				os.close();
				s.close();//��סһ��Ҫ�ر���Щ���룬��������׽���
				break;
			} 
			catch (Exception e) {}
		}
	}

}
