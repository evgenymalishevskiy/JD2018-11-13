package by.it.malishevskiy.progect.java.controler;

import javax.servlet.http.HttpServletRequest;

public class CommandError implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return "/error.jsp";
    }
}
