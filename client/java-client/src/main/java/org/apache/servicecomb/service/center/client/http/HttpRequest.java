package org.apache.servicecomb.service.center.client.http;

import java.util.Map;

public class HttpRequest {

  private String url;

  private Map<String, String> headers;

  private String content;

  public HttpRequest(String url, Map<String, String> headers, String content) {
    this.url = url;
    this.headers = headers;
    this.content = content;
  }

  public String getUrl() {
    return url;
  }

  public Map<String, String> getHeaders() {
    return headers;
  }

  public String getContent() {
    return content;
  }
}
