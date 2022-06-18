package com.example.SIH.MailingService.mail;

//import freemarker.template.TemplateException;

import java.util.List;

public interface EmailService {
        void sendSimpleMessage(String to, String subject, String text);
        void sendSimpleMessage(List<String> toList, String subject, String text);
        void sendSimpleMessageUsingTemplate(String to, String subject, String... templateModel);
        void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment);
}
