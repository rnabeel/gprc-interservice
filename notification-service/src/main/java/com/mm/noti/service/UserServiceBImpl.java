package com.mm.noti.service;

import com.mm.comm.UserInformation;
import com.mm.comm.UserRequest;
import com.mm.comm.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserServiceBImpl extends UserServiceGrpc.UserServiceImplBase{
        @Override
        public void getUserInformation(UserRequest request, StreamObserver<UserInformation> responseObserver) {
            System.out.println("server b got a hit");
            UserInformation userInformation = UserInformation.newBuilder()
                    .setUserId(request.getUserId())
                    .setName("Name from B")
                    .setEmail("emailB@example.com")
                    .build();
            responseObserver.onNext(userInformation);
            responseObserver.onCompleted();
        }
}
