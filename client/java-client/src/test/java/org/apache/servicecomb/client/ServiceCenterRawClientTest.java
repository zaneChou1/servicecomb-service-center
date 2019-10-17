package org.apache.servicecomb.client;

import java.io.IOException;

import org.apache.servicecomb.service.center.client.ServiceCenterRawClient;
import org.apache.servicecomb.service.center.client.http.HttpResponse;
import org.apache.servicecomb.service.center.client.http.HttpTransport;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *  Created by   on 2019/10/16.
 */
public class ServiceCenterRawClientTest {

  private static final String DEFAULT_HOST = "localhost";

  private static final int DEFAULT_PORT = 30100;

  private static final String DOMAIN_NAME = "default";

  @Test
  public void TestDefaultUrl() throws IOException {

    HttpTransport httpTransport = Mockito.mock(HttpTransport.class);

    ServiceCenterRawClient client = new ServiceCenterRawClient.Builder()
        .setHttpTransport(httpTransport)
        .setHost(DEFAULT_HOST)
        .setPort(DEFAULT_PORT)
        .setDomainName(DOMAIN_NAME)
        .build();

    HttpResponse httpResponse = new HttpResponse();
    httpResponse.setStatusCode(200);
    httpResponse.setContent("ok");

    Mockito.when(httpTransport.get(Mockito.any())).thenReturn(httpResponse);
    Mockito.when(httpTransport.post(Mockito.any())).thenReturn(httpResponse);
    Mockito.when(httpTransport.put(Mockito.any())).thenReturn(httpResponse);
    Mockito.when(httpTransport.delete(Mockito.any())).thenReturn(httpResponse);

    HttpResponse actualGetResponse = client.getHttpRequest(null, null, null);
    HttpResponse actualPostResponse = client.postHttpRequest(null, null, null);
    HttpResponse actualPutResponse = client.putHttpRequest(null, null, null);
    HttpResponse actualDeleteResponse = client.putHttpRequest(null, null, null);

    Assert.assertNotNull(actualGetResponse);
    Assert.assertEquals("ok", actualGetResponse.getContent());
    Assert.assertNotNull(actualPostResponse);
    Assert.assertEquals("ok", actualPostResponse.getContent());
    Assert.assertNotNull(actualPutResponse);
    Assert.assertEquals("ok", actualPutResponse.getContent());
    Assert.assertNotNull(actualDeleteResponse);
    Assert.assertEquals("ok", actualDeleteResponse.getContent());
  }
}
