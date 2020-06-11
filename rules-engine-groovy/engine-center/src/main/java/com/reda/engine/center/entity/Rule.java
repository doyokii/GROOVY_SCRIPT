package com.reda.engine.center.entity;

import java.util.Date;
/**
 * @author : Zhuang Jialong
 * @description : 规则实体
 * @date : 2020/6/10 4:03 PM
 * @Copyright: Copyright(c)2019 RedaFlight.com All Rights Reserved
 */
public class Rule {
    private String uuid;
    private String ruleName;
    private String ruleBody;
    private String ruleStatus;
    private String createBy;
    private Date createDate;
    private Date updateDate;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleBody() {
        return ruleBody;
    }

    public void setRuleBody(String ruleBody) {
        this.ruleBody = ruleBody;
    }

    public String getRuleStatus() {
        return ruleStatus;
    }

    public void setRuleStatus(String ruleStatus) {
        this.ruleStatus = ruleStatus;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
