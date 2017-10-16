package com.egen.weightanalyzer.rules.rule.impl;

import com.egen.weightanalyzer.repository.dataobjects.MetricDO;
import com.egen.weightanalyzer.rules.AbstractWeightRule;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "OverWeightRule", description = "Person is Over weight")
public class OverWeightRule extends AbstractWeightRule {


    public OverWeightRule(MetricDO metricDO, int baseWeight) {
        super(metricDO, baseWeight);
    }

    @Condition
    public boolean whenWeightOverThanBaseWeight(@Fact("isOverWeight") boolean isOverWeight) {
        return isOverWeight;
    }

    @Action
    public void save() throws Exception {
        saveAlert("OverWeightRule", "Person is Over weight");
    }

}
