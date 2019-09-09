package com.example.email.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
    @Resource
    MailService mailService;
    @Test
    public void sendSimpleMailTest(){
        mailService.sendSimpleMail("616934150@qq.com","测试","这是一个测试邮件");
    }

    @Test
    public void sendHtmlMailTest() throws MessagingException {
        String content="<html>\n"+
                "<body>\n"+
                "<h3>hello world , 这是一封邮件!!!</h3>\n"+
                "</body>\n"+
                "</html>";
        mailService.sendHtmlMail("616934150@qq.com","html测试",content);
    }

    @Test
    public void sendAttachmentMailTest() throws MessagingException {
        String filePath = "/home/tgc/IdeaProjects/SendEmail/pom.xml";
        mailService.sendAttachmentsMail("616934150@qq.com","附件测试","这是一封带附件的邮件",filePath);
    }
}
