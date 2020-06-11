package com.reda.engine.center.service;

import com.reda.engine.center.entity.Rule;

public interface RuleManageService {
    String createNewRule(Rule rule);

    void updateRule(Rule rule);

    void runRule(Rule rule);

    void deleteRule(Rule rule);
}
