<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="background-color: #f8fafc; border-top: 4px solid #000000; padding: 15px; text-align: center; color: #475569; font-size: 9px;">
    <p style="margin: 4px 0;">
        Date and Time: 
        <strong id="live-datetime" style="color: #0f172a;">
            ${applicationScope.startupDate != null ? applicationScope.startupDate : "Loading..."}
        </strong>
    </p>
    <p style="margin: 4px 0;">
        <strong style="color: #0f172a;">${applicationScope.mpIdentifier != null ? applicationScope.mpIdentifier : "MP3"}</strong>
    </p>
</div>

<script>
    function updateDateTime(){
        var now = new Date();
        
        var month = String(now.getMonth()+1).padStart(2,'0');
        var day = String(now.getDate()).padStart(2,'0');
        var year = now.getFullYear();
        
        var hours = now.getHours();
        var minutes = String(now.getMinutes()).padStart(2,'0');
        var seconds = String(now.getSeconds()).padStart(2,'0');
        var ampm = hours >= 12 ? 'PM' : 'AM';
        
        hours = hours % 12;
        hours = hours ? hours : 12;
        var formattedHours = String(hours).padStart(2,'0');
        
        var formattedString = month + '/' + day + '/' + year + ' ' + formattedHours + ':' + minutes + ':' + seconds + ' ' + ampm;
        
        var element = document.getElementById('live-datetime');
        if (element){
            element.textContent = formattedString;
        }
    }

    updateDateTime();
    setInterval(updateDateTime, 1000);
</script>
