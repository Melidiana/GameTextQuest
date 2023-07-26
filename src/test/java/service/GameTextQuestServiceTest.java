package service;

import model.GameTextQuestResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTextQuestServiceTest {

    private GameTextQuestService gameService;

    @BeforeEach
    void init() {
        gameService = new GameTextQuestService();
    }
    @Test
    public void testProcessPlayerActionWithNullAction() {
        GameTextQuestResult result = gameService.processPlayerAction(null);

        assertNotNull(result);
        assertEquals("Добро пожаловать на наш корабль! Ты на пороге каюты капитана. Зайдешь в каюту?", result.getMessage());
        assertArrayEquals(new String[]{"зайти в каюту", "уйти с корабля"}, result.getOptions());
    }

    @Test
    public void testProcessPlayerActionEnterCaptainCabin() {
        GameTextQuestResult result = gameService.processPlayerAction("зайти в каюту");

        assertNotNull(result);
        assertEquals("Ты в каюте капитана и видишь на столе две книги. Какую из них ты возьмешь с собой?", result.getMessage());
        assertArrayEquals(new String[]{"книга о навигации", "книга с рассказами"}, result.getOptions());
    }

    @Test
    public void testPlayerLeavingShip() {
        GameTextQuestResult result = gameService.processPlayerAction("уйти с корабля");

        assertNotNull(result);
        assertEquals("К сожалению ты струсил, капитан должен быть смелее. Поражение.", result.getMessage());
        assertArrayEquals(new String[]{}, result.getOptions());
        assertTrue(result.isLoss());
    }

    @Test
    public void testProcessPlayerActionUnknownAction() {
        GameTextQuestService gameService = new GameTextQuestService();
        GameTextQuestResult result = gameService.processPlayerAction("неправильный выбор");

        assertNotNull(result);
        assertEquals("Ошибка: Неправильный выбор.", result.getMessage());
        assertArrayEquals(new String[]{}, result.getOptions());
    }
}
