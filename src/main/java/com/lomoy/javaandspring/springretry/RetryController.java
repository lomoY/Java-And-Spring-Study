package com.lomoy.javaandspring.springretry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetryController {

    @Autowired
    RetryService retryService;



    /**
     * case 1: New instance will not do retry, should use @Autowired
     *
     */
    @PostMapping(path = "retry1")
    public void retryEndPoint1() throws Exception {
//        RetryService retryService = new RetryService();
        retryService.doRetry1();
    }

    /**
     * case 2:
     */
    @PostMapping(path = "retry2")
    public void retryEndPoint2() throws Exception {
//        RetryService retryService = new RetryService();
        retryService.doRetry2();
    }

    /**
     * case 3: have try catch in the block
     */
    @PostMapping(path = "retry3")
    public void retryEndPoint3() throws Exception {
//        RetryService retryService = new RetryService();
        retryService.doRetry3();
    }

    /**
     * case 4: use retry template
     *
     */
    @PostMapping(path = "retry4")
    public void retryEndPoint4() throws Exception {
        retryService.doRetry4();
    }

    /**
     * case 4: use retry template
     *
     */
    @PostMapping(path = "retry5")
    public void retryEndPoint5() throws Exception {
        retryService.callMockPost();
    }


}
