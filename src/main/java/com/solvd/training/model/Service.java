package com.solvd.training.model;

public class Service {
    private int idService;
    private String serviceName;
    private String serviceDescription;
    private int departmentsId;

    public Service(String serviceName, String serviceDescription, int departmentsId) {
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.departmentsId = departmentsId;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public int getDepartmentsId() {
        return departmentsId;
    }

    public void setDepartmentsId(int departmentsId) {
        this.departmentsId = departmentsId;
    }

    @Override
    public String toString() {
        return "Service{" +
                "idService=" + idService +
                ", serviceName='" + serviceName + '\'' +
                ", serviceDescription='" + serviceDescription + '\'' +
                ", departmentsId=" + departmentsId +
                '}';
    }
}

