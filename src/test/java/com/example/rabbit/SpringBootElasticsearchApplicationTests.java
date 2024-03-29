package com.example.rabbit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.elasticsearch.SpringBootElasticsearchApplication;
import com.example.elasticsearch.service.MailService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpringBootElasticsearchApplication.class)
public class SpringBootElasticsearchApplicationTests {

	@Autowired
    private JavaMailSender javaMailSender;
   
	
	@Test
    public void testSend(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("from your emial");//发送者.
        message.setTo("to somebody email");//接收者.
        message.setSubject("测试邮件（邮件主题）");//邮件主题.
        message.setText("这是邮件内容:do not judge a book by its cover!");//邮件内容.
        javaMailSender.send(message);//发送邮件
    }
	
	@Autowired  
    private MailService mailService;  
      
    private String to = "to somebody email";  
      
    @Test  
    public void sendSimpleMail() {  
        mailService.sendSimpleMail(to, "主题：简单邮件", "测试邮件内容");  
    }  

}
