package com.reda.engine.center.service.impl;

import com.reda.engine.center.component.GroovyScript;
import com.reda.engine.center.dao.RuleManageDao;
import com.reda.engine.center.entity.Rule;
import com.reda.engine.center.factory.GroovyInstanceFactory;
import com.reda.engine.center.service.RuleManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import static redis.clients.jedis.HostAndPort.localhost;

@Service
public class RuleManageServiceImpl implements RuleManageService {
    @Autowired
    private RuleManageDao ruleManageDao;

    private static Jedis jedis;

    @Override
    public String createNewRule(Rule rule) {
        if (jedis == null){registerRule();}
        if (jedis.exists(rule.getRuleName())) {
            return "duplicate rule：rename or check out ！";
        }
        try {
            ruleManageDao.insert(rule);
            jedis.set(rule.getRuleName(),rule.getRuleBody());
            GroovyInstanceFactory.registerRule(rule.getRuleBody(),rule.getRuleName());
        } catch (Exception e) {
            return "fail";
        }
        return "succeed";
    }

    @Override
    public void updateRule(Rule rule) {
        //fixme update sql

    }

    @Override
    public void runRule(Rule rule) {
        if(jedis.exists(rule.getRuleName())){
            GroovyInstanceFactory.execute(rule.getRuleName());
        }
    }

    @Override
    public void deleteRule(Rule rule) {
        //fixme delete sql
        GroovyInstanceFactory.destroyBean(rule.getRuleName());
    }

    public String stop(Rule rule){
        if (jedis.exists(rule.getRuleName())){
            jedis.del(rule.getRuleName());
            return "succeed";
        }
        return "fail";
    }

    public Jedis registerRule() {
        jedis = new Jedis("192.168.2.111", 6379);
        jedis.connect();
        return jedis;
    }
}

