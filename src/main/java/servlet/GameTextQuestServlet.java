package servlet;

import model.GameTextQuestResult;
import service.GameTextQuestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GameTextQuestServlet", urlPatterns = "/game")
public class GameTextQuestServlet extends HttpServlet {

    private GameTextQuestService gameTextQuestService = new GameTextQuestService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        if ("startGame".equals(action)) {
            response.sendRedirect("enterName.jsp");
            return;
        }

        String playerName = (String) request.getSession().getAttribute("playerName");

        if (playerName == null || playerName.isEmpty()) {
            return;
        }

        String answer = request.getParameter("answer");
        GameTextQuestResult gameResult = gameTextQuestService.processPlayerAction(answer);
        request.setAttribute("message", gameResult.getMessage());
        request.setAttribute("options", gameResult.getOptions());
        request.setAttribute("showImage", gameResult.showImage());
        request.setAttribute("showImage1", gameResult.showImage1());

        if (!gameResult.finished()) {
            request.getRequestDispatcher("playGame.jsp").forward(request, response);
        }
    }
}
