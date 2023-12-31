<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Text Quest Game</title>
    <style>
        img {
            max-width: 900px;
            max-height: 900px;
        }

        h1 {
            font-size: 20px;
            color: red;
        }

        h2 {
            font-size: 20px;
            color: blue;
        }

        h3 {
            font-size: 18px;
            color: black;
        }

        p {
            font-size: 20px;
            color: blue;
        }

        .section-container {
            border: 2px solid black;
            display: inline-block;
            padding: 10px;
            margin: 10px;
        }

        .section-container1 {
            border: 2px solid black;
            display: inline-block;
            padding: 10px;
            margin: 10px;
        }

        .section-container2 {
            border: 2px solid black;
            display: inline-block;
            padding: 10px;
            margin: 10px;
        }

        .button-container {
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="section-container">
    <h1>
        <% String playerName = (String) request.getSession().getAttribute("playerName");
            if (playerName == null || playerName.isEmpty()) {
                playerName = request.getParameter("playerName");
                if (playerName == null || playerName.trim().isEmpty()) {
                    playerName = "Unknown Player";
                }
                request.getSession().setAttribute("playerName", playerName);
            }
            out.println("Мы рады приветствовать вас, " + playerName + "!");
        %>
    </h1>

    <p><%= request.getAttribute("message") %></p>

    <% Boolean isVictory = (Boolean) request.getAttribute("victory");
        if (isVictory != null && isVictory) { %>
    <img src="images/victory.jpg" alt="Victory Image" style="width: 500px; height: 300px;">
        <% } %>

        <% Boolean isLoss = (Boolean) request.getAttribute("loss");
        if (isLoss != null && isLoss) { %>
            <img src="images/loss.jpg" alt="Loss Image" style="width: 500px; height: 300px;">
    <% } %>

    <form method="POST" action="game">
        <input type="hidden" name="action" value="continue">
        <% String[] options = (String[]) request.getAttribute("options");
            if (options != null) {
                for (String option : options) { %>
        <input type="submit" name="answer" value="<%= option %>">
        <% }
        } %>
    </form>

    <div class="button-container">
        <form action="game" method="POST">
            <input type="hidden" name="actionAgain" value="startAgain">
            <button type="submit">начать игру заново</button>
        </form>
    </div>

</div>

<form action="game" method="GET">
    <div class="section-container2" style="position: absolute; bottom: 10px; right: 10px;">
        <p>Имя игрока: <%= request.getSession().getAttribute("playerName") %>
        </p>
        <p>Количество сыгранных игр: <%= request.getSession().getAttribute("gamesPlayed") %>
        </p>
        <p>
            <%= new java.util.Date()%>
        </p>
    </div>
</form>

<div class="section-container1">
    <img src="images/greeting.jpg" alt="Greeting Image">
</div>

</body>
</html>
