package listeners;

import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sc){
        ServletContext context=sc.getServletContext();

        Date startupDate=new Date();
        context.setAttribute("startupDate",startupDate);
        context.setAttribute("appHeader","ICS2608 / 2CSA / LOZANO - RENDON");
        context.setAttribute("mpId","MP3");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sc) {
        ServletContext context=sc.getServletContext();
        context.removeAttribute("startupDate");
        context.removeAttribute("appHeader");
        context.removeAttribute("mpId");
    }
}