package servlet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @InjectMocks
    GameTextQuestServlet gameTextQuestServlet;

    @Test
    void doGet() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("welcome.jsp")).thenReturn(dispatcher);

        gameTextQuestServlet.doGet(request, response);

        verify(request).getSession();
        verify(request).getRequestDispatcher("welcome.jsp");
        verify(dispatcher).forward(request, response);

    }

    @Test
    void doPost() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("action")).thenReturn("startGame");

        gameTextQuestServlet.doPost(request, response);

        verify(request).getParameter("action");
        verify(response).sendRedirect("enterName.jsp");

    }
}