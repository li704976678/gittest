package test;

import java.util.Date;
import java.util.Properties;
 
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
 
/**
 *author:李明
 *date:2008-7-17
 *
 **/
public class SendMail {
 private static MailAuthenticator autherticator=null;
 public static void main(String[] args) {
    
      
    String from="lm704976678@163.com";
    String to="1243693916@qq.com";
    String smtpServer="smtp.163.com";
    String subject="Hello ,this is a email Test!!";
    String content ="鸭子个坑货!!";
    Properties props = System.getProperties();
     
    props.put("mail.smtp.host", smtpServer);
    props.put("mail.smtp.auth","true");
    autherticator = new MailAuthenticator("lm704976678@163.com","liming5201314");
    Session session = Session.getDefaultInstance(props,autherticator);
    MimeMessage msg = new MimeMessage(session);
    try{
       msg.setFrom(new InternetAddress(from));
       msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
       msg.setSubject(subject);
       msg.setSentDate(new Date());
       msg.setText(content);
       Transport.send(msg);
       System.out.println("成功发送邮件......");
    }catch(Exception se){
        se.printStackTrace();
    }
    
}
}
