package com.githubwebhook.webhook.controller;

import com.githubwebhook.webhook.Model.User;
import com.githubwebhook.webhook.Service.MailService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by divyank.r on 06/02/21.
 */
@RestController
public class Event {
    @Autowired
    private MailService notificationService;

    @Autowired
    private User user;

    @RequestMapping("/")
    public String getEmail(HttpServletRequest requestParam, @RequestBody(required = false) String body)
    {
        JSONObject jsonObj = new JSONObject();
        Map<String,String[]> params = requestParam.getParameterMap();
        for (Map.Entry<String,String[]> entry : params.entrySet()) {
            String v[] = entry.getValue();
            Object o = (v.length == 1) ? v[0] : v;
            jsonObj.put(entry.getKey(), o);
        }
        System.out.println("Request Params="+jsonObj);
        System.out.println("Request body="+body);

        /*
		 * Creating a User with the help of User class that we have declared. Setting
		 * the First,Last and Email address of the sender.
		 */
        user.setFirstName("Divyank");
        user.setLastName("Rastogi");
        user.setEmailAddress("rastogi.divyank739@gmail.com"); //Receiver's email address

		/*
		 * Here we will call sendEmail() for Sending mail to the sender.
		 */
        try {
            notificationService.sendEmail(user);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your mail has been send to the user.";
    }
}