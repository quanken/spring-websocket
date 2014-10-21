package com.quanken.controller

import com.quanken.model.Chat
import org.apache.log4j.Logger
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
public class ChatController {
    private Logger logger = Logger.getLogger(ChatController.class);
    @MessageMapping("/chat")
    @SendTo("/chat/chatroom")
    public Chat chatWithOthers(Chat chat) {
        logger.info("chat ==> " + chat)
        return chat;
    }

}