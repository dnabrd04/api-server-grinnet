package com.dnabrd04.apiserver.controller;

import com.dnabrd04.apiserver.notification.NotificationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/sendFollowNotification")
public class NotificationController extends HttpServlet {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<String> sendNotification(@RequestBody Map<String, String> payload) {
        String targetUserId = payload.get("token");
        String followerUserId = payload.get("followerUserId");

        if (targetUserId == null || followerUserId == null) {
            return ResponseEntity.badRequest().body("Missing required fields");
        }

        notificationService.sendFollowNotification(targetUserId, Long.parseLong(followerUserId));
        return ResponseEntity.ok("Notificación enviada correctamente");
    }
}
