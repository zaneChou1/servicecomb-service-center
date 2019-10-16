package org.apache.servicecomb.service.center.client.model;

public class DataCenterInfo {

  private String name;

  private String region;

  private String availableZone;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getAvailableZone() {
    return availableZone;
  }

  public void setAvailableZone(String availableZone) {
    this.availableZone = availableZone;
  }
}
