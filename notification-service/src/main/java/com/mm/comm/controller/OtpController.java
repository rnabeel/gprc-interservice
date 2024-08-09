package com.mm.comm.controller;

import com.mm.comm.dto.OTPRequestDTO;
import com.mm.comm.service.EmailService;
import com.mm.comm.service.SMSService;
import com.mm.comm.service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class OtpController {

    private final EmailService emailService;
    private final SMSService smsService;
    private final TemplateService templateService;

    @Async
    @PostMapping("/otp/email")
    public ResponseEntity<Void> sendOTPMail(@RequestBody OTPRequestDTO otpRequestDTO) {
        if(otpRequestDTO.getOtp().equals("123456")){
            return ResponseEntity.accepted().build();
        }
//        String emailContent = templateService.createOtpEmailContent(otpRequestDTO.getUserName(), otpRequestDTO.getOtp());
        emailService.sendSimpleMessage(otpRequestDTO.getEmail(), otpRequestDTO.getSubject(), otpRequestDTO.getOtp());
        smsService.sendSMS(otpRequestDTO.getPhoneNumber(), otpRequestDTO.getOtp());
        return ResponseEntity.accepted().build();
    }


    @PostMapping("/sendOtpSms")
    public ResponseEntity<HttpStatus> sendOTPSMS(@RequestBody Map request) {
        smsService.sendSMS(" ", " ");
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
