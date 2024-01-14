package com.solvd.training.parsers;

import com.solvd.training.exceptions.UnmarshallingException;
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

    public void parseXML() throws UnmarshallingException {
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            Company company = (Company) unmarshaller.unmarshal(new File(xmlPath));
            if (company != null) {
                printCompanyDetails(company);
            } else {
                log.error("Unmarshalling resulted in a null Company object");
                throw new UnmarshallingException("Unmarshalling resulted in a null Company object");
            }
        } catch (JAXBException | UnmarshallingException e){
            log.error("Error during JAXB unmarshalling: ", e);
            throw new UnmarshallingException("Error during JAXB unmarshalling", e);
        }
    }

    private void printCompanyDetails(Company company) {
        for (Client client : company.getClients()) {
            log.info(client);
        }
        for (Department department : company.getDepartments()) {
            log.info(department);
        }
        for (Employee employee : company.getEmployees()) {
            log.info(employee);
        }
        for (Project project : company.getProjects()) {
            log.info(project);
        }
        for (Task task : company.getTasks()) {
            log.info(task);
        }
    }
}
