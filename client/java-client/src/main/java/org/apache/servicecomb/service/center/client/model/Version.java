package org.apache.servicecomb.service.center.client.model;

public class Version {

  private String version;

  private String apiVersion;

  private String buildTag;

  private String goVersion;

  private String os;

  private String arch;

  private Config config;

  Version() {

  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getApiVersion() {
    return apiVersion;
  }

  public void setApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
  }

  public String getBuildTag() {
    return buildTag;
  }

  public void setBuildTag(String buildTag) {
    this.buildTag = buildTag;
  }

  public String getGoVersion() {
    return goVersion;
  }

  public void setGoVersion(String goVersion) {
    this.goVersion = goVersion;
  }

  public String getOs() {
    return os;
  }

  public void setOs(String os) {
    this.os = os;
  }

  public String getArch() {
    return arch;
  }

  public void setArch(String arch) {
    this.arch = arch;
  }

  public Config getConfig() {
    return config;
  }

  public void setConfig(Config config) {
    this.config = config;
  }
}