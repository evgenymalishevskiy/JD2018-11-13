package by.it.malishevskiy.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Sax_Parser extends DefaultHandler {
    public static void main(String[] args) {
        try {
            String fileName = "src/by/it/malishevskiy/jd02_07/04+XSD.xml";
            //создадим фабрику и стандартный парсер
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            //создадим собственный вариант SAX-класса
            Sax_Parser myImplementationSax = new Sax_Parser();
            //пуск парсера
            parser.parse(new File(fileName), myImplementationSax);
        } catch (Exception e) {
            System.out.print("Ошибка! " + e.toString());
        }
    }
    //наша реализация методов DefaultHandler
    private String tab = "";
    private String value;
    @Override
    public void startDocument()
            throws SAXException {
        System.out.println("Начало обработки");
    }

    @Override
    public void endDocument()
            throws SAXException {
        System.out.println("Конец обработки");
    }

    @Override //тут печатаем начало тега (и его атрибуты в цикле)
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(tab + "[" + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            System.out.print(" " + name + "=\"" + value+"\"");
        }
        System.out.println("]");
        tab = '\t' + tab; //добавим табулятор
        value = "";
    }

    @Override //печатаем конец тега
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!value.isEmpty())
            System.out.println(tab + value);
        value = "";
        tab = tab.substring(1); //уберем один табулятор
        System.out.println(tab + "[/" + qName + "]");
    }

    @Override //а здесь собираем из кусочков value. Обрывы будут на символах ' " &
    public void characters(char[] ch, int start, int length) throws SAXException {
        value = value.concat(new String(ch, start, length).trim());
    }
}
