package servlet;

import model.GameTextQuestResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.GameTextQuestService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameTextQuestServletTest {

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    RequestDispatcher dispatcher;

    @Mock
    HttpSession session;

    @Mock
    GameTextQuestService gameTextQuestService;

    @InjectMocks
    GameTextQuestServlet gameTextQuestServlet;

    @Test
    @DisplayName("Test")
    void doGet() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("welcome.jsp")).thenReturn(dispatcher);

        gameTextQuestServlet.doGet(request, response);

        verify(request).getSession();
        verify(request).getRequestDispatcher("welcome.jsp");
        verify(dispatcher).forward(request, response);

    }

    @Test
    @DisplayName("Test that enterName.jsp has been redirected one time")
    public void testEnterNameJspRedirect() throws Exception {
        when(request.getParameter("action")).thenReturn("startGame");

        gameTextQuestServlet.doPost(request, response);

        verify(response, times(1)).sendRedirect("enterName.jsp");
    }

    @Test
    @DisplayName("Test that dispatcher works correctly")
    public void testDoPostStartAgain() throws Exception {
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        when(request.getParameter("action")).thenReturn(null);
        when(request.getParameter("playerName")).thenReturn("Diana");
        when(request.getParameter("actionAgain")).thenReturn("startAgain");

        gameTextQuestServlet.doPost(request, response);

        verify(dispatcher).forward(request, response);
    }

    @Test
    @DisplayName("Test")
    public void testDoPostPlayGame() throws Exception {
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        when(request.getParameter("action")).thenReturn("playGame");
        when(session.getAttribute("playerName")).thenReturn("Diana");
        when(request.getParameter("playerName")).thenReturn("Diana");
        when(session.getAttribute("gamesPlayed")).thenReturn(1);
        when(session.getAttribute("currentName")).thenReturn("Diana");
        when(request.getParameter("actionAgain")).thenReturn(null);
        when(request.getParameter("answer")).thenReturn("answer");

        GameTextQuestResult result = new GameTextQuestResult();
        result.setMessage("Your action was successful.");
        when(gameTextQuestService.processPlayerAction(anyString())).thenReturn(result);

        gameTextQuestServlet.doPost(request, response);

        verify(request).setAttribute("message", result.getMessage());
        verify(request).setAttribute("options", result.getOptions());
        verify(request).setAttribute("victory", result.isVictory());
        verify(request).setAttribute("loss", result.isLoss());
        verify(dispatcher).forward(request, response);
    }
}