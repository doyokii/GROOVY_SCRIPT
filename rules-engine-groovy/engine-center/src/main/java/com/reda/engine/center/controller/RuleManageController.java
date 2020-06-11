package com.reda.engine.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.reda.engine.center.entity.Rule;
import com.reda.engine.center.service.RuleManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//fixme RestController和Controller区别
//restController相当于ResponseBody＋ @Controller的作用
@RestController
@RequestMapping("rule/manage")
public class RuleManageController {

    @Autowired
    private RuleManageService ruleManageService;

    /**
     * 规则创建
     *
     * @param value
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createRule(@RequestBody String value) {
        Rule rule = JSONObject.parseObject(value, Rule.class);
        return ruleManageService.createNewRule(rule);
    }

    /**
     * 规则更新
     *
     * @param value
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateRule(String value) {
        Rule rule = JSONObject.parseObject(value, Rule.class);
        ruleManageService.updateRule(rule);
    }

    /**
     * 运行规则
     *
     * @param value
     */
    @RequestMapping(value = "/run", method = RequestMethod.POST)
    public void runRule(String value) {
        Rule rule = JSONObject.parseObject(value, Rule.class);
        ruleManageService.runRule(rule);
    }

    @RequestMapping(value = "/stop", method = RequestMethod.POST)
    public void stopRule(String value) {
        Rule rule = JSONObject.parseObject(value, Rule.class);
    }

    /**
     * 删除规则
     *
     * @param value
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteRule(String value) {
        Rule rule = JSONObject.parseObject(value, Rule.class);
        ruleManageService.deleteRule(rule);
    }

    public static void main(String[] args) {
        Rule rule = new Rule();
        rule.setRuleName("testName");
        rule.setRuleBody("testBody");
        System.out.println(JSONObject.toJSON(rule));

        String jsonTest = "{\"ruleBody\":\"testBody\",\"ruleName\":\"testName\"}\n";
    }
}
