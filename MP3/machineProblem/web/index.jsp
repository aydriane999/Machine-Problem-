<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - Character Counter</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

    <jsp:include page="/WEB-INF/header.jsp" />

    <main>
        <div class="pixel-card pixel-card-small">
            <h1 class="pixel-title-main">LOGIN</h1>
            
            <form action="LoginServlet" method="post">
                <label class="pixel-label" for="username">USERNAME:</label>
                <input type="text" id="username" name="username" class="pixel-input" placeholder="Enter username">

                <label class="pixel-label" for="password">PASSWORD:</label>
                <input type="password" id="password" name="password" class="pixel-input" placeholder="Enter password">

                <button type="submit" class="btn-pixel-primary">LOGIN</button>
            </form>
        </div>
    </main>

    <jsp:include page="/WEB-INF/footer.jsp" />

</body>
</html>