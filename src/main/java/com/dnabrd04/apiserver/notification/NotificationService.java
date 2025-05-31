package com.dnabrd04.apiserver.notification;

import com.dnabrd04.apiserver.model.User;
import com.dnabrd04.apiserver.repository.UserRepository;
import com.dnabrd04.apiserver.service.UserService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;


@Service
public class NotificationService {

    @Autowired
    private UserRepository userRepository;

    public void sendFollowNotification(String token, Long followerUserId) {
        User followerUser = userRepository.findById(followerUserId).orElseThrow();
        Message message = Message.builder()
                .setToken(token)
                .setNotification(
                        Notification.builder()
                                .setTitle("¡Tienes un nuevo seguidor!")
                                .setBody(followerUser.getUsername() + " ahora te sigue.")
                                .build()
                )
                .build();

        try{
            String response = FirebaseMessaging.getInstance().sendAsync(message).get();
            System.out.println("Notificación enviada: " + response);
        } catch (Exception e) {
            System.err.println("Error al enviar notificación: " + e.getMessage());
        }
        }
}
