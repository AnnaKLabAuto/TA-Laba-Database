package com.solvd.training.parsers;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;

public class SAXParser {

    private SAXParserFactory factory = SAXParserFactory.newInstance();
    private javax.xml.parsers.SAXParser parser = factory.newSAXParser();
    private final String xmlPath;

    public SAXParser(String xmlPath) throws ParserConfigurationException, SAXException, IOException {
        this.xmlPath = xmlPath;
        parser.parse(xmlPath, handler);
    }

    DefaultHandler handler = new DefaultHandler() {
        boolean inClient = false;
        String clientId;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("client")) {
                inClient = true;
                clientId = attributes.getValue("idClient");
                System.out.println("Client ID: " + clientId);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (inClient) {
                String text = new String(ch, start, length).trim();
                if (!text.isEmpty()) {
                    System.out.println("Text: " + text);
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("client")) {
                inClient = false;
            }
        }
    };
}

