package org.apache.servicecomb.service.center.client.http;

public class HttpTransportFactory {

  private static final HttpTransport httpTransport = new HttpTransportImpl();

  private HttpTransportFactory() {
  }

  public static HttpTransport getDefaultHttpTransport() {
    return httpTransport;
  }
}
