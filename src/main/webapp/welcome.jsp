<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>
        Пролог
    </title>
    <style>
        img {
            max-width: 900px;
            max-height: 900px;
        }
        h1 {
            font-size: 20px;
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
            font-size: 14px; /* Размер текста */
            line-height: 0.5; /* Межстрочный интервал */
        }
    </style>
</head>
<body>
<div class="section-container">
    <h1>Пролог</h1>
    <img src="images/space-port.jpg" alt="Welcome Image">
    <p>Ты стоишь в космическом порту и готов подняться на борт своего корабля. Разве ты не об этом мечтал?</p>
    <p>Стать капитаном галактического судна и управлять им вместе со своим экипажем.</p>
    <p>Но перед этим, тебе нужно пройти небольшой квест, чтобы твой экипаж мог довериться своему капитану.</p>
    <p>Так что вперед, мой друг! Желаю тебе удачи в прохождении квеста!</p>
    <form action="game" method="POST">
        <input type="hidden" name="action" value="startGame">
        <button type="submit">Начать игру</button>
    </form>
</div>
</body>
</html>
