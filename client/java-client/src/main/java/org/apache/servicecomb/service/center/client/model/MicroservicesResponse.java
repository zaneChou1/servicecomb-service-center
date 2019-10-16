package org.apache.servicecomb.service.center.client.model;

import java.util.List;

public class MicroservicesResponse {

  private List<Microservice> services;

  public List<Microservice> getServices() {
    return services;
  }

  public void setServices(List<Microservice> services) {
    this.services = services;
  }
}
