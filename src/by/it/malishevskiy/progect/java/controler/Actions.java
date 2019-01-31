package by.it.malishevskiy.progect.java.controler;

enum  Actions {

    LOGIN {
        {
            this.command = new CommandLogin();

        }
    }, LOGOUT {
        {
            this.command = new CommandLogout();

        }
    }, SIGNUP {
        {
            this.command = new CommandSignup();
        }
    },
    ERROR {
        {
            this.command = new CommandError();

        }
    };


    public String jsp = "/error.jsp";
    public ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}