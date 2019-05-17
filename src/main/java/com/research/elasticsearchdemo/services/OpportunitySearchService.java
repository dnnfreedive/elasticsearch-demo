package com.research.elasticsearchdemo.services;

import com.research.elasticsearchdemo.dao.OpportunityRepository;
import com.research.elasticsearchdemo.model.Criteria;
import com.research.elasticsearchdemo.model.Opportunity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class OpportunitySearchService {

    private final OpportunityRepository opportunityRepository;


    @Autowired
    public OpportunitySearchService(OpportunityRepository opportunityRepository) {
        this.opportunityRepository = opportunityRepository;
    }

    public List<Opportunity> findOpportunityByResearchField(Criteria searchCriteria) {
        if (!StringUtils.isEmpty(searchCriteria)) {
            return opportunityRepository.findByResearchField(searchCriteria.getResearchField()).getContent();
        }
        return Collections.EMPTY_LIST;
    }
}
