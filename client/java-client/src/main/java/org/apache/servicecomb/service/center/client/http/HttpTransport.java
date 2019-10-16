package org.apache.servicecomb.service.center.client.http;

import java.io.IOException;

/**
 *  Created by   on 2019/10/16.
 */
public interface HttpTransport {

  HttpResponse get(HttpRequest request) throws IOException;

  HttpResponse post(HttpRequest request) throws IOException;

  HttpResponse put(HttpRequest request) throws IOException;

  HttpResponse delete(HttpRequest request) throws IOException;
}
