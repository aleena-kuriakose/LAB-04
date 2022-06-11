
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;


/**
 * 
 * 
 * @author Aleena
 */

public class NoteServlet extends HttpServlet {

  
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String webFolder = "/WEB-INF/";
        final String textFile = getServletContext().getRealPath(webFolder + "note.txt");
        
        BufferedReader text = new BufferedReader(new FileReader(new File(textFile)));
        
        String title = text.readLine();
        String content = text.readLine();
        text.close();
        
        Note note = new Note(title, content);
        request.setAttribute("Thenote", note);
        String editButton = request.getParameter("edit");
        
        if (editButton == null) {
            getServletContext().getRequestDispatcher(webFolder + "viewnote.jsp").forward(request, response);
            return;
            
        } else {
            getServletContext().getRequestDispatcher(webFolder + "editnote.jsp").forward(request, response);
            return;
        }
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String editTitle = request.getParameter("edit_title");
        String editContent = request.getParameter("edit_note");
        String notePath = "/WEB-INF/note.txt";
        String noteFile = getServletContext().getRealPath(notePath);
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(noteFile, false)));
        writer.println(editTitle);
        writer.println(editContent);
        writer.close();
        
        
        Note editNote = new Note(editTitle, editContent);
        request.setAttribute("Thenote", editNote);
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        return;
       
    }

   
    

}
