package com.igniemie.thud.gameplay;

import com.igniemie.thud.model.GameStatus;
import com.igniemie.thud.model.Player;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Service
public class GameplayService {

    private List<GameplaySession> gameplayList;

    public GameplayService() {
        this.gameplayList = new ArrayList<>();
    }

    public GameplayListDTO gameplayListAsDTO() {
        GameplayListDTO gameplayDTOList = new GameplayListDTO();
        gameplayDTOList.setGameplayDTOList(
                gameplayList.stream()
                    .filter(gameplaySession -> gameplaySession.getStatus().equals(GameStatus.NEW))
                    .map(GameplaySession::toGameplayListEntity)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

        return gameplayDTOList;
    }

    public GameplayDTO createNewGame(String nickname) {
        Player firstPlayer = new Player(nickname);
        GameplaySession gameplaySession = new GameplaySession(firstPlayer);
        GameplayDTO gameplayDTO = gameplaySession.toGameplayDTO();
        gameplayList.add(gameplaySession);
        return gameplayDTO;
    }

    public GameplayDTO addPlayerToGame(String gameUUID, String nickname) {
        for (GameplaySession gameSession: gameplayList) {
            if (gameSession.getGameUUID().equals(UUID.fromString(gameUUID))) {
                gameSession.joinToGame(new Player(nickname));
                return gameSession.toGameplayDTO();
            }
        }
        return null;
    }

/*    public GameplaySession findGameByUUID(String UUID) {

    }*/
}
