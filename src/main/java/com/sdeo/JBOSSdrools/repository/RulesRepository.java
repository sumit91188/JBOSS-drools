package com.sdeo.JBOSSdrools.repository;

import com.sdeo.JBOSSdrools.model.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sumit Deo
 */
public interface RulesRepository extends JpaRepository<Rule, Long> {
    Rule findByRuleKey(String ruleKey);
}
