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
        boolean inDepartment = false;
        boolean inEmployee = false;
        boolean inProject = false;
        boolean inTask = false;

        String clientId;
        String departmentName;
        String employeeName;
        String projectId;
        String taskName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            switch (qName) {
                case "client":
                    inClient = true;
                    clientId = attributes.getValue("idClient");
                    System.out.println("Client ID: " + clientId);
                    break;

                case "department":
                    inDepartment = true;
                    departmentName = attributes.getValue("name");
                    System.out.println("Department Name: " + departmentName);
                    break;

                case "employee":
                    inEmployee = true;
                    employeeName = attributes.getValue("firstName") + " " + attributes.getValue("lastName");
                    System.out.println("Employee Name: " + employeeName);
                    break;

                case "project":
                    inProject = true;
                    projectId = attributes.getValue("idProject");
                    System.out.println("Project ID: " + projectId);
                    break;

                case "task":
                    inTask = true;
                    taskName = attributes.getValue("name");
                    System.out.println("Task Name: " + taskName);
                    break;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (inClient || inDepartment || inEmployee || inProject || inTask) {
                String text = new String(ch, start, length).trim();
                if (!text.isEmpty()) {
                    if (inClient) {
                        System.out.println("Client Name: " + text);
                    } else if (inDepartment) {
                        System.out.println("Department Description: " + text);
                    } else if (inEmployee) {
                        System.out.println("Employee Title: " + text);
                    } else if (inProject) {
                        System.out.println("Project Description: " + text);
                    } else if (inTask) {
                        System.out.println("Task Description: " + text);
                    }
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
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

