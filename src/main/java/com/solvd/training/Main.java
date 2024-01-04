package com.solvd.training;

import com.solvd.training.parsers.xml.XmlValidator;
import org.xml.sax.SAXException;

import java.io.IOException;

import static com.solvd.training.utils.LoggerUtil.log;

public class Main {
    public static void main(String[] args) throws IOException, SAXException {

        String xsdPath = "resources/xsd-schema.xsd";
        String xmlPath = "resources/xml-hierarchy.xml";

        XmlValidator validator = new XmlValidator(xsdPath, xmlPath);
        boolean isValid = validator.validateXMLSchema(xsdPath, xmlPath);
        if (isValid) {
            log.info("XML document is valid against the schema");
        } log.info("XML document is not valid against the schema");

    }
}