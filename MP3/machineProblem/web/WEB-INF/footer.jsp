<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<footer class="pixel-footer">
    <p>DATE &amp; TIME: <%= application.getAttribute("startupDate") != null ? application.getAttribute("startupDate") : "" %></p>
    <p><%= application.getAttribute("mpId") != null ? application.getAttribute("mpId") : "MP3" %></p>

</footer>