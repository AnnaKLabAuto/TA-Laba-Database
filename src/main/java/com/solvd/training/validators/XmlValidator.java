package com.solvd.training.validators;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.net.URL;

import static com.solvd.training.utils.LoggerUtil.log;

public class XmlValidator {

    private final String xsdPath;
    private final String xmlPath;

    public XmlValidator(String xsdPath, String xmlPath) {
        this.xsdPath = xsdPath;
        this.xmlPath = xmlPath;
    }

    public void validateXMLSchema(String xsdPath, String xmlPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            URL xsdUrl = XmlValidator.class.getClassLoader().getResource(xsdPath);
            URL xmlUrl = XmlValidator.class.getClassLoader().getResource(xmlPath);
            if (xsdUrl == null || xmlUrl == null) {
                throw new IllegalArgumentException("Url is null");
            }

            Source xsdSource = new StreamSource(xsdUrl.openStream());
            Schema schema = factory.newSchema(xsdSource);

            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlUrl.openStream()));
            log.info("XML document is valid against the schema");
        } catch (SAXException | IOException e) {
            log.error("XML document is not valid against the schema", e);
        }
    }
}
