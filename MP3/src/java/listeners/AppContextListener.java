package listeners;

import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener that initializes the startup Date object
 * and shared header/footer attributes in the ServletContext.
 *
 * @author jeym.
 */
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        // Instantiate a java.util.Date object representing application startup date and time
        Date startupDate = new Date();
        context.setAttribute("startupDate", startupDate);

        // Store shared header and footer information in ServletContext
        context.setAttribute("headerText", "ICS2608 / 2CSA / LOZANO - RENDON");
        context.setAttribute("mpIdentifier", "MP3");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.removeAttribute("startupDate");
        context.removeAttribute("headerText");
        context.removeAttribute("mpIdentifier");
    }
}
