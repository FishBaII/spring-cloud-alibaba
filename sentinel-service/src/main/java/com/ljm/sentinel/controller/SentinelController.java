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
    @SentinelResource(value = "relate", blockHandler = "myBlockHandle")
    public String relateTest() throws InterruptedException {

        Thread.sleep(10 * 1000);
        return "relate!";

    }

    @GetMapping("/hotKey")
    @SentinelResource(value = "hotkey", blockHandler = "myBlockHandle")
    public String hotKey(@RequestParam(required = false) String t1, @RequestParam(required = false) String t2){

        System.out.println("hotKey entering");
        return "hotKey";

    }

    //custom Block Handle
    public String myBlockHandle(BlockException blockException){
        System.out.println("my blocker!");
        return "myBlockHandle";

    }
}
