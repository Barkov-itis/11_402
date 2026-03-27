package ru.itis.spring_11_402.services;

public interface MailService {
    void sendEmailForConfirm(String email, String code);
}
