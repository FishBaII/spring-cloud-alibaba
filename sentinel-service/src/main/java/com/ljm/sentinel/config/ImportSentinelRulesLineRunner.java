package com.ljm.sentinel.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowItem;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRuleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ImportSentinelRulesLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        //get rule from database or file or static

        setFlowRuleManager();
        setHotKeyRuleManager();


    }

//    private static void setFlowRuleManager(){
//
//        List<FlowRule> rules = new ArrayList<>();
//        FlowRule qpsRule = new FlowRule();
//        //资源
//        qpsRule.setResource("qps");
//        //阈值类型
//        qpsRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        //单机阈值
//        qpsRule.setCount(2);
//        //流控效果
//        qpsRule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_DEFAULT);
//        //调用关系限流策略
//        qpsRule.setStrategy(RuleConstant.STRATEGY_DIRECT);
//        rules.add(qpsRule);
//        //将规则载入sentinel服务中生效
//        FlowRuleManager.loadRules(rules);
//    }

    private static void setFlowRuleManager(){
        //
        //set rule for qps url
        List<FlowRule> rules = new ArrayList<>();
        FlowRule qpsRule = new FlowRule();
        qpsRule.setResource("qps");
        qpsRule.setGrade(RuleConstant.FLOW_GRADE_THREAD);
        // Set limit QPS to 2
        qpsRule.setCount(1);
        qpsRule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_DEFAULT);
        qpsRule.setStrategy(RuleConstant.STRATEGY_RELATE);
        qpsRule.setRefResource("relate");
        rules.add(qpsRule);
        FlowRuleManager.loadRules(rules);
    }




    private static void setHotKeyRuleManager(){

//        //热点规则：第一个参数值如为10，阈值为2，否则阈值为4，限流处理默认为快速失败
//        ParamFlowRule rule = new ParamFlowRule("hotkey")
//                .setParamIdx(0)
//                .setCount(4);
//        // 针对 int 类型的参数 10，单独设置限流 QPS 阈值为 2，而不是全局的阈值 4.
//        ParamFlowItem item = new ParamFlowItem().setObject(String.valueOf(10))
//                .setClassType(Integer.class.getName())
//                .setCount(2);
//        rule.setParamFlowItemList(Collections.singletonList(item));
//
//        ParamFlowRuleManager.loadRules(Collections.singletonList(rule));


        //热点规则：第二个参数值如为“vip”，阈值为50，否则阈值为4，限流处理默认为快速失败
        ParamFlowRule pRule = new ParamFlowRule("hotkey")
                .setParamIdx(1)
                .setCount(4);
        // 针对 参数值vip，单独设置限流 QPS 阈值为 50，而不是全局的阈值 4.
        ParamFlowItem item1 = new ParamFlowItem().setObject("vip")
                .setClassType(String.class.getName())
                .setCount(50);
        pRule.setParamFlowItemList(Collections.singletonList(item1));

        ParamFlowRuleManager.loadRules(Collections.singletonList(pRule));

    }

}
