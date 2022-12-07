package com.ljm.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class SentinelServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelServiceApplication.class, args);



//        while (true) {
//            // 1.5.0 版本开始可以直接利用 try-with-resources 特性
//            try (Entry entry = SphU.entry("hotkey")) {
//                // 被保护的逻辑
//                System.out.println("hello world-------");
//            } catch (BlockException ex) {
//                // 处理被流控的逻辑
//                System.out.println("blocked!-----------");
//            }
//        }
    }



}
