package com.solvd.training;

import com.solvd.training.parsers.SAXParser;
import com.solvd.training.parsers.XmlValidator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static com.solvd.training.utils.LoggerUtil.log;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        String xsdPath = "xsd-schema.xsd";
        String xmlPath = "xml-hierarchy.xml";

        XmlValidator validator = new XmlValidator(xsdPath, xmlPath);
        boolean isValid = XmlValidator.validateXMLSchema(xsdPath, xmlPath);
        if (isValid) {
            log.info("XML document is valid against the schema");
        } else{
            log.info("XML document is not valid against the schema");
        }

        SAXParser saxParser = new SAXParser("src/main/resources/xml-hierarchy.xml");

    }
}