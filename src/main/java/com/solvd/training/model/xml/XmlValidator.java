package com.solvd.training.model.xml;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {

    private final String xsdPath;
    private final String xmlPath;

    public XmlValidator(String xsdPath, String xmlPath) {
        this.xsdPath = xsdPath;
        this.xmlPath = xmlPath;
    }

    private Validator initValidator(String xsdPath) throws SAXException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(getFile(xsdPath));
        Schema schema = factory.newSchema(schemaFile);
        return schema.newValidator();
    }

    private File getFile(String location) {
        return new File(getClass().getClassLoader().getResource(location).getFile());
    }

    public boolean isValid() throws IOException, SAXException {
        Validator validator = initValidator(xsdPath);
        try {
            validator.validate(new StreamSource(getFile(xmlPath)));
            return true;
        } catch (SAXException e) {
            return false;
        }
    }
}
