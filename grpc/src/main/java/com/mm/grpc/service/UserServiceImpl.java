package com.mm.grpc.service;

import com.mm.comm.model.User;
import com.mm.comm.UserInformation;
import com.mm.comm.UserRequest;
import com.mm.comm.UserServiceGrpc;
import com.mm.grpc.repository.UserRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserServiceImpl  extends UserServiceGrpc.UserServiceImplBase {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void getUserInformation(UserRequest request, StreamObserver<UserInformation> responseObserver) {
        System.out.println("-------------------- Just Got a hit on Service A ------------------");
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new RuntimeException("may day"));
        UserInformation userInformation = UserInformation.newBuilder()
                        .setUserId(user.getId())
                                .setName(user.getName())
                                        .setEmail(user.getEmail())
                .build();
        responseObserver.onNext(userInformation);
        responseObserver.onCompleted();
    }
}
