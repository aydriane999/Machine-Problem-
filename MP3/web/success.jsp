<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MP3 - Success</title>
</head>
<body>

    <%@ include file="/WEB-INF/header.jsp" %>

    <div class="pixel-card pixel-card-large">
        <h2 class="pixel-title-main">Character Counter</h2>
        <p class="pixel-subtitle">Enter a string below to analyze its composition.</p>

        <!-- Form submits to CharacterCountingServlet -->
        <form action="CharacterCountingServlet" method="POST">
            <label for="inputString" class="pixel-label">Input String</label>
            <input type="text" id="inputString" name="inputString" class="pixel-input" value="${param.inputString != null ? param.inputString : ''}" placeholder="e.g. Hello World 123!" required />
            
            <button type="submit" class="btn-pixel-primary">
                Analyze String
            </button>
        </form>

        <!-- Results Section -->
        <div class="pixel-results-box">
            <h3 class="pixel-results-title">Analysis Results</h3>
            
            <ul class="pixel-results-list">
                <li><strong>String length:</strong> <span id="resLength">${requestScope.length != null ? requestScope.length : 0}</span></li>
                <li><strong>Number of digits:</strong> <span id="resDigits">${requestScope.digits != null ? requestScope.digits : 0}</span></li>
                <li><strong>Number of vowels:</strong> <span id="resVowels">${requestScope.vowels != null ? requestScope.vowels : 0}</span></li>
                <li><strong>Number of consonants:</strong> <span id="resConsonants">${requestScope.consonants != null ? requestScope.consonants : 0}</span></li>
                <li><strong>Number of symbols:</strong> <span id="resSymbols">${requestScope.symbols != null ? requestScope.symbols : 0}</span></li>
            </ul>
        </div>

        <div style="text-align: center; margin-top: 20px;">
            <a href="index.jsp" class="pixel-link">← Log Out</a>
        </div>
    </div>

    <%@ include file="/WEB-INF/footer.jsp" %>

</body>
</html>
