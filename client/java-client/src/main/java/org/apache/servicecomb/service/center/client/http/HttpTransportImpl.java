package org.apache.servicecomb.service.center.client.http;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *  Created by   on 2019/10/16.
 */
public class HttpTransportImpl implements HttpTransport {

  private static final String HEADER_CONTENT_TYPE = "Content-Type";

  private static final String HEADER_USER_AGENT = "User-Agent";

  private static final String HEADER_TENANT_NAME = "x-domain-name";

  public HttpTransportImpl() {

  }

  @Override
  public HttpResponse get(HttpRequest request) throws IOException {

    HttpGet httpGet = new HttpGet(request.getUrl());

    return doRequest(httpGet);
  }

  @Override
  public HttpResponse post(HttpRequest request) throws IOException {

    HttpPost httpPost = new HttpPost(request.getUrl());

    if (request.getContent() != null) {
      httpPost.setEntity(new StringEntity(request.getContent(), "UTF-8"));
    }
    return doRequest(httpPost);
  }

  @Override
  public HttpResponse put(HttpRequest request) throws IOException {

    HttpPut httpPut = new HttpPut(request.getUrl());

    if (request.getContent() != null) {
      httpPut.setEntity(new StringEntity(request.getContent(), "UTF-8"));
    }
    return doRequest(httpPut);
  }

  @Override
  public HttpResponse delete(HttpRequest request) throws IOException {
    HttpDelete httpDelete = new HttpDelete(request.getUrl());
    return doRequest(httpDelete);
  }


  private HttpResponse doRequest(HttpUriRequest httpRequest) throws IOException {
    //add header
    httpRequest.addHeader(HEADER_CONTENT_TYPE, "application/json");
    httpRequest.addHeader(HEADER_USER_AGENT, "cse-serviceregistry-client/1.0.0");
    httpRequest.addHeader(HEADER_TENANT_NAME, "default");

    //get Http response
    CloseableHttpClient httpClient = HttpClients.createDefault();
    CloseableHttpResponse response = httpClient.execute(httpRequest);

    int statusCode = response.getStatusLine().getStatusCode();
    String messgae = response.getStatusLine().getReasonPhrase();
    String context = EntityUtils.toString(response.getEntity(), "UTF-8");

    return new HttpResponse(statusCode, messgae, context);
  }
}