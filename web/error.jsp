<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MP3 - Error</title>
</head>
<body>

    <%@ include file="/WEB-INF/header.jsp" %>

    <div class="pixel-card pixel-card-small">
        <h2 class="pixel-title-main">Authentication Failed</h2>
        
        <div class="pixel-error-banner">
            ${requestScope.errorMessage != null ? requestScope.errorMessage : "Invalid username or password provided."}
        </div>
        
        <a href="index.jsp" class="btn-pixel-secondary">
            Try Again
        </a>
    </div>

    <%@ include file="/WEB-INF/footer.jsp" %>

</body>
</html>