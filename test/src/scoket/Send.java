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
		String toip="127.0.0.1";//�Է���IP
		String words="Hello";//�Է��Ļ�
		String temp=null;
		byte[] serverSay = new byte[1000];//��ȡ<1KB
		//InputStreamReader read=new InputStreamReader(System.in);
		int len=0;
		Socket s;
		OutputStream os;
		InputStream is;
		//ȡ���������IP
		//System.out.println("������Է���IP(Ĭ�Ϸ����Լ�):");
		//try{

			//temp=new BufferedReader(read).readLine();
			temp=JOptionPane.showInputDialog("������ip:");
			if(!temp.equals(""))
				toip=temp;

		//}
		//catch(IOException e1){}
		//ȡ���������Message
		//System.out.println("�����������(��)˵�Ļ�(Ĭ������,ҪС��1KB������QUIT �˳�):");
		while(true)
		{
			try{
				temp="Hello";
				//temp=new BufferedReader(read).readLine();
				temp=JOptionPane.showInputDialog("��������Ҫ˵�Ļ���");
				words=temp;
				if(words.equals("quit"))
					break;
				temp="user said:"+words+"  At ("+new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss.SSSZ").format(new Date())+")";
				//����ͨ��
				s = new Socket(InetAddress.getByName(toip), 9527);//�׽��ֵ�IP��ַ�Ͷ˿ں�
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
		}//end while
	}

}
