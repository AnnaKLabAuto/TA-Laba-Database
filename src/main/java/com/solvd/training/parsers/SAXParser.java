package com.solvd.training.parsers;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import com.solvd.training.exceptions.ParsingException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;

import static com.solvd.training.utils.LoggerUtil.log;

public class SAXParser {

    private final String xmlPath;
    private SAXParserFactory factory = SAXParserFactory.newInstance();
    private javax.xml.parsers.SAXParser parser;

    public SAXParser(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public void parseXmlWithHandler() throws ParsingException {
        try {
            parser = factory.newSAXParser();
            parser.parse(xmlPath, handler);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            log.error("Error during XML parsing: ", e);
            throw new ParsingException("Error during XML parsing", e);
        }
    }

    DefaultHandler handler = new DefaultHandler() {
        boolean inClient = false;
        boolean inDepartment = false;
        boolean inEmployee = false;
        boolean inProject = false;
        boolean inTask = false;

        String clientId;
        String departmentId;
        String employeeId;
        String projectId;
        String taskId;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            switch (qName) {
                case "client":
                    inClient = true;
                    clientId = attributes.getValue("idClient");
                    log.info("Client ID: " + clientId);
                    break;

                case "department":
                    inDepartment = true;
                    departmentId = attributes.getValue("idDepartment");
                    log.info("Department ID: " + departmentId);
                    break;

                case "employee":
                    inEmployee = true;
                    employeeId = attributes.getValue("idEmployee");
                    log.info("Employee ID: " + employeeId);
                    break;

                case "project":
                    inProject = true;
                    projectId = attributes.getValue("idProject");
                    log.info("Project ID: " + projectId);
                    break;

                case "task":
                    inTask = true;
                    taskId = attributes.getValue("idTask");
                    log.info("Task ID: " + taskId);
                    break;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length){
            if (inClient || inDepartment || inEmployee || inProject || inTask) {
                String text = new String(ch, start, length).trim();
                if (!text.isEmpty()) {
                    if (inClient) {
                        log.info("Client: " + text);
                    } else if (inDepartment) {
                        log.info("Department: " + text);
                    } else if (inEmployee) {
                        log.info("Employee: " + text);
                    } else if (inProject) {
                        log.info("Project: " + text);
                    } else if (inTask) {
                        log.info("Task: " + text);
                    }
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName){
            switch (qName) {
                case "client":
                    inClient = false;
                    break;

                case "department":
                    inDepartment = false;
                    break;

                case "employee":
                    inEmployee = false;
                    break;

                case "project":
                    inProject = false;
                    break;

                case "task":
                    inTask = false;
                    break;
            }
        }
    };
}

