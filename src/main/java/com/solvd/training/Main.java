package com.solvd.training;

import com.solvd.training.parsers.JAXBParser;
import com.solvd.training.parsers.JSONParser;
import com.solvd.training.parsers.SAXParser;
import com.solvd.training.validators.XmlValidator;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

import static com.solvd.training.utils.LoggerUtil.log;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        String xsdPath = "src/main/resources/company.xsd";
        String xmlPath = "src/main/resources/company.xml";
        String jsonPath = "src/main/resources/company.json";

        XmlValidator validator = new XmlValidator(xsdPath, xmlPath);

        System.out.println("-------------------------------------------------");
        SAXParser saxParser = new SAXParser(xmlPath);

        System.out.println("-------------------------------------------------");
        JAXBParser jaxbParser = new JAXBParser(xmlPath);
        jaxbParser.parseXML();

        System.out.println("-------------------------------------------------");
        JSONParser jsonParser = new JSONParser(jsonPath);
        jsonParser.parseJSON();

    }
}