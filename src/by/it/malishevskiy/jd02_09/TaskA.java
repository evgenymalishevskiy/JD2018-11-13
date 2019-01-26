package by.it.malishevskiy.jd02_09;

import by.it.malishevskiy.jd02_09.beans.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {
    private static String filename = System.getProperty("user.dir") +
            "/src/by/it/malishevskiy/jd02_09/04+XSD.xml";

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Users.class);
            System.out.println("=========================== FROM XML ==============================");
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Users users = (Users) unmarshaller.unmarshal(new File(filename));
            System.out.println(users);

            Marshaller marshaller = context.createMarshaller();
            System.out.println("=========================== TO XML ==============================");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(users, System.out);

            System.out.println("=========================== TO JSON ==============================");
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
            String jsonText = gson.toJson(users);
            System.out.println(jsonText);

            System.out.println("=========================== FROM JSON ==============================");
            Users personsFromJson = gson.fromJson(jsonText, Users.class);
            System.out.println(personsFromJson);
            if (personsFromJson.toString().equals(users.toString()))
                System.out.println("Check OK");

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
