package org.apache.servicecomb.service.center.client.model;

public class Config {

  private Integer maxHeaderBytes;

  private Integer maxBodyBytes;

  private String readHeaderTimeout;

  private String readTimeout;

  private String idleTimeout;

  private String writeTimeout;

  private String limitTTLUnit;

  private Integer limitConnections;

  private String limitIPLookup;

  private String sslEnabled;

  private String sslMinVersion;

  private String sslVerifyPeer;

  private String sslCiphers;

  private Boolean enablePProf;

  private Boolean enableCache;

  private Boolean selfRegister;

  Config() {
  }

  ;

  public Integer getMaxHeaderBytes() {
    return maxHeaderBytes;
  }

  public void setMaxHeaderBytes(Integer maxHeaderBytes) {
    this.maxHeaderBytes = maxHeaderBytes;
  }

  public Integer getMaxBodyBytes() {
    return maxBodyBytes;
  }

  public void setMaxBodyBytes(Integer maxBodyBytes) {
    this.maxBodyBytes = maxBodyBytes;
  }

  public String getReadHeaderTimeout() {
    return readHeaderTimeout;
  }

  public void setReadHeaderTimeout(String readHeaderTimeout) {
    this.readHeaderTimeout = readHeaderTimeout;
  }

  public String getReadTimeout() {
    return readTimeout;
  }

  public void setReadTimeout(String readTimeout) {
    this.readTimeout = readTimeout;
  }

  public String getIdleTimeout() {
    return idleTimeout;
  }

  public void setIdleTimeout(String idleTimeout) {
    this.idleTimeout = idleTimeout;
  }

  public String getWriteTimeout() {
    return writeTimeout;
  }

  public void setWriteTimeout(String writeTimeout) {
    this.writeTimeout = writeTimeout;
  }

  public String getLimitTTLUnit() {
    return limitTTLUnit;
  }

  public void setLimitTTLUnit(String limitTTLUnit) {
    this.limitTTLUnit = limitTTLUnit;
  }

  public Integer getLimitConnections() {
    return limitConnections;
  }

  public void setLimitConnections(Integer limitConnections) {
    this.limitConnections = limitConnections;
  }

  public String getLimitIPLookup() {
    return limitIPLookup;
  }

  public void setLimitIPLookup(String limitIPLookup) {
    this.limitIPLookup = limitIPLookup;
  }

  public String getSslEnabled() {
    return sslEnabled;
  }

  public void setSslEnabled(String sslEnabled) {
    this.sslEnabled = sslEnabled;
  }

  public String getSslMinVersion() {
    return sslMinVersion;
  }

  public void setSslMinVersion(String sslMinVersion) {
    this.sslMinVersion = sslMinVersion;
  }

  public String getSslVerifyPeer() {
    return sslVerifyPeer;
  }

  public void setSslVerifyPeer(String sslVerifyPeer) {
    this.sslVerifyPeer = sslVerifyPeer;
  }

  public String getSslCiphers() {
    return sslCiphers;
  }

  public void setSslCiphers(String sslCiphers) {
    this.sslCiphers = sslCiphers;
  }

  public Boolean getEnablePProf() {
    return enablePProf;
  }

  public void setEnablePProf(Boolean enablePProf) {
    this.enablePProf = enablePProf;
  }

  public Boolean getEnableCache() {
    return enableCache;
  }

  public void setEnableCache(Boolean enableCache) {
    this.enableCache = enableCache;
  }

  public Boolean getSelfRegister() {
    return selfRegister;
  }

  public void setSelfRegister(Boolean selfRegister) {
    this.selfRegister = selfRegister;
  }
}
