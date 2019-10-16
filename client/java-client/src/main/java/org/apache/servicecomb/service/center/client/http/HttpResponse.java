package org.apache.servicecomb.service.center.client.http;

public class HttpResponse {

  private int statusCode;

  private String message;

  private String content;

  public HttpResponse() {

  }

  HttpResponse(int statusCode, String message, String content) {
    this.statusCode = statusCode;
    this.content = content;
    this.message = message;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
