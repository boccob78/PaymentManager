package com.cookiecutter.payment.services;

import com.icegreen.greenmail.user.GreenMailUser;
import com.icegreen.greenmail.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Start greenmail and provides methods to send an read mail
 *
 * @author      Farzan Zubair
 */

@Service
@Slf4j
public class MailService {


    GreenMail greenMail;

    /**
     * Start the greenmail service
     *
     */

    @PostConstruct public void init(){
        greenMail = new GreenMail(new ServerSetup[]{new ServerSetup(3025, (String)null, "smtp"),new ServerSetup(3110, (String)null, "pop3")});
        greenMail.start();
    }

    /**
     * Teardown greenmail service
     *
     */

    @PreDestroy
    public void onExit() {
        log.info("###STOPPING GREENMAIL###");
        greenMail.stop();
    }

    /**
     * Utility method to send mail
     * @param  subject
     * @param  to
     * @param content
     *
     */

    public void notifyUser(String subject, String to, String content) {

        GreenMailUtil.sendTextEmail(to,"admin@cookiecutter.com",subject, content, greenMail.getSmtp().getServerSetup());
    }

    /**
     * Utility method to return mails in the pop3 INBOX
     * @param  email
     * @return list of Mail Messages
     *
     */
    public Message[] retrieveMessages(String email) throws MessagingException {
        GreenMailUser user = greenMail.setUser(email, email, email);
        try (Retriever retriever = new Retriever(greenMail.getPop3())) {
            return  retriever.getMessages(email);
        }
    }
}