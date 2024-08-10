package com.mm.grpc.controller;

import com.mm.comm.UserInformation;
import com.mm.grpc.service.GrpcClientServiceB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/serverA")
public class TestController {


   private GrpcClientServiceB grpcClientServiceB;

    public TestController(GrpcClientServiceB grpcClientServiceB) {
        this.grpcClientServiceB = grpcClientServiceB;
    }

    @GetMapping("/test")
    public Object hello(){
        System.out.println("----------- Rest call received -----------");
        UserInformation userInformation  = grpcClientServiceB.getUserInformation("1");
        System.out.println("reponse sent back");
        return Map.of("user id",userInformation.getUserId(),"user email",userInformation.getEmail(),"name",userInformation.getName());
    }
}
