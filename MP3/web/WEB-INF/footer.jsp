<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="background-color: #f8fafc; border-top: 4px solid #000000; padding: 15px; text-align: center; color: #475569; font-size: 9px;">
    <p style="margin: 4px 0;">
        Date and Time: 
        <strong id="live-datetime" style="color: #0f172a;">
            ${applicationScope.startupDate}
        </strong>
    </p>
    <p style="margin: 4px 0;">
        <strong style="color: #0f172a;">${applicationScope.mpIdentifier != null ? applicationScope.mpIdentifier : "MP3"}</strong>
    </p>
</div>
