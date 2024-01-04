package com.solvd.training;

import com.solvd.training.parsers.xml.XmlValidator;
import static com.solvd.training.utils.LoggerUtil.log;

public class Main {
    public static void main(String[] args){

        String xsdPath = "xsd-schema.xsd";
        String xmlPath = "xml-hierarchy.xml";

        XmlValidator validator = new XmlValidator(xsdPath, xmlPath);
        boolean isValid = XmlValidator.validateXMLSchema(xsdPath, xmlPath);
        if (isValid) {
            log.info("XML document is valid against the schema");
        } else{
            log.info("XML document is not valid against the schema");
        }

    }
}