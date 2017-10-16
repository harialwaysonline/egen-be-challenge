package com.egen.weightanalyzer.rules.rule.impl;

import com.egen.weightanalyzer.repository.dataobjects.MetricDO;
import com.egen.weightanalyzer.rules.AbstractWeightRule;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Rule(name = "UnderWeightRule", description = "Person is Under weight")
public class UnderWeightRule extends AbstractWeightRule{

    public UnderWeightRule(MetricDO metricDO, int baseWeight) {
        super(metricDO, baseWeight);
    }

    public UnderWeightRule(){

    }
    @Condition
    public boolean whenWeightUnderThanBaseWeight(@Fact("isUnderWeight") boolean isUnderWeight  ) {
        return isUnderWeight;
    }

    @Action
    public void save() throws Exception {
        saveAlert("UnderWeightRule", "Person is Under weight");
    }

}
