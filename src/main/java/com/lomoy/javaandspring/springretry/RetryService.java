package com.lomoy.javaandspring.springretry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


@Service
public class RetryService {
    @Autowired
    @Qualifier("template1")
    RetryTemplate retryTemplate;

    int counter =0;

    @Retryable()
    public void doRetry1() throws Exception {
        System.out.println("doRetry fail, retry start ....");
        throw new Exception();
    }

    public void doRetry2() throws Exception {
//        privateInClassRetry1();
        privateInClassRetry2();
    }

    @Retryable()
    private void privateInClassRetry1() throws Exception {
        System.out.println("doRetry fail, retry start ....");
        throw new Exception();
    }

    @Retryable()
    public void privateInClassRetry2() throws Exception {
        System.out.println("doRetry fail, retry start ....");
        throw new Exception();
    }

    @Retryable()
    public void doRetry3() throws Exception {
        System.out.println("doRetry fail, retry start ....");

        try {
            throw new Exception();
        } catch (Exception e) {
            throw new Exception();
        }
    }


    public void doRetry4() throws Exception {
        privateInClassRetry3();
    }

    public void doRetry5() throws Exception {
        privateInClassRetry3();
    }

    public void privateInClassRetry3() throws Exception {
        System.out.println("doRetry fail, retry start ....");

        retryTemplate.execute( context -> {
            verifyNwConfiguration();
            return true;
        });

    }

    public void privateInClassRetry4() throws Exception {
        System.out.println("doRetry fail, retry start ....");

        retryTemplate.execute( context -> {
            verifyNwConfiguration();
            return true;
        });


    }


    private void verifyNwConfiguration() throws Exception {
        counter++;
        System.out.println("N/W configuration Service Failed " + counter);
        throw new Exception();
    }

    public void callMockPost(){
        callPostmanMock();
    }

    private void callPostmanMock(){


        ResponseEntity<String> responseEntity;
        try {
//            responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            responseEntity = retryTemplate.execute(context->callMockServer(context));

        } catch (Exception e) {
            System.out.println("Throw excetpion");
//            throw e;//last
        }
    }

    private ResponseEntity<String> callMockServer(RetryContext context){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://8d07280d-ca4f-4b4f-8859-8a20905c1f52.mock.pstmn.io";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("abcd");
        return restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

    }

}
