package edu.easysoft.swserver.controller;

import edu.easysoft.swserver.domain.GameStateMessage;
import edu.easysoft.swserver.domain.Message;
import edu.easysoft.swserver.domain.OutputGameStateMessage;
import edu.easysoft.swserver.domain.OutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class GameController {
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) throws Exception {

        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }

    @MessageMapping("/game")
    @SendTo("/topic/walker")
    public GameStateMessage send(GameStateMessage message) throws Exception {

        System.out.println(message.toString());
        message.getPlayGroundWalker().setLocation(new Point(130,92));
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        System.out.println(message.toString());
        return message;
    }

}
