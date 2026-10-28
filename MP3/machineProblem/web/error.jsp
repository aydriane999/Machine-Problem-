<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Error</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

    <jsp:include page="/WEB-INF/header.jsp" />

    <main>
        <div class="pixel-card pixel-card-small">
            <h1 class="pixel-title-main" style="color: #dc2626;">LOGIN FAILED</h1>
            
            <div class="pixel-error-banner">
                <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "An unexpected login error occurred." %>
            </div>

            <a href="index.jsp" class="btn-pixel-secondary">TRY AGAIN</a>
        </div>
    </main>

    <jsp:include page="/WEB-INF/footer.jsp" />

</body>
</html>