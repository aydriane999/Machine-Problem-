<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Character Counter - Analysis</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

    <jsp:include page="/WEB-INF/header.jsp" />

    <main>
        <div class="pixel-card pixel-card-large">
            <h1 class="pixel-title-main">CHARACTER COUNTER</h1>
            <p class="pixel-subtitle">
                Welcome <%= request.getAttribute("username") != null ? request.getAttribute("username") : "admin" %>! Enter a string below to analyze its composition.
            </p>

            <form action="CharacterCountingServlet" method="post">
                <label class="pixel-label" for="inputString">INPUT STRING:</label>
                <input type="text" id="inputString" name="inputString" class="pixel-input" 
                       value="<%= request.getAttribute("inputString") != null ? request.getAttribute("inputString") : "" %>" 
                       placeholder="Hello World 123!" required>

                <button type="submit" class="btn-pixel-primary" style="margin-top: 16px;">ANALYZE STRING</button>
            </form>

            <div class="pixel-results-box">
                <h3 class="pixel-results-title">ANALYSIS RESULTS</h3>
                <ul class="pixel-results-list">
                    <li><strong>STRING LENGTH:</strong> <%= request.getAttribute("stringLength") != null ? request.getAttribute("stringLength") : 0 %></li>
                    <li><strong>NUMBER OF DIGITS:</strong> <%= request.getAttribute("digitCount") != null ? request.getAttribute("digitCount") : 0 %></li>
                    <li><strong>NUMBER OF VOWELS:</strong> <%= request.getAttribute("vowelCount") != null ? request.getAttribute("vowelCount") : 0 %></li>
                    <li><strong>NUMBER OF CONSONANTS:</strong> <%= request.getAttribute("consonantCount") != null ? request.getAttribute("consonantCount") : 0 %></li>
                    <li><strong>NUMBER OF SYMBOLS:</strong> <%= request.getAttribute("symbolCount") != null ? request.getAttribute("symbolCount") : 0 %></li>
                </ul>
            </div>

            <div style="text-align: center; margin-top: 20px;">
                <a href="index.jsp" class="pixel-link">&larr; LOGOUT</a>
            </div>
        </div>
    </main>

    <jsp:include page="/WEB-INF/footer.jsp" />

</body>
</html>