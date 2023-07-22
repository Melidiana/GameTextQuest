package servlet;

import model.GameTextQuestResult;
import service.GameTextQuestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "GameTextQuestServlet", urlPatterns = "/game")
public class GameTextQuestServlet extends HttpServlet {
    private GameTextQuestService gameTextQuestService = new GameTextQuestService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String playerName = request.getParameter("playerName");
        String currentName = (String) session.getAttribute("playerName");
        Integer gamesPlayed = (Integer) session.getAttribute("gamesPlayed");

        if (playerName != null && !playerName.equals(currentName)) {
            session.setAttribute("playerName", playerName);
            currentName = playerName;
            gamesPlayed = 0;
        }

        if (gamesPlayed == null) {
            gamesPlayed = 0;
        }

        gamesPlayed++;
        session.setAttribute("gamesPlayed", gamesPlayed);

        request.setAttribute("playerName", currentName);
        request.setAttribute("gamesPlayed", gamesPlayed);

        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        String action = request.getParameter("action");

        if ("startGame".equals(action)) {
            response.sendRedirect("enterName.jsp");
            return;
        }
        handlePlayerName(request);

        String actionAgain = request.getParameter("actionAgain");

        if ("startAgain".equals(actionAgain)) {
            Integer gamesPlayed = (Integer) session.getAttribute("gamesPlayed");
            if (gamesPlayed != null) {
                gamesPlayed++;
            } else {
                gamesPlayed = 1;
            }
            session.setAttribute("gamesPlayed", gamesPlayed);
            request.getRequestDispatcher("enterName.jsp").forward(request, response);
            return;
        }

        String playerName = (String) request.getSession().getAttribute("playerName");

        if (playerName == null || playerName.isEmpty()) {
            request.getSession().setAttribute("playerName", playerName);
        }

        String answer = request.getParameter("answer");
        GameTextQuestResult gameResult = gameTextQuestService.processPlayerAction(answer);
        request.setAttribute("message", gameResult.getMessage());
        request.setAttribute("options", gameResult.getOptions());
        request.setAttribute("victory", gameResult.isVictory());
        request.setAttribute("loss", gameResult.isLoss());

        if (!gameResult.isFinish()) {
            request.getRequestDispatcher("playGame.jsp").forward(request, response);
        }
    }

    private void handlePlayerName(HttpServletRequest request) {
        String playerName = request.getParameter("playerName");
        HttpSession session = request.getSession();

        if (playerName != null && !playerName.isEmpty()) {
            session.setAttribute("playerName", playerName);

            Integer gamesPlayed = (Integer) session.getAttribute("gamesPlayed");
            if (gamesPlayed == null || !playerName.equals(session.getAttribute("currentName"))) {
                session.setAttribute("gamesPlayed", 0);
                session.setAttribute("currentName", playerName);
            }
        } else {
            playerName = (String) session.getAttribute("playerName");
        }
    }
}
