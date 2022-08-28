package com.example.email.quartz;

import com.example.email.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class EmailTask{

    @Autowired
    private MailService mailService;

    private int count = 1;

    @Scheduled(cron = "*/10 * * * * ?")
    public void process() {
        System.out.println("开始发送邮件");
        mailService.sendSimpleMail("616934150@qq.com","测试"+(count++)+"","恭喜您中奖5000万冥币,请速到地府领取!");
        System.out.println("发送定时邮件成功");
    }
}