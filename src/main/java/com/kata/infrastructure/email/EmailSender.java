package com.kata.infrastructure.email;

import java.util.logging.Logger;

public class EmailSender {

    private static final Logger logger = Logger.getLogger(EmailSender.class.getName());

    public void send(Email email) {
        logger.info(String.format("Sending greetings to %s", email.getTo()));
    }

}
