package edu.easysoft.swserver.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public class GameStateMessage {
    @JsonProperty("playGroundWalker")
    private PlayGroundWalker playGroundWalker;


}
