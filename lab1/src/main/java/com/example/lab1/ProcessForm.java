package com.example.lab1;

import javafx.scene.control.Tab;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "processForm", value = "/process-form")
public class ProcessForm extends HttpServlet{
    private String confirmationMessage;

    public void init() {
        confirmationMessage = "Mock is true. Message returned";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String mock = request.getParameter("mock");
        if(Objects.equals(mock, "true")) {
            response.setContentType("text/html");

            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + confirmationMessage + "</h1>");
            out.println("</body></html>");
        } else {
            String sync = request.getParameter("sync");
            String key = request.getParameter("key");
            String value = request.getParameter("value");
            long time = System.currentTimeMillis();

            if(Objects.equals(sync, "false")) {
                ProcessForm.writeFileAsync(key, value, time);
            } else {
                ProcessForm.writeFileSync(key, value, time);
            }

            ArrayList<String> fileData = ProcessForm.getFileData();
            fileData.sort(String::compareToIgnoreCase);

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();
            out.println("<html><body>");

            for(String s : fileData) {
                out.println("<p>" + s + "</p>");
            }
            out.println("</body></html>");

            StringBuilder statistics = new StringBuilder("Method: " + request.getMethod() + " Ip: " + request.getRemoteAddr() + " User-Agent: " +
                    request.getHeader("User-Agent") + " User Language: " + request.getLocale() + " Params: ");

            Enumeration<String> parameterNames = request.getParameterNames();

            while (parameterNames.hasMoreElements()) {

                String paramName = parameterNames.nextElement();
                statistics.append(paramName);
                statistics.append(" :");

                String[] paramValues = request.getParameterValues(paramName);
                for (int i = 0; i < paramValues.length; i++) {
                    String paramValue = paramValues[i];
                    statistics.append(paramValue);
                    statistics.append(" ");
                }
            }

            log(statistics.toString());
        }
    }

    public synchronized static void writeFileSync(String key, String length, long time) throws IOException {
        try {
            Files.write(Paths.get("/Users/developer/documents/java-technologies/lab1/repository.txt"), System.getProperty("line.separator").getBytes(), StandardOpenOption.APPEND);
            for(int i = 0; i < Integer.parseInt(length); i++) {
                Files.write(Paths.get("/Users/developer/documents/java-technologies/lab1/repository.txt"), (key + time).getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFileAsync(String key, String length, long time) throws IOException {
        try {
            Files.write(Paths.get("/Users/developer/documents/java-technologies/lab1/repository.txt"), System.getProperty("line.separator").getBytes(), StandardOpenOption.APPEND);
            for(int i = 0; i < Integer.parseInt(length); i++) {
                Files.write(Paths.get("/Users/developer/documents/java-technologies/lab1/repository.txt"), (key + time).getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getFileData() {
        ArrayList<String> result = new ArrayList<>();
        String filename = "/Users/developer/documents/java-technologies/lab1/repository.txt";

        try (Scanner s = new Scanner(new FileReader(filename))) {
            while (s.hasNext()) {
                result.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void destroy() {
    }
}
