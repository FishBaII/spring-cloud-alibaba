package com.ljm.sentinel.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ImportSentinelRulesLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        //get rule from database or file or static

        setFlowRuleManager();



    }

    private static void setFlowRuleManager(){

        //set rule for qps url
        List<FlowRule> rules = new ArrayList<>();
        FlowRule qpsRule = new FlowRule();
        qpsRule.setResource("qps");
        qpsRule.setGrade(RuleConstant.FLOW_GRADE_THREAD);
        // Set limit QPS to 2
        qpsRule.setCount(1);
        qpsRule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_WARM_UP_RATE_LIMITER);
        qpsRule.setStrategy(RuleConstant.STRATEGY_RELATE);
        qpsRule.setRefResource("relate");
        rules.add(qpsRule);
        FlowRuleManager.loadRules(rules);
    }

//    private static void setFlowRuleManager(){
//
//        //set rule for qps url
//        List<FlowRule> rules = new ArrayList<>();
//        FlowRule qpsRule = new FlowRule();
//        qpsRule.setResource("qps");
//        qpsRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        // Set limit QPS to 2
//        qpsRule.setCount(2);
//        rules.add(qpsRule);
//        FlowRuleManager.loadRules(rules);
//    }

}
