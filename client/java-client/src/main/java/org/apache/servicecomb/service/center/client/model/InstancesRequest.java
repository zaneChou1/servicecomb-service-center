package org.apache.servicecomb.service.center.client.model;

public class InstancesRequest {
  private String serviceId;

  private String instanceId;

  public InstancesRequest(String serviceId, String instanceId) {
    this.serviceId = serviceId;
    this.instanceId = instanceId;
  }

  public String getServiceId() {
    return serviceId;
  }

  public void setServiceId(String serviceId) {
    this.serviceId = serviceId;
  }

  public String getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }
}
