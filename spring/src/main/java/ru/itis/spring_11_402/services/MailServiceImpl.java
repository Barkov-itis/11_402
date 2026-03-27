package ru.itis.spring_11_402.services;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.SpringTemplateLoader;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class MailServiceImpl implements MailService{

    @Value("${spring.mail.username}")
    private String mailForm;

    @Autowired
    private JavaMailSender javaMailSender;

    private final Template confirmMAilTemplate;

    public MailServiceImpl() {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateLoader(
                new SpringTemplateLoader(
                new ClassRelativeResourceLoader(this.getClass()), "/"));
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        try {
            this.confirmMAilTemplate = configuration.getTemplate("templates/confirm_mail.ftlh");
        }catch (IOException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public void sendEmailForConfirm(String email, String code) {
        String mailText = getEmailText(code);
        MimeMessagePreparator messagePreparator = getEmail(email, mailText);
        javaMailSender.send(messagePreparator);
    }

    private String getEmailText(String code) {
        Map<String, String> attributes = new HashMap<>();
        attributes.put("confirm_code", code);
        StringWriter writer = new StringWriter();
        try {
            confirmMAilTemplate.process(attributes, writer);
        } catch (TemplateException | IOException e) {
            throw new RuntimeException(e);
        }
        return writer.toString();
    }

    private MimeMessagePreparator getEmail(String email, String mailText) {
        return mimeMessage -> {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setText(mailText, true);
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setFrom(mailForm);
            mimeMessageHelper.setSubject("Регистрация");
        };
    }
}



















