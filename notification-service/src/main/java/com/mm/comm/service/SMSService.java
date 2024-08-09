package com.mm.comm.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SMSService {
    @Value("${twilio.account_sid}")
    private String accountSid;

    @Value("${twilio.auth_token}")
    private String authToken;

    @Value("${twilio.from_number}")
    private String fromNumber;

    public void sendSMS(String to, String otp) {
        String message = "\n Hi, Your OTP for UCO verification is: "+otp;
        System.out.println("To phone: "+to);
        try {
            Twilio.init(accountSid, authToken);
            Message.creator(
                    new PhoneNumber(to),
                    new PhoneNumber(fromNumber),
                    message
            ).create();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
