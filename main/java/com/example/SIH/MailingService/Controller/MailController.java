package com.example.SIH.MailingService.Controller;


import com.example.SIH.MailingService.entitiy.MailObject;
import com.example.SIH.MailingService.mail.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    public EmailService emailService;

//    @Value("${attachment.invoice}")
//    private String attachmentPath;

    private static final Map<String, Map<String, String>> labels;

    static {
        labels = new HashMap<>();

        //Simple email
        Map<String, String> props = new HashMap<>();
        props.put("headerText", "Send Simple Email");
        props.put("messageLabel", "Message");
        props.put("additionalInfo", "");
        labels.put("send", props);

        //Email with template
        props = new HashMap<>();
        props.put("headerText", "Send Email Using Text Template");
        props.put("messageLabel", "Template Parameter");
        props.put("additionalInfo",
                "The parameter value will be added to the following message template:<br>" +
                        "<b>This is the test email template for your email:<br>'Template Parameter'</b>"
        );
        labels.put("sendTemplate", props);

        //Email with attachment
        props = new HashMap<>();
        props.put("headerText", "Send Email With Attachment");
        props.put("messageLabel", "Message");
        props.put("additionalInfo", "To make sure that you send an attachment with this email, change the value for the 'attachment.invoice' in the application.properties file to the path to the attachment.");
        labels.put("sendAttachment", props);

    }

    @RequestMapping(method = RequestMethod.GET)
    public String showEmailsPage() {

        emailService.sendSimpleMessage(new ArrayList<>(Arrays.asList("devalmmudia@gmail.com","vibhaeomudia@gmail.com")),
                "Test Email from Spring", "This the text sent from Spring framework");
        return "emails";
    }

    @RequestMapping(value = {"/send", "/sendTemplate", "/sendAttachment"}, method = RequestMethod.GET)
    public String createMail(Model model,
                             HttpServletRequest request) {
        String action = request.getRequestURL().substring(
                request.getRequestURL().lastIndexOf("/") + 1
        );
        Map<String, String> props = labels.get(action);
        Set<String> keys = props.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            model.addAttribute(key, props.get(key));
        }

        model.addAttribute("mailObject", new MailObject());
        return "mail/send";
    }


    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String createMail(Model model,
                             @ModelAttribute("mailObject") @Valid MailObject mailObject,
                             Errors errors) {
        if (errors.hasErrors()) {
            return "mail/send";
        }
        emailService.sendSimpleMessage(mailObject.getTo(),
                mailObject.getSubject(), mailObject.getText());

        return "emails";
    }

    @RequestMapping(value = "/sendTemplate", method = RequestMethod.POST)
    public String createMailWithTemplate(Model model,
                                         @ModelAttribute("mailObject") @Valid MailObject mailObject,
                                         Errors errors) {
        if (errors.hasErrors()) {
            return "mail/send";
        }
        emailService.sendSimpleMessageUsingTemplate(mailObject.getTo(),
                mailObject.getSubject(),
                mailObject.getText());

        return "redirect:/mail";
    }
}
