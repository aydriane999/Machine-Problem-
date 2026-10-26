<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MP3 - Login</title>
</head>
<body>

    <%@ include file="/WEB-INF/header.jsp" %>

    <div class="pixel-card pixel-card-small">
        <h2 class="pixel-title-main">Login</h2>
        
        <form action="LoginServlet" method="POST">
            <label for="username" class="pixel-label">Username</label>
            <input type="text" id="username" name="username" class="pixel-input" placeholder="Enter username" />
            
            <label for="password" class="pixel-label">Password</label>
            <input type="password" id="password" name="password" class="pixel-input" placeholder="Enter password" />
            
            <button type="submit" class="btn-pixel-primary">
                Sign In
            </button>
        </form>
    </div>

    <%@ include file="/WEB-INF/footer.jsp" %>

</body>
</html>