package com.egen.weightanalyzer.rules.ruleprocessors;

import com.egen.weightanalyzer.repository.dataobjects.MetricDO;
import com.egen.weightanalyzer.rules.rule.impl.OverWeightRule;
import com.egen.weightanalyzer.rules.rule.impl.UnderWeightRule;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static org.jeasy.rules.core.RulesEngineBuilder.aNewRulesEngine;

@Component
@Scope("prototype")
public class WeightRuleProcessor{


    private Rules rules;
    private RulesEngine rulesEngine;
    @Autowired
    OverWeightRule overWeightRule;
    @Autowired
    UnderWeightRule underWeightRule;
    static Logger logger = Logger.getLogger(WeightRuleProcessor.class);
    public static final int baseWeight = 150;

    public WeightRuleProcessor() {
        BasicConfigurator.configure();
        rulesEngine = aNewRulesEngine().withSilentMode(true).build();
        rules = new Rules();
    }

    public void process(MetricDO metricDO) {
        rules.register(overWeightRule);
        rules.register(underWeightRule);
        logger.info("Before handling the request");
        underWeightRule.setMetricDO(metricDO);
        underWeightRule.setBaseWeight(baseWeight);
        overWeightRule.setMetricDO(metricDO);
        overWeightRule.setBaseWeight(baseWeight);
        String weight = metricDO.getValue();
        boolean isOverWeight = weight.isEmpty() ? false : (Integer.parseInt(weight) > baseWeight ? true : false);
        /*if (isOverWeight) {
            rules.register(new OverWeightRule(metricDO, baseWeight));
        } else if (!StringUtils.isEmpty(weight) && (Integer.parseInt(weight) == baseWeight)) {
            rules.register(new UnderWeightRule(metricDO, baseWeight));
        }*/
        Facts facts = new Facts();
        facts.put("isOverWeight", isOverWeight);
        facts.put("isUnderWeight", !isOverWeight);
        rulesEngine.fire(rules, facts);
    }
}
