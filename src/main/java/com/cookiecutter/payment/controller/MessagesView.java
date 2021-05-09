package com.cookiecutter.payment.controller;

import com.cookiecutter.payment.services.MailService;
import com.cookiecutter.payment.dto.MessageViewItem;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.RequestScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javax.mail.Folder.READ_ONLY;

/**
 * JSF View component for the messages page
 * @author      Farzan Zubair
 */

@Slf4j
@Component
@RequestScoped
public class MessagesView {

    @Autowired
    MailService mailService;

    @Getter
    @Setter
    private String emailAddress;

    public List<MessageViewItem> getMessagesBy(String emailAddress) {
        Message[] messages = new Message[0];
        try {
            messages = mailService.retrieveMessages(emailAddress);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        List<MessageViewItem> messageViewItems = new ArrayList<>();
        for(int i=0;i< messages.length;i++) {
            MessageViewItem item = new MessageViewItem();
            try {
                try {
                    if (!messages[i].getFolder().isOpen()) {
                        messages[i].getFolder().open(READ_ONLY);
                    }
                }catch(NullPointerException e){
                    log.error(e.getMessage());
                    if (!messages[i].getFolder().isOpen()) {
                        messages[i].getFolder().open(READ_ONLY);
                    }
                }
            item.setFrom(messages[i].getFrom()[0].toString());
            item.setContent(messages[i].getContent().toString());
            item.setSubject(messages[i].getSubject());
            messageViewItems.add(item);
            } catch (MessagingException | IOException e) {
                e.printStackTrace();
            }
        }
        return messageViewItems;
    }

}
