package com.mm.grpc.service;


import com.mm.comm.UserInformation;
import com.mm.comm.UserRequest;
import com.mm.comm.UserServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientServiceB {

    @GrpcClient("grpc-server-b")
    private UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    public UserInformation getUserInformation(String userId) {
        UserRequest request = UserRequest.newBuilder().setUserId(Long.parseLong(userId)).build();
        return userServiceBlockingStub.getUserInformation(request);
    }
}
