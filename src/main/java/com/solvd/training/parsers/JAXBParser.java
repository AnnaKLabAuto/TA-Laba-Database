package com.solvd.training.parsers;

import com.solvd.training.model.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static com.solvd.training.utils.LoggerUtil.log;

public class JAXBParser {

    private String xmlPath;

    public JAXBParser(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public void parseXML() {
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            Company company = (Company) unmarshaller.unmarshal(new File(xmlPath));
            printCompanyData(company);

        } catch (JAXBException e){
            log.error(e);
        }
    }

    private void printCompanyData(Company company){
        for (Client client : company.getClients()) {
            System.out.println("Client: " + client);
        }

        for (Department department : company.getDepartments()) {
            System.out.println("Department: " + department);
        }

        for (Employee employee : company.getEmployees()) {
            System.out.println("Employee: " + employee);
        }

        for (Project project : company.getProjects()) {
            System.out.println("Project: " + project);
        }

        for (Task task : company.getTasks()) {
            System.out.println("Task: " + task);
        }
    }

}
