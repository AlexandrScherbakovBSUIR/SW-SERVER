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
import java.util.*;
import java.util.List;

@Controller
public class GameController {
    private List<GameStateMessage> gameStateMessage = new ArrayList<>();
    private int playerCounter;
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) throws Exception {

        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }

    @MessageMapping("/game")
    @SendTo("/topic/walker")
    public GameStateMessage send(GameStateMessage message) throws Exception {
        if(message.getPlayerID()==0){
            message.setPlayerID(playerCounter++);
        }
        System.out.println("id= "+message.getPlayerID());
        gameStateMessage.add(message);

        System.out.println(message.toString());
        if(gameStateMessage.size()-1>0)
            message.getPlayGroundWalker().setLocation(gameStateMessage.get(gameStateMessage.size()-1).getPlayGroundWalker().getLocation());
        else
            System.out.println("nothing");
            //message.getPlayGroundWalker().setLocation();
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        System.out.println(message.toString());
        return message;
    }

}
