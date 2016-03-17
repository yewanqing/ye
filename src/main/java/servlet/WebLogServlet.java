package servlet;


import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author GAOShan @HF
 * @version 1.0
 * @since 2014/12/31 9:37
 */


@WebServlet(urlPatterns = {"/WebLogServlet"}, asyncSupported = true)
public class WebLogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        res.setHeader("Cache-Control", "private");
        res.setHeader("Pragma", "no-cache");
        req.setCharacterEncoding("UTF-8");
        PrintWriter writer = res.getWriter();
        // for IE
        writer.println("<!-- Comet is a programming technique that enables web servers to send data to the client without having any need for the client to request it. -->\n");
        writer.flush();

        final AsyncContext ac = req.startAsync();
        ac.setTimeout(10 * 60 * 1000);
//        ac.addListener(new AsyncListener() {
////            public void onComplete(AsyncEvent event) throws IOException {
////                WebLogAppender.ASYNC_CONTEXT_QUEUE.remove(ac);
////            }
////
////            public void onTimeout(AsyncEvent event) throws IOException {
////                WebLogAppender.ASYNC_CONTEXT_QUEUE.remove(ac);
////            }
////
////            public void onError(AsyncEvent event) throws IOException {
////                WebLogAppender.ASYNC_CONTEXT_QUEUE.remove(ac);
////            }
////
////            public void onStartAsync(AsyncEvent event) throws IOException {
////            }
////        });
////        WebLogAppender.ASYNC_CONTEXT_QUEUE.add(ac);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doGet(req,res);
    }

    public void  init(){
        System.out.println("1111111111111111");
    }
}
