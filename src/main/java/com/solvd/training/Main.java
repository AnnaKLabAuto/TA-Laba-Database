package com.solvd.training;

import com.solvd.training.exceptions.DeserializationException;
import com.solvd.training.exceptions.ParsingException;
import com.solvd.training.exceptions.UnmarshallingException;
import com.solvd.training.exceptions.ValidationException;
import com.solvd.training.parsers.JAXBParser;
import com.solvd.training.parsers.JSONParser;
import com.solvd.training.parsers.SAXParser;
import com.solvd.training.validators.XmlValidator;

import static com.solvd.training.utils.LoggerUtil.log;

public class Main {
    public static void main(String[] args) {

        String xsdPath = "src/main/resources/company.xsd";
        String xmlPath = "src/main/resources/company.xml";
        String jsonPath = "src/main/resources/company.json";

        String xsdPathValidate = "company.xsd";
        String xmlPathValidate = "company.xml";

        XmlValidator validator = new XmlValidator(xsdPathValidate, xmlPathValidate);
        try{
            validator.validateXMLSchema();
        } catch (ValidationException e){
            log.error(e);
        }

        System.out.println("-------------------------------------------------");
        System.out.println("SAX parser");
        SAXParser saxParser = new SAXParser(xmlPath);
        try{
            saxParser.parseXmlWithHandler();
        } catch (ParsingException e){
            log.error(e);
        }


        System.out.println("-------------------------------------------------");
        System.out.println("JAXB parser");
        JAXBParser jaxbParser = new JAXBParser(xmlPath);
        try{
            jaxbParser.parseXML();
        } catch (UnmarshallingException e){
            log.error(e);
        }


        System.out.println("-------------------------------------------------");
        System.out.println("JSON parser");
        JSONParser jsonParser = new JSONParser(jsonPath);
        try{
            jsonParser.parseJSON();
        } catch (DeserializationException e){
            log.error(e);
        }


    }
}