package com.carsexample.domain;

public class ApiAccount {

    private String serviceName;

    private String specUrl = "http://localhost:8084";

    private boolean active = true;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getSpecUrl() {
        return specUrl;
    }

    public void setSpecUrl(String specUrl) {
        this.specUrl = specUrl;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
