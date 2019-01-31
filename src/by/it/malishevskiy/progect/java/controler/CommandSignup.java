package by.it.malishevskiy.progect.java.controler;

import javax.servlet.http.HttpServletRequest;

public class CommandSignup implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return "/signup.jsp";
    }
}
