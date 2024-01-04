package com.solvd.training.parsers.xml;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import static com.solvd.training.utils.LoggerUtil.log;

public class XmlValidator {

    private final String xsdPath;
    private final String xmlPath;

    public XmlValidator(String xsdPath, String xmlPath) {
        this.xsdPath = xsdPath;
        this.xmlPath = xmlPath;
    }

    public static boolean validateXMLSchema(String xsdPath, String xmlPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            URL xsdUrl = new URL(xsdPath);
            if (xsdUrl == null) {
                throw new IllegalArgumentException("xsdUrl is null");
            }

            File xsdFile = new File(xsdUrl.toURI());
            Source xsdSource = new StreamSource(xsdFile);
            Schema schema = factory.newSchema(xsdSource);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
            return true;
        } catch (SAXException | IOException | URISyntaxException e) {
            return false;
        }
    }

}
