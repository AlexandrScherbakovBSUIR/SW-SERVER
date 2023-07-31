package edu.easysoft.swserver.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class GameStateMessage {
    @JsonProperty("playerID")
    private int playerID;
    @JsonProperty("playGroundWalker")
    private PlayGroundWalker playGroundWalker;


}
