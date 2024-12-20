package main.java.game;

public class GameRender {
    private static final String PLAYER_VS_BOT_GAME_MOD_CAPTION = "Player vs. Bot";
    private static final String GAME_MODE_SETTINGS_CAPTION = "Choose game mode\n1. Player vs. Bot\n2. Bot vs. Bot\n3. Back";
    private static final String GAME_MAIN_MENU_CAPTION = "1. Start new game (game mode: %s)\n2. Change game mode\n3. Exit\n";
    private static final String GAME_EXIT_MESSAGE = "Shut down the game. Good luck!";
    private static final String BOT_VS_BOT_GAME_MOD_CAPTION = "Bot vs. Bot";
    private static String gameMode = PLAYER_VS_BOT_GAME_MOD_CAPTION;
    private static final int PLAYER_VS_BOT_GAME_MODE_OPTION = 1;
    private static final int BOT_VS_BOT_GAME_MODE_OPTION = 2;
    private static int gameModeCode = 1;
    private static final int START_GAME_OPTION = 1;
    private static final int GAME_MODE_OPTION = 2;

    public static int start() {
        while (true) {
            System.out.printf(GAME_MAIN_MENU_CAPTION, gameMode);
            int mainMenuOptionInput = Input.gameStartInputOption();
            if (mainMenuOptionInput == START_GAME_OPTION) {
                return gameModeCode;
            } else if (mainMenuOptionInput == GAME_MODE_OPTION) {
                System.out.println(GAME_MODE_SETTINGS_CAPTION);
                final int gameModeSettingsInput = Input.gameStartInputOption();
                if (gameModeSettingsInput == BOT_VS_BOT_GAME_MODE_OPTION) {
                    gameMode = BOT_VS_BOT_GAME_MOD_CAPTION;
                    gameModeCode = BOT_VS_BOT_GAME_MODE_OPTION;
                } else if (gameModeSettingsInput == PLAYER_VS_BOT_GAME_MODE_OPTION) {
                    gameMode = PLAYER_VS_BOT_GAME_MOD_CAPTION;
                    gameModeCode = PLAYER_VS_BOT_GAME_MODE_OPTION;
                }
            } else {
                System.out.println(GAME_EXIT_MESSAGE);
                return -400;
            }
        }
    }
}