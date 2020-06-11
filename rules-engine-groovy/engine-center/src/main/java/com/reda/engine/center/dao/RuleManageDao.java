package com.reda.engine.center.dao;

import com.reda.engine.center.entity.Rule;

import java.util.List;

public interface RuleManageDao {
    void insert(Rule rule) throws Exception;

    List selectAll();

    void delete(Rule rule);

    void update(Rule rule);
}
