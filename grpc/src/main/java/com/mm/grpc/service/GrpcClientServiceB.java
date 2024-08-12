package com.mm.grpc.service;


import com.mm.comm.UserInformation;
import com.mm.comm.UserRequest;
import com.mm.comm.UserServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientServiceB {

    @GrpcClient("grpc-server-b")
    private UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    @Async("taskExecutor")
    public UserInformation getUserInformation(String userId) {
        System.out.println("----------- Service call beigns from here ------------");

        long startTime = System.currentTimeMillis();
        UserInformation userInformation = null;
        for(int i = 0; i<Long.parseLong(userId); i++) {
            UserRequest request = UserRequest.newBuilder().setUserId(Long.parseLong(userId)).build();
            userInformation = userServiceBlockingStub.getUserInformation(request);
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        double totalTimeInSeconds = totalTime / 1000.0;
        double totalTimeInMinutes = totalTimeInSeconds / 60.0;

        System.out.println("Total time taken for count: " + userId + " interservice UserRequest: "
                + totalTime + " ms ("
                + totalTimeInSeconds + " seconds, "
                + totalTimeInMinutes + " minutes)");
            return userInformation;
        }
    }
