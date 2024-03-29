package com.igniemie.thud.gameplay;

import com.igniemie.thud.model.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameplayDTO {

    private String uuid;
    private String status;
    private Player firstPlayer;
    private Player secondPlayer;
}
