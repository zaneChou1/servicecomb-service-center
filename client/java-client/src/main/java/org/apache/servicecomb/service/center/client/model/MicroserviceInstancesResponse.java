package org.apache.servicecomb.service.center.client.model;

import java.util.List;

public class MicroserviceInstancesResponse {

  private List<MicroserviceInstance> instances;

  public List<MicroserviceInstance> getInstances() {
    return instances;
  }

  public void setInstances(List<MicroserviceInstance> instances) {
    this.instances = instances;
  }
}
