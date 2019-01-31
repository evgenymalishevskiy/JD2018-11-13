package by.it.malishevskiy.progect.java.controler;

import javax.servlet.http.HttpServletRequest;

public class CommandLogout implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return "/logout.jsp";
    }
}
