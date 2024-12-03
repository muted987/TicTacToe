package main.java.game;

import main.java.gameMap.GameMap;
import main.java.gameMap.GameMapRender;
import main.java.objects.Bot;
import main.java.objects.Player;

public class Game {
    private static final GameMapRender render = new GameMapRender();
    private static final int PLAYER_VS_BOT_GAME_MODE_CODE = 1;
    private static final int BOT_VS_BOT_GAME_MODE_CODE = 2;

    public void game() {
        GameMap map = new GameMap();
        int gameMode = GameStart.start();
        if (gameMode == PLAYER_VS_BOT_GAME_MODE_CODE) {
            playerVsBotGame(map);
        } else if (gameMode == BOT_VS_BOT_GAME_MODE_CODE) {
            botVsBotGame(map);
        }
    }
    private void botVsBotGame(GameMap map) {
        Bot bot = new Bot();
        boolean turnOrder = true; // X - начинает первым
        while (true) {
            render.render(map, null);
            if (turnOrder) {
                System.out.println("╳ turn");
            } else {
                System.out.println("о turn");
            }
            System.out.println("1. Make move");
            Input.botVsBotInputOption();
            bot.makeMove(map, turnOrder);
            if (isGameOver(map)) break;
            turnOrder =! turnOrder;
        }
    }

    public void playerVsBotGame(GameMap map) {
        Bot bot = new Bot();
        Player player = new Player();
        boolean turnOrder = true; // X - начинает первым
        while (true) {
            render.render(map, null);
            if (turnOrder) {
                System.out.println("╳ turn");
                player.makeMove(map, turnOrder);
            } else {
                System.out.println("о turn");
                bot.makeMove(map, turnOrder);
            }
            if (isGameOver(map)) break;
            turnOrder =! turnOrder;
        }
    }
    public boolean isGameOver(GameMap map) {
        Winner winner = WinCheck.winChecker(map);
        if (winner.isWin()) {
            render.render(map, winner.getWinPositions());
            System.out.println("GAME OVER");
            String winnerSymbol = winner.getWinnerSymbol().getSymbolCaption();
            System.out.printf("%s is winner", winnerSymbol);
            return true;
        }
        if (map.isNoFreeSpace()) {
            render.render(map, null);
            System.out.println("TIE");
            return true;
        }
        return false;
    }
}
