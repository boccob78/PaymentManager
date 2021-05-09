package com.cookiecutter.payment.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The DTO for the data to view layer conversion
 * for messages
 * @author      Farzan Zubair
 */

@Getter
@Setter
public class MessageViewItem {

    String from;
    String subject;
    String content;
}
