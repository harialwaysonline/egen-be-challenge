package com.egen.weightanalyzer.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "OverWeightRule", description = "Person is Over weight")
public class OverWeightRule {

        @Condition
        public boolean whenWeightOverThanBaseWeight(@Fact("isOverWeight") boolean isOverWeight  ) {
            return isOverWeight;
        }

        @Action
        public void save() throws Exception {
            //save to Metric DB
            System.out.println("hello world");
        }

}
