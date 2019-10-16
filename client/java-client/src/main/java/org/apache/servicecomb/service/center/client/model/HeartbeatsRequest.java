package org.apache.servicecomb.service.center.client.model;

import java.util.ArrayList;
import java.util.List;

public class HeartbeatsRequest {
  private List<InstancesRequest> Instances;

  public HeartbeatsRequest(String serviceId, String instanceId) {
    List<InstancesRequest> instances = new ArrayList<InstancesRequest>();
    instances.add(new InstancesRequest(serviceId, instanceId));
    this.Instances = instances;
  }

  public List<InstancesRequest> getInstances() {
    return Instances;
  }

  public void setInstances(List<InstancesRequest> instances) {
    this.Instances = instances;
  }

  public void addInstances(InstancesRequest instancesRequest) {
    if (this.Instances != null) {
      this.Instances.add(instancesRequest);
    } else {
      this.Instances = new ArrayList<InstancesRequest>();
      this.Instances.add(instancesRequest);
    }
  }
}
