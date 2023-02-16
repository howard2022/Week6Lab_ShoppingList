package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = request.getParameter("action");

        if (action==null){
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").
                    forward(request, response);
        }else if (request.getParameter("logout") != null) {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").
                    forward(request, response);
            
        }

        
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        session.setAttribute("username", username);
        
        if(action.equals("register")){
        if (username == null && username.isEmpty()){
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").
                    forward(request, response);
            return;
        }else{
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").
                    forward(request, response);
        }
        
        }else if(action.equals("add")){
            String item = request.getParameter("addeditem");
            ArrayList<String> itemList=(ArrayList<String>)session.getAttribute("itemList");
            if (itemList == null) {
            itemList = new ArrayList<>();
            itemList.add(item);
            session.setAttribute("itemList",itemList);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                    .forward(request, response);
            }else if (itemList != null) {
            itemList=(ArrayList<String>)session.getAttribute("itemList");
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                    .forward(request, response);
            }
            
        }else if (action.equals("delete")){
            ArrayList<String> itemList=(ArrayList<String>)session.getAttribute("items");
            if (itemList!=null||!itemList.equals("")){
                String selectedItem = request.getParameter("itemSelected");
                itemList.remove(selectedItem);
                session.setAttribute("items",itemList);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                        .forward(request, response);
            }
        }
        

    }
}
