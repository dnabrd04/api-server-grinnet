package com.dnabrd04.apiserver.controller;

import com.dnabrd04.apiserver.notification.NotificationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;

public class NotificationController extends HttpServlet {

    @Autowired
    private NotificationService notificationService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> payload = mapper.readValue(req.getInputStream(), Map.class);

        String token = payload.get("token");
        String followerUserId = payload.get("followerUserId");

        if (token == null || followerUserId == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Missing required fields");
            return;
        }

        notificationService.sendFollowNotification(token, Long.parseLong(followerUserId));
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("Notificación enviada correctamente");
    }
}
