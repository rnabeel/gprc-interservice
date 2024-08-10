package com.mm.noti.service;

import com.mm.comm.UserInformation;
import com.mm.comm.UserRequest;
import com.mm.comm.UserServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientServiceA {

    @GrpcClient("grpc-server-a")
    private UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    public UserInformation getUserInformation(Long userId) {
        System.out.println("got a hit");
        System.out.println();
        for(int i = 0; i<5_000_000; i++) {
           UserRequest.newBuilder().setUserId(userId).build();
        }
        UserRequest request = UserRequest.newBuilder().setUserId(userId).build();
        return userServiceBlockingStub.getUserInformation(request);
    }

}