<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>

    </title>
    <style>
        img {
            max-width: 700px;
            max-height: 700px;
        }
        h1 {
            font-size: 20px;
            color: blue;
        }
        .section-container {
            border: 2px solid black;
            display: inline-block;
            padding: 10px;
            margin: 10px;
        }
    </style>
</head>
<body>
<div class="section-container">
    <img src="images/name.jpg" alt="Name Image">
    <h1>Представьтесь пожалуйста:</h1>
    <form action="game" method="post">
        <label>
            <input type="text" name="playerName">
        </label>
        <button type="submit">Далее</button>
    </form>
</div>
</body>
</html>



