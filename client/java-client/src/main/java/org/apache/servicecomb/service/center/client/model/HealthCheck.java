package org.apache.servicecomb.service.center.client.model;

public class HealthCheck {

  private HealthCheckMode mode;

  private int port;

  private int interval;

  private int times;

  public HealthCheckMode getMode() {
    return mode;
  }

  public void setMode(HealthCheckMode mode) {
    this.mode = mode;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public int getInterval() {
    return interval;
  }

  public void setInterval(int interval) {
    this.interval = interval;
  }

  public int getTimes() {
    return times;
  }

  public void setTimes(int times) {
    this.times = times;
  }
}
