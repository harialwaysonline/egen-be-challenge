package com.egen.weightanalyzer.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;


@Rule(name = "UnderWeightRule", description = "Person is Under weight")
public class UnderWeightRule {

    @Condition
    public boolean whenWeightUnderThanBaseWeight(@Fact("isUnderWeight") boolean isUnderWeight  ) {
        return true;
    }

    @Action
    public void save() throws Exception {

        //save to AlertDB
        System.out.println("hello world");
    }

}
