package com.ljm.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sentinel")
public class SentinelController {

    @GetMapping("/success")
    public String saySuccess(){
        return "Success";
    }

    @GetMapping("/qps")
    @SentinelResource(value = "qps", blockHandler = "myBlockHandle")
    public String qpsTest(){
        return "QPS!";
    }

    @GetMapping("/relate")
    @SentinelResource(value = "relate", blockHandler = "myBlockHandler")
    public String relateTest() throws InterruptedException {

        Thread.sleep(10 * 1000);
        return "relate!";

    }

    @GetMapping("/hotkey")
    @SentinelResource(value = "hotkey",blockHandler = "myBlockHandler1")
    public String hotkeyTest(Integer goodId, String userType){
        return "goodId: " + goodId + " userType: " + userType;
    }

    //custom Block Handle
    public String myBlockHandler(BlockException blockException){
        System.out.println("my blocker!");
        return "myBlockHandler";

    }

    //custom Block Handle
    public String myBlockHandler1(Integer goodId, String userType, BlockException blockException){
        System.out.println("my blocker!");
        return "myBlockHandler";
    }
}
