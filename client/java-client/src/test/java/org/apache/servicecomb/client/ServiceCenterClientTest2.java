package org.apache.servicecomb.client;

import java.awt.SystemTray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.stream.MemoryCacheImageInputStream;

import org.apache.servicecomb.service.center.client.ServiceCenterClient;
import org.apache.servicecomb.service.center.client.ServiceCenterRawClient;
import org.apache.servicecomb.service.center.client.http.HttpRequest;
import org.apache.servicecomb.service.center.client.http.HttpResponse;
import org.apache.servicecomb.service.center.client.http.HttpTransport;
import org.apache.servicecomb.service.center.client.http.HttpTransportFactory;
import org.apache.servicecomb.service.center.client.model.HeartbeatsRequest;
import org.apache.servicecomb.service.center.client.model.InstancesRequest;
import org.apache.servicecomb.service.center.client.model.Microservice;
import org.apache.servicecomb.service.center.client.model.MicroserviceInstance;
import org.apache.servicecomb.service.center.client.model.MicroserviceInstancesResponse;
import org.apache.servicecomb.service.center.client.model.MicroservicesResponse;
import org.apache.servicecomb.service.center.client.model.Version;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class ServiceCenterClientTest2 {

  @Test
  public void TestGetServiceCenterVersion() throws IOException {
    //give
    ServiceCenterRawClient serviceCenterRawClient = Mockito.mock(ServiceCenterRawClient.class);

    HttpResponse httpResponse = new HttpResponse();
    httpResponse.setStatusCode(200);
    httpResponse.setMessage("ok");
    String responseContent = "{\n"
        + "  \"version\": \"1.1.0\",\n"
        + "  \"apiVersion\": \"go1.11\",\n"
        + "  \"buildTag\": \"string\",\n"
        + "  \"goVersion\": \"string\",\n"
        + "  \"os\": \"string\",\n"
        + "  \"arch\": \"string\",\n"
        + "  \"config\": {\n"
        + "    \"maxHeaderBytes\": 0,\n"
        + "    \"maxBodyBytes\": 0,\n"
        + "    \"readHeaderTimeout\": \"string\",\n"
        + "    \"readTimeout\": \"string\",\n"
        + "    \"idleTimeout\": \"string\",\n"
        + "    \"writeTimeout\": \"string\",\n"
        + "    \"limitTTLUnit\": \"string\",\n"
        + "    \"limitConnections\": 0,\n"
        + "    \"limitIPLookup\": \"string\",\n"
        + "    \"sslEnabled\": \"string\",\n"
        + "    \"sslMinVersion\": \"string\",\n"
        + "    \"sslVerifyPeer\": \"string\",\n"
        + "    \"sslCiphers\": \"string\",\n"
        + "    \"enablePProf\": true,\n"
        + "    \"enableCache\": true,\n"
        + "    \"selfRegister\": true\n"
        + "  }\n"
        + "}";

    httpResponse.setContent(responseContent);

    Mockito.when(serviceCenterRawClient.getHttpRequest("/registry/version",null,null)).thenReturn(httpResponse);

    ServiceCenterClient serviceCenterClient = new ServiceCenterClient(serviceCenterRawClient);
    Version actualResponse = serviceCenterClient.getServiceCenterVersion();
    System.out.println(actualResponse);

    Assert.assertNotNull(actualResponse);
    Assert.assertEquals("1.1.0",actualResponse.getVersion());
  }

  @Test
  public void TestGetServiceCenterInstances() throws IOException {
    //give
    ServiceCenterRawClient serviceCenterRawClient = Mockito.mock(ServiceCenterRawClient.class);

    HttpResponse httpResponse = new HttpResponse();
    httpResponse.setStatusCode(200);
    httpResponse.setMessage("ok");
    String responseString = "{\n"
        + "  \"instances\": [\n"
        + "    {\n"
        + "      \"instanceId\": \"111111\",\n"
        + "      \"serviceId\": \"222222\",\n"
        + "      \"version\": \"1.0\",\n"
        + "      \"hostName\": \"Test\",\n"
        + "      \"endpoints\": [\n"
        + "        \"string\"\n"
        + "      ],\n"
        + "      \"status\": \"UP\",\n"
        + "      \"properties\": {\n"
        + "        \"additionalProp1\": \"string\",\n"
        + "        \"additionalProp2\": \"string\",\n"
        + "        \"additionalProp3\": \"string\"\n"
        + "      },\n"
        + "      \"healthCheck\": {\n"
        + "        \"mode\": \"push\",\n"
        + "        \"port\": \"0\",\n"
        + "        \"interval\": \"0\",\n"
        + "        \"times\": \"0\"\n"
        + "      },\n"
        + "      \"dataCenterInfo\": {\n"
        + "        \"name\": \"string\",\n"
        + "        \"region\": \"string\",\n"
        + "        \"availableZone\": \"string\"\n"
        + "      },\n"
        + "      \"timestamp\": \"333333\",\n"
        + "      \"modTimestamp\": \"4444444\"\n"
        + "    }\n"
        + "  ]\n"
        + "}";

    httpResponse.setContent(responseString);

    // when
    Mockito.when(serviceCenterRawClient.getHttpRequest("/registry/health",null,null)).thenReturn(httpResponse);

    //and
    ServiceCenterClient serviceCenterClient = new ServiceCenterClient(serviceCenterRawClient);
    MicroserviceInstancesResponse serviceCenterInstances = serviceCenterClient.getServiceCenterInstances();

    //then
    Assert.assertNotNull(serviceCenterInstances);
    Assert.assertEquals(1,serviceCenterInstances.getInstances().size());
    Assert.assertEquals("111111",serviceCenterInstances.getInstances().get(0).getInstanceId());
    Assert.assertEquals("222222",serviceCenterInstances.getInstances().get(0).getServiceId());
  }

  @Test
  public void TestRegistryService() throws IOException {
    //give
    ServiceCenterRawClient serviceCenterRawClient = Mockito.mock(ServiceCenterRawClient.class);

    HttpResponse httpResponse = new HttpResponse();
    httpResponse.setStatusCode(200);
    httpResponse.setMessage("ok");
    httpResponse.setContent("{\"serviceId\": \"111111\"}");

    Microservice microservice = new Microservice();
    microservice.setServiceName("Test");
    microservice.setServiceId("111111");
    JSONObject body = new JSONObject();
    body.put("service",microservice);

    // when
    Mockito.when(serviceCenterRawClient.postHttpRequest("/registry/microservices",null,body.toString(SerializerFeature.WriteMapNullValue)))
        .thenReturn(httpResponse);

    //and
    ServiceCenterClient serviceCenterClient = new ServiceCenterClient(serviceCenterRawClient);
    String actualResponse = serviceCenterClient.resgisterMicroservice(microservice);

    //then
    Assert.assertNotNull(actualResponse);
    Assert.assertEquals("{\"serviceId\": \"111111\"}",actualResponse);
  }

  @Test
  public void TestGetServiceMessage() throws IOException {
    //give
    ServiceCenterRawClient serviceCenterRawClient = Mockito.mock(ServiceCenterRawClient.class);

    HttpResponse httpResponse = new HttpResponse();
    httpResponse.setStatusCode(200);
    httpResponse.setMessage("ok");
    String responseString = "{\n"
        + "  \"service\": {\n"
        + "      \"serviceId\": \"111111\",\n"
        + "      \"environment\": \"string\",\n"
        + "      \"appId\": \"string\",\n"
        + "      \"serviceName\": \"string\",\n"
        + "      \"version\": \"string\",\n"
        + "      \"description\": \"string\",\n"
        + "      \"level\": \"string\",\n"
        + "      \"registerBy\": \"string\",\n"
        + "      \"schemas\": [\n"
        + "        \"string\"\n"
        + "      ],\n"
        + "      \"status\": \"UP\",\n"
        + "      \"timestamp\": \"string\",\n"
        + "      \"modTimestamp\": \"string\",\n"
        + "      \"framework\": {\n"
        + "        \"name\": \"string\",\n"
        + "        \"version\": \"string\"\n"
        + "      },\n"
        + "      \"paths\": [\n"
        + "        {\n"
        + "          \"Path\": \"string\",\n"
        + "          \"Property\": {\n"
        + "            \"additionalProp1\": \"string\",\n"
        + "            \"additionalProp2\": \"string\",\n"
        + "            \"additionalProp3\": \"string\"\n"
        + "          }\n"
        + "        }\n"
        + "      ],\n"
        + "      \"properties\": {\n"
        + "        \"additionalProp1\": \"string\",\n"
        + "        \"additionalProp2\": \"string\",\n"
        + "        \"additionalProp3\": \"string\"\n"
        + "      }\n"
        + "    }\n"
        + "}";

    httpResponse.setContent(responseString);

    // when
    Mockito.when(serviceCenterRawClient.getHttpRequest("/registry/microservices/111111",null,null)).thenReturn(httpResponse);

    //and
    ServiceCenterClient serviceCenterClient = new ServiceCenterClient(serviceCenterRawClient);
    Microservice microservices = serviceCenterClient.getMicroserviceByServiceId("111111");

    //then
    Assert.assertNotNull(microservices);
    Assert.assertEquals("111111",microservices.getServiceId());
  }

  @Test
  public void TestGetServices() throws IOException {
    ServiceCenterRawClient serviceCenterRawClient = Mockito.mock(ServiceCenterRawClient.class);

    HttpResponse httpResponse = new HttpResponse();
    httpResponse.setStatusCode(200);
    httpResponse.setMessage("ok");

    MicroservicesResponse microservicesResponse = new MicroservicesResponse();
    List<Microservice> microserviceList = new ArrayList<Microservice>();
    microserviceList.add(new Microservice("Test1"));
    microserviceList.add(new Microservice("Test2"));
    microserviceList.add(new Microservice("Test3"));
    microservicesResponse.setServices(microserviceList);
    httpResponse.setContent(JSONObject.toJSONString(microservicesResponse));

    Mockito.when(serviceCenterRawClient.getHttpRequest(Mockito.any(),Mockito.any(),Mockito.any())).thenReturn(httpResponse);

    ServiceCenterClient serviceCenterClient = new ServiceCenterClient(serviceCenterRawClient);
    MicroservicesResponse actualMicroservicesResponse = serviceCenterClient.getMicroservices();

    Assert.assertNotNull(actualMicroservicesResponse);
    Assert.assertEquals(3,actualMicroservicesResponse.getServices().size());
    Assert.assertEquals("Test1",actualMicroservicesResponse.getServices().get(0).getServiceName());
  }

  @Test
  public void TestRegistryServiceInstance() throws IOException {
    //give
    ServiceCenterRawClient serviceCenterRawClient = Mockito.mock(ServiceCenterRawClient.class);

    HttpResponse httpResponse = new HttpResponse();
    httpResponse.setStatusCode(200);
    httpResponse.setMessage("ok");
    httpResponse.setContent("{\"instanceId\": \"111111\"}");

    MicroserviceInstance instance = new MicroserviceInstance();
    instance.setInstanceId("111111");
    instance.setServiceId("222222");
    JSONObject body = new JSONObject();
    body.put("instance",instance);

    // when
    Mockito.when(serviceCenterRawClient.postHttpRequest("/registry/microservices/222222/instances",null,body.toString(SerializerFeature.WriteMapNullValue)))
        .thenReturn(httpResponse);

    //and
    ServiceCenterClient serviceCenterClient = new ServiceCenterClient(serviceCenterRawClient);
    String actualResponse = serviceCenterClient.resgisterMicroserviceInstances(instance,"222222");

    //then
    Assert.assertNotNull(actualResponse);
    Assert.assertEquals("{\"instanceId\": \"111111\"}",actualResponse);

  }

  @Test
  public void TestFindServiceInstance() throws IOException {
    //give
    ServiceCenterRawClient serviceCenterRawClient = Mockito.mock(ServiceCenterRawClient.class);

    HttpResponse httpResponse = new HttpResponse();
    httpResponse.setStatusCode(200);
    httpResponse.setMessage("ok");
    String responseString = "{\n"
        + "  \"instances\": [\n"
        + "    {\n"
        + "      \"instanceId\": \"111111\",\n"
        + "      \"serviceId\": \"222222\",\n"
        + "      \"version\": \"1.0\",\n"
        + "      \"hostName\": \"Test\",\n"
        + "      \"endpoints\": [\n"
        + "        \"string\"\n"
        + "      ],\n"
        + "      \"status\": \"UP\",\n"
        + "      \"timestamp\": \"333333\",\n"
        + "      \"modTimestamp\": \"4444444\"\n"
        + "    }\n"
        + "  ]\n"
        + "}";

    httpResponse.setContent(responseString);

    // when
    Mockito.when(serviceCenterRawClient.getHttpRequest("/registry/microservices/222222/instances",null,null)).thenReturn(httpResponse);

    //and
    ServiceCenterClient serviceCenterClient = new ServiceCenterClient(serviceCenterRawClient);
    MicroserviceInstancesResponse serviceCenterInstances = serviceCenterClient.getMicroserviceInstancesByServiceId("222222");

    //then
    Assert.assertNotNull(serviceCenterInstances);
    Assert.assertEquals(1,serviceCenterInstances.getInstances().size());
    Assert.assertEquals("111111",serviceCenterInstances.getInstances().get(0).getInstanceId());
    Assert.assertEquals("222222",serviceCenterInstances.getInstances().get(0).getServiceId());
  }

  @Test
  public void TestSendHeartBeats() throws IOException {
    ServiceCenterRawClient serviceCenterRawClient = Mockito.mock(ServiceCenterRawClient.class);

    HttpResponse httpResponse = new HttpResponse();
    httpResponse.setStatusCode(200);
    httpResponse.setMessage("ok");
    httpResponse.setContent("Send OK");

    HeartbeatsRequest heartbeatsRequest = new HeartbeatsRequest("001","1001");
    heartbeatsRequest.addInstances(new InstancesRequest("002","1002"));
    JSONObject body = new JSONObject();
    body.put("Instances", heartbeatsRequest);

    Mockito.when(serviceCenterRawClient.putHttpRequest("/registry/microservices/111/instances/222/heartbeat",null,null)).thenReturn(httpResponse);
    Mockito.when(serviceCenterRawClient.putHttpRequest("/registry/heartbeats",null,body.toString(SerializerFeature.WriteMapNullValue))).thenReturn(httpResponse);

    ServiceCenterClient serviceCenterClient = new ServiceCenterClient(serviceCenterRawClient);
    String actualResponse = serviceCenterClient.sendHeartBeatsByServiceIdAndInstanceId("111","222");
    String actualResponses = serviceCenterClient.sendHeartBeats(heartbeatsRequest);

    Assert.assertNotNull(actualResponse);
    Assert.assertNotNull(actualResponses);
    Assert.assertEquals("Send OK",actualResponse);
    Assert.assertEquals("Send OK",actualResponses);
  }

  @Test
  public void TestUpdateServicesInstanceStatus() throws IOException {
    ServiceCenterRawClient serviceCenterRawClient = Mockito.mock(ServiceCenterRawClient.class);

    HttpResponse httpResponse = new HttpResponse();
    httpResponse.setStatusCode(200);
    httpResponse.setMessage("ok");
    httpResponse.setContent("Update OK");

    Mockito.when(serviceCenterRawClient.putHttpRequest(Mockito.any(),Mockito.any(),Mockito.any())).thenReturn(httpResponse);


    ServiceCenterClient serviceCenterClient = new ServiceCenterClient(serviceCenterRawClient);
    String actualResponse = serviceCenterClient.updateMicroservicesInstanceStatus("111","222","UP");

    Assert.assertNotNull(actualResponse);
    Assert.assertEquals("Update OK",actualResponse);
  }

}
