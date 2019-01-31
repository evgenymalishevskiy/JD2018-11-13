package by.it.malishevskiy.progect.java.controler;

import javax.servlet.http.HttpServletRequest;

interface ActionCommand {
    String execute(HttpServletRequest request);

}
