package com.networknt.oauth.service.handler;

import com.networknt.client.Client;
import com.networknt.exception.ApiException;
import com.networknt.exception.ClientException;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
* Generated by swagger-codegen
*/
public class Oauth2ServicePostHandlerTest {
    @ClassRule
    public static TestServer server = TestServer.getInstance();

    static final Logger logger = LoggerFactory.getLogger(Oauth2ServicePostHandlerTest.class);

    @Test
    public void testOauth2ServicePostHandler() throws ClientException, ApiException, UnsupportedEncodingException {
        String service = "{\"serviceId\":\"AACT0003\",\"serviceType\":\"ms\",\"serviceName\":\"Retail Account\",\"serviceDesc\":\"Microservices for Retail Account\",\"scope\":\"act.r act.w\",\"ownerId\":\"admin\"}";

        CloseableHttpClient client = Client.getInstance().getSyncClient();
        HttpPost httpPost = new HttpPost("http://localhost:6883/oauth2/service");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setEntity(new StringEntity(service));
        try {
            CloseableHttpResponse response = client.execute(httpPost);
            //logger.debug("StatusCode = " + response.getStatusLine().getStatusCode());
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
            //logger.debug("Response body = " + IOUtils.toString(response.getEntity().getContent(), "utf8"));
            Assert.assertNotNull(IOUtils.toString(response.getEntity().getContent(), "utf8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
