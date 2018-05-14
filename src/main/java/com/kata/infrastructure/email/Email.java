package com.kata.infrastructure.email;

import java.util.Objects;

public class Email {

    private final String to;
    private final String subject;
    private final String body;

    public Email(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    String getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(to, email.to) &&
                Objects.equals(subject, email.subject) &&
                Objects.equals(body, email.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to, subject, body);
    }
}
